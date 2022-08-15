package me.xss6.xsware.gui.component.components;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.gui.component.HackButton;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.setting.type.ParentSetting;
import me.xss6.xsware.util.RenderUtil2D;

public class ParentComponent extends Component {
    private boolean hovered;
    private ParentSetting option;
    private final HackButton parent;
    private int offset;
    private int x;
    private int y;

    public ParentComponent(ParentSetting option, HackButton button, int offset) {
        this.option = option;
        this.parent = button;
        this.offset = offset;
        this.x = button.parent.getX() + button.parent.getWidth();
        this.y = button.parent.getY() + button.offset;
        this.setShown(true);
    }


    @Override
    public void renderComponent(int mouseX, int mouseY) {
        if(!this.isShown())return;
        RenderUtil2D.drawGradientRect(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET - 2, this.hovered ? Gui.INSTANCE.groupHoverColor.getValue().hashCode(): Gui.INSTANCE.groupColor.getValue().hashCode(), this.hovered ? Gui.INSTANCE.groupHoverColor.getValue().hashCode(): Gui.INSTANCE.groupColor.getValue().hashCode(), isMouseOnButton(mouseX, mouseY));
        XswareGuiNew.drawRect(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET + XswareGuiNew.HEIGHT - 2, parent.parent.getX() + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET, this.hovered ? XswareGuiNew.GUI_HOVERED_COLOR() : XswareGuiNew.GUI_CHILDBUTTON());
        if (Gui.INSTANCE.customFont.getValue()) {
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(this.option.getName(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow((this.option.getValue() ? "-" : "+"), parent.parent.getX() + 90 + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
        } else {
            mc.fontRenderer.drawStringWithShadow(this.option.getName(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
            mc.fontRenderer.drawStringWithShadow((this.option.getValue() ? "-" : "+"), parent.parent.getX() + 90 + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
        }
    }

    @Override
    public void setOff(int newOff) {
        offset = newOff;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.hovered = isMouseOnButton(mouseX, mouseY);
        this.y = parent.parent.getY() + offset;
        this.x = parent.parent.getX();
        boolean old = isShown();
        setShown(this.option.isShown());
        if(old != isShown()){
            this.parent.init(parent.mod, parent.parent, parent.offset, true);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if(!isShown())return;
        if (isMouseOnButton(mouseX, mouseY) && (button == 0 || button == 1) && this.parent.isOpen) {
            this.option.toggle();
        }
    }

    public boolean isMouseOnButton(int x, int y) {
        return x > this.parent.parent.getX() + XswareGuiNew.SETTING_OFFSET && x < this.parent.parent.getX() + XswareGuiNew.WIDTH - XswareGuiNew.SETTING_OFFSET && y > this.parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET && y < this.parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
    }

    @Override
    public HackButton getParent() {
        return parent;
    }

    @Override
    public int getOffset() {
        return offset;
    }
}
