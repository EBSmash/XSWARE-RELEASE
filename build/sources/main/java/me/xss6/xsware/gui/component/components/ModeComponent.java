package me.xss6.xsware.gui.component.components;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.gui.component.HackButton;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.setting.type.EnumSetting;
import me.xss6.xsware.util.RenderUtil2D;

/**
 * @author XSS6
 * @since 29/04/2021
 */

public class ModeComponent extends Component {

    private boolean hovered;
    private final HackButton parent;
    private final EnumSetting set;
    private int offset;

    private int modeIndex;

    public ModeComponent(EnumSetting set, HackButton button, Hack mod, int offset){
        this.set = set;
        this.parent = button;
        this.offset = offset;
        this.modeIndex = 0;
        setShown(true);
    }
    @Override
    public void renderComponent(int mouseX, int mouseY) {
        if(!isShown())return;
        RenderUtil2D.drawRectMC(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET, this.hovered ? XswareGuiNew.GUI_HOVERED_COLOR() : this.set.isChild() ? XswareGuiNew.GUI_CHILDBUTTON() : XswareGuiNew.GUI_COLOR());
        if (Gui.INSTANCE.customFont.getValue()) {
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(set.getName() + ": " + set.getValue(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
        } else {
            mc.fontRenderer.drawStringWithShadow(set.getName() + ": " + set.getValue(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
        }
    }

    @Override
    public void setOff(int newOff) {
        offset = newOff;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.hovered = isMouseOnButton(mouseX, mouseY);
        boolean old = isShown();
        setShown(this.set.isShown());
        if(old != isShown()){
            this.parent.init(parent.mod, parent.parent, parent.offset, true);
        }
    }
    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if(!isShown())return;
        if (isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.isOpen) {
            increment();
        }

        if (isMouseOnButton(mouseX, mouseY) && button == 1 && this.parent.isOpen) {
            deincrement();
        }

    }

    public void increment() {
        set.setValue(set.getModes().get(((set.getModes().indexOf(set.value) + 1) % set.getModes().size())));
    }

    public void deincrement() {
        set.setValue(set.getModes().get(((set.getModes().indexOf(set.value) - 1) % set.getModes().size())));
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
