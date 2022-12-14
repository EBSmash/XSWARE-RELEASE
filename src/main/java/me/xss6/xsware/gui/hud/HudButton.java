package me.xss6.xsware.gui.hud;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.component.CategoryComponent;
import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.gui.hud.element.HudDragComponent;
import me.xss6.xsware.gui.hud.element.HudElement;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.util.RenderUtil2D;
import me.xss6.xsware.util.Globals;

import java.util.ArrayList;

/**
 * @author XSS6
 * @since 17/06/2021
 */

public class HudButton extends Component {

    public final HudElement element;
    public final CategoryComponent parent;
    public int offset;
    private boolean isHovered;
    private final ArrayList<HudDragComponent> dragComponents = new ArrayList<>();

    public HudButton(HudElement element, CategoryComponent parent, int offset){
        this.element = element;
        this.parent = parent;
        this.offset = offset;
        this.dragComponents.add(new HudDragComponent(element, element.getWidth(), element.getHeight()));
    }

    @Override
    public void renderComponent(int MouseX, int MouseY) {
        if (element.isEnabled()) {
            RenderUtil2D.drawGradientRect(parent.getX() + XswareGuiNew.MODULE_WIDTH, this.parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET,
                    parent.getX() + parent.getWidth() - XswareGuiNew.MODULE_WIDTH, this.parent.getY() + XswareGuiNew.HEIGHT + this.offset + XswareGuiNew.MODULE_OFFSET,
                    (Gui.INSTANCE.buttonColor.getValue().hashCode()),
                    (Gui.INSTANCE.buttonColor.getValue().hashCode()), isHovered);
            for(HudDragComponent dragComponent : dragComponents){
                dragComponent.renderComponent(MouseX, MouseY);
            }
        } else {
            RenderUtil2D.drawRectMC(parent.getX() + XswareGuiNew.MODULE_WIDTH, this.parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET, parent.getX() + parent.getWidth() - XswareGuiNew.MODULE_WIDTH, this.parent.getY() + XswareGuiNew.HEIGHT + this.offset + XswareGuiNew.MODULE_OFFSET, this.isHovered ? XswareGuiNew.GUI_HOVERED_COLOR() : XswareGuiNew.GUI_MODULECOLOR());
        }
        if (Gui.INSTANCE.customFont.getValue()) {
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(this.element.getName(), parent.getX() + XswareGuiNew.MODULE_FONT_SIZE, parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET + XswareGuiNew.HEIGHT / 2f - XswareGuiNew.FONT_HEIGHT, Gui.INSTANCE.fontColor.getValue().hashCode());
        } else {
            Globals.mc.fontRenderer.drawStringWithShadow(this.element.getName(), parent.getX() + XswareGuiNew.MODULE_FONT_SIZE, parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET + XswareGuiNew.HEIGHT / 2f - XswareGuiNew.FONT_HEIGHT, Gui.INSTANCE.fontColor.getValue().hashCode());
        }
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.isHovered = isMouseOnButton(mouseX, mouseY);
        for(HudDragComponent dragComponent : dragComponents){
            dragComponent.updateComponent(mouseX, mouseY);
        }
    }

    public boolean isMouseOnButton(int x, int y) {
        return x > parent.getX() + XswareGuiNew.MODULE_WIDTH && x < parent.getX() + parent.getWidth() - XswareGuiNew.MODULE_WIDTH && y > this.parent.getY() + this.offset && y < this.parent.getY() + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET + this.offset;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isMouseOnButton(mouseX, mouseY) && button == 0) {
            if (element.getName().equalsIgnoreCase("return")) {
                Globals.mc.displayGuiScreen(XSWARE.GUI2);
                return;
            }
            this.element.toggle();
        }
        for (HudDragComponent dragComponent : dragComponents){
            dragComponent.mouseClicked(mouseX, mouseY, button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        for(HudDragComponent dragComponent : dragComponents){
            dragComponent.mouseReleased(mouseX, mouseY, mouseButton);
        }
    }

    public ArrayList<HudDragComponent> getDragComponents() {
        return this.dragComponents;
    }

}
