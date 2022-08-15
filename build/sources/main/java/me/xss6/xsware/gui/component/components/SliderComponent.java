package me.xss6.xsware.gui.component.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.gui.component.HackButton;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.setting.type.DoubleSetting;
import me.xss6.xsware.setting.type.IntSetting;
import me.xss6.xsware.util.MathsUtil;
import me.xss6.xsware.util.RenderUtil2D;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author XSS6
 * @since 29/04/2021
 * fat cock
 */

public class SliderComponent extends Component {
    private boolean hovered;

    private final HackButton parent;
    private DoubleSetting setD = null;
    private IntSetting setI = null;
    private int offset;
    private int x;
    private int y;
    private boolean isChild;
    private boolean dragging = false;

    private double renderWidth;

    public SliderComponent(DoubleSetting value, HackButton button, int offset) {
        this.setD = value;
        this.parent = button;
        this.offset = offset;
        isChild = value.isChild();
        this.x = button.parent.getX() + button.parent.getWidth();
        this.y = button.parent.getY() + button.offset;
        setShown(true);
    }

    public SliderComponent(IntSetting value, HackButton button, int offset) {
        this.setI = value;
        this.parent = button;
        this.offset = offset;
        isChild = value.isChild();
        this.x = button.parent.getX() + button.parent.getWidth();
        this.y = button.parent.getY() + button.offset;
        setShown(true);
    }

    @Override
    public void renderComponent(int mouseX, int mouseY) {
        if(!isShown())return;
        net.minecraft.client.gui.Gui.drawRect(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET, this.hovered ? XswareGuiNew.GUI_HOVERED_COLOR() : isChild ? XswareGuiNew.GUI_CHILDBUTTON() : XswareGuiNew.GUI_COLOR());
        RenderUtil2D.drawGradientRect(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + (int) renderWidth, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET,
                (Gui.INSTANCE.buttonColor.getValue().hashCode()),
                (Gui.INSTANCE.buttonColor.getValue().hashCode()), hovered);
        if (Gui.INSTANCE.customFont.getValue()) {
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(isInt() ? this.setI.getName() + " " + ChatFormatting.GRAY + MathsUtil.round(this.setI.getValue(), 2) : this.setD.getName() + " " + ChatFormatting.GRAY + this.setD.getValue(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
        } else {
            mc.fontRenderer.drawStringWithShadow(isInt() ? this.setI.getName() + " " + ChatFormatting.GRAY + MathsUtil.round(this.setI.getValue(), 2) : this.setD.getName() + " " + ChatFormatting.GRAY + this.setD.getValue(), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
        }
    }

    @Override
    public void setOff(int newOff) {
        offset = newOff;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        boolean old = isShown();
        if(setD == null){
            setShown(setI.isShown());
        }else {
            setShown(setD.isShown());
        }
        if(old != isShown()){
            this.parent.init(parent.mod, parent.parent, parent.offset, true);
        }
        this.hovered = isMouseOnButton(mouseX, mouseY);
        this.y = parent.parent.getY() + offset;
        this.x = parent.parent.getX();

        int widthTest = XswareGuiNew.WIDTH - (XswareGuiNew.SETTING_OFFSET * 2);
        double diff = Math.min(widthTest, Math.max(0, mouseX - this.x));
        if (isInt()) {
            int min = setI.getMin();
            int max = setI.getMax();

            renderWidth = (widthTest) * (float)(setI.getValue() - min) / (max - min) + XswareGuiNew.SETTING_OFFSET;

            if (dragging) {
                if (diff == 0) {
                    setI.setValue(setI.getMin());
                } else {
                    int newValue = (int) roundToPlace(((diff / widthTest) * (max - min) + min), 2);
                    setI.setValue(newValue);
                }
            }
        } else {

            double min = setD.getMin();
            double max = setD.getMax();

            renderWidth = (widthTest) * (setD.getValue() - min) / (max - min) + XswareGuiNew.SETTING_OFFSET;

            if (dragging) {
                if (diff == 0) {
                    setD.setValue(setD.getMin());
                } else {
                    double newValue = roundToPlace(((diff / widthTest) * (max - min) + min), 2);
                    setD.setValue(newValue);
                }
            }
        }
    }
    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if(!isShown())return;
        if (isMouseOnButtonD(mouseX, mouseY) && button == 0 && this.parent.isOpen) {
            dragging = true;
        }
        if (isMouseOnButtonI(mouseX, mouseY) && button == 0 && this.parent.isOpen) {
            dragging = true;
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        dragging = false;
    }


    private static double roundToPlace(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }



    public boolean isMouseOnButtonD(int x, int y) {
        return x > this.x + XswareGuiNew.SETTING_OFFSET && x < this.x + (parent.parent.getWidth() / 2 + 1) - XswareGuiNew.SETTING_OFFSET && y > this.y && y < this.y + XswareGuiNew.HEIGHT;
    }

    public boolean isMouseOnButtonI(int x, int y) {
        return x > this.x + parent.parent.getWidth() / 2 + XswareGuiNew.SETTING_OFFSET && x < this.x + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET && y > this.y && y < this.y + XswareGuiNew.HEIGHT;
    }

    public boolean isMouseOnButton(int x, int y) {
        return x > this.parent.parent.getX() + XswareGuiNew.SETTING_OFFSET && x < this.parent.parent.getX() + XswareGuiNew.WIDTH - XswareGuiNew.SETTING_OFFSET && y > this.parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET && y < this.parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
    }

    public boolean isInt() {
        return setI != null;
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
