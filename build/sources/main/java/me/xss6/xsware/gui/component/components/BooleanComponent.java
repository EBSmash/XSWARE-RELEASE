package me.xss6.xsware.gui.component.components;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.gui.component.HackButton;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.setting.type.BooleanSetting;
import me.xss6.xsware.util.RenderUtil2D;

import java.awt.*;

/**
 * @author XSS6
 * @since 29/04/2021
 */

public class BooleanComponent extends Component {
    private boolean hovered;
    private BooleanSetting option;
    private final HackButton parent;
    private int offset;
    private int x;
    private int y;

    public BooleanComponent(BooleanSetting option, HackButton button, int offset) {
        this.option = option;
        this.parent = button;
        this.offset = offset;
        this.x = button.parent.getX() + button.parent.getWidth();
        this.y = button.parent.getY() + button.offset;
        setShown(true);
    }


    @Override
    public void renderComponent(int mouseX, int mouseY) {
        if(!isShown())return;
        XswareGuiNew.drawRect(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET, this.hovered ? XswareGuiNew.GUI_HOVERED_COLOR() : this.option.isChild() ? XswareGuiNew.GUI_CHILDBUTTON() : XswareGuiNew.GUI_COLOR());
        RenderUtil2D.drawBorderedRect(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET + 85, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + 115 - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET - 3, 1, !this.option.getValue() ? XswareGuiNew.GUI_COLOR() : Gui.INSTANCE.buttonColor.getValue().hashCode(), new Color(0, 0, 0, 200).hashCode(), this.hovered);
        RenderUtil2D.drawRectMC(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET + (this.option.getValue() ? 95 : 88), parent.parent.getY() + offset + 5 + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + (this.option.getValue() ? 112 : 105) - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET - 5, new Color(50, 50, 50, 255).hashCode());
        if (Gui.INSTANCE.customFont.getValue()) {
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(this.option.getName(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
        } else {
            mc.fontRenderer.drawStringWithShadow(this.option.getName(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
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
        if (isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.isOpen) {
            this.option.setValue(!option.getValue());
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

