package me.xss6.xsware.gui.component;


import me.xss6.xsware.XSWARE;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.component.components.*;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.setting.Setting;
import me.xss6.xsware.setting.type.*;
import me.xss6.xsware.setting.type.*;
import me.xss6.xsware.util.RenderUtil;
import me.xss6.xsware.util.RenderUtil2D;
import me.xss6.xsware.gui.component.components.*;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author XSS6
 * @since 29/04/2021
 */

public class HackButton extends Component {

    public Hack mod;
    public CategoryComponent parent;
    private ArrayList<Component> subcomponents;
    private ArrayList<Setting> notInitSettings;
    private ArrayList<Boolean> oldVals;
    public boolean isOpen;
    private boolean isHovered;
    public int offset;
    public int subCompLength = 0;
    public int opY;

    public ArrayList<Component> getChildren() {
        ArrayList<Component> children = new ArrayList<>();
        for (Component component : this.subcomponents) {
            if (component.getParent() == this) {
                children.add(component);
            }
        }
        return children;
    }


    public void init(Hack mod, CategoryComponent parent, int offset, boolean update) {
        if (!update) {
            this.mod = mod;
            this.parent = parent;
            this.offset = offset;
        }

        this.subcomponents = new ArrayList<>();
        this.notInitSettings = new ArrayList<>();
        this.oldVals = new ArrayList<>();
        if (!update) {
            this.isOpen = false;
        }
        opY = offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
        if (XSWARE.SETTINGS.getSettingFromHack(mod) != null) {
            for (Setting s : XSWARE.SETTINGS.getSettingFromHack(mod)) {
                if (s instanceof BooleanSetting) {
                    if (!s.isShown()) {
                        this.notInitSettings.add(s);
                        continue;
                    }
                    this.subcomponents.add(new BooleanComponent((BooleanSetting) s, this, opY));
                    opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
                } else if (s instanceof EnumSetting) {
                    if (!s.isShown()) {
                        this.notInitSettings.add(s);
                        continue;
                    }
                    this.subcomponents.add(new ModeComponent((EnumSetting) s, this, mod, opY));
                    opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
                } else if (s instanceof IntSetting) {
                    if (!s.isShown()) {
                        this.notInitSettings.add(s);
                        continue;
                    }
                    this.subcomponents.add(new SliderComponent((IntSetting) s, this, opY));
                    opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
                } else if (s instanceof DoubleSetting) {
                    if (!s.isShown()) {
                        this.notInitSettings.add(s);
                        continue;
                    }
                    this.subcomponents.add(new SliderComponent((DoubleSetting) s, this, opY));
                    opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
                } else if (s instanceof ColourSetting) {
                    if (!s.isShown()) {
                        this.notInitSettings.add(s);
                        continue;
                    }
                    this.subcomponents.add(new ColorComponent((ColourSetting) s, this, opY));
                    opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
                } else if (s instanceof KeySetting) {
                    if (!s.isShown()) {
                        this.notInitSettings.add(s);
                        continue;
                    }
                    this.subcomponents.add(new KeyBindComponent((KeySetting) s, this, opY));
                    opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
                } else if (s instanceof ParentSetting) {
                    if (!s.isShown()) {
                        this.notInitSettings.add(s);
                        continue;
                    }
                    this.subcomponents.add(new ParentComponent((ParentSetting) s, this, opY));
                    opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
                }
            }
            this.subcomponents.add(new ModuleBindComponent(this, opY));
            opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
            this.subcomponents.add(new ShownComponent(this, opY));
            if(update){
                parent.refresh();
            }
        }
    }

    @Override
    public void setOff(int newOff) {
        offset = newOff;
        int opY = offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
        for (Component comp : this.subcomponents) {
            comp.setOff(opY);
            opY += XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
        }
    }


    @Override
    public void renderComponent(int MouseX, int MouseY) {
        subCompLength = 0;
        if (mod.isEnabled()) {
            RenderUtil2D.drawGradientRect(parent.getX() + XswareGuiNew.MODULE_WIDTH, this.parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET,
                    parent.getX() + parent.getWidth() - XswareGuiNew.MODULE_WIDTH, this.parent.getY() + XswareGuiNew.HEIGHT + this.offset + XswareGuiNew.MODULE_OFFSET,
                    (Gui.INSTANCE.buttonColor.getValue().hashCode()),
                    (Gui.INSTANCE.buttonColor.getValue().hashCode()), isHovered);
        } else {
            RenderUtil2D.drawRectMC(parent.getX() + XswareGuiNew.MODULE_WIDTH, this.parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET, parent.getX() + parent.getWidth() - XswareGuiNew.MODULE_WIDTH, this.parent.getY() + XswareGuiNew.HEIGHT + this.offset + XswareGuiNew.MODULE_OFFSET, this.isHovered ? XswareGuiNew.GUI_HOVERED_COLOR() : XswareGuiNew.GUI_MODULECOLOR());
        }
        if (Gui.INSTANCE.customFont.getValue()) {
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(this.mod.getName(), parent.getX() + XswareGuiNew.MODULE_FONT_SIZE, parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET + XswareGuiNew.HEIGHT / 2f - XswareGuiNew.FONT_HEIGHT, Gui.INSTANCE.fontColor.getValue().hashCode());
        } else {
            mc.fontRenderer.drawStringWithShadow(this.mod.getName(), parent.getX() + XswareGuiNew.MODULE_FONT_SIZE, parent.getY() + this.offset + XswareGuiNew.MODULE_OFFSET + XswareGuiNew.HEIGHT / 2f - XswareGuiNew.FONT_HEIGHT, Gui.INSTANCE.fontColor.getValue().hashCode());
        }
        if (this.isOpen) {
            if (!this.subcomponents.isEmpty()) {
                for (Component comp : this.subcomponents) {
                    if (!comp.isShown()) continue;
                    comp.renderComponent(MouseX, MouseY);
                    if (comp instanceof ColorComponent) {
                        if (((ColorComponent) comp).isOpen()) {
                            subCompLength += 6;
                        } else {
                            subCompLength++;
                        }
                    } else {
                        subCompLength++;
                    }
                }
            }
        }
        renderArrow();
    }

    @Override
    public void renderToolTip(int mouseX, int mouseY){
        if(isHovered && Gui.INSTANCE.toolTips.getValue()){
            int length = XSWARE.GUI_FONT_MANAGER.getTextWidth(mod.getDescription());
            int height = XSWARE.GUI_FONT_MANAGER.getTextHeight();
            RenderUtil2D.drawRectMC(mouseX + 6, mouseY + 9, mouseX + length + 10, mouseY + height + 13, Gui.INSTANCE.toolTipColor.getValue().hashCode());
            XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(mod.getDescription(), mouseX + 8, mouseY + 11, new Color(255,255,255).hashCode());
        }
        for(Component component : subcomponents){
            component.renderToolTip(mouseX, mouseY);
        }
    }

    @Override
    public int getHeight() {
        if (this.isOpen) {
            int val = 0;
            for (Component c : subcomponents) {
                if (!c.isShown()) {
                    val -= 1;
                }
                if (c instanceof ColorComponent) {
                    if (((ColorComponent) c).isOpen()) {
                        val += 5;
                    }
                }
            }
            return ((XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET) * (this.subcomponents.size() + 1 + val));
        }
        return XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.isHovered = isMouseOnButton(mouseX, mouseY);
        if (!this.subcomponents.isEmpty()) {
            for (Component comp : this.subcomponents) {
                comp.updateComponent(mouseX, mouseY);
            }
        }
        if (!this.notInitSettings.isEmpty()) {
            if (oldVals.isEmpty()) {
                for (Setting s : this.notInitSettings) {
                    this.oldVals.add(s.isShown());
                }
            } else {
                int index = 0;
                for (Setting s : this.notInitSettings) {
                    boolean old = oldVals.get(index);
                    boolean init = false;
                    if (s.isShown() != old) {
                        init = true;
                    }
                    index++;
                    if (init) {
                        oldVals.clear();
                        this.init(mod, parent, offset, true);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isMouseOnButton(mouseX, mouseY) && button == 0) {
            this.mod.toggle();
        }
        if (isMouseOnButton(mouseX, mouseY) && button == 1) {
            this.isOpen = !this.isOpen;
            this.parent.refresh();
            for (Component comp : parent.getComponents()) {
                if (comp instanceof HackButton) {
                    if (((HackButton) comp).isOpen) {
                        if (((HackButton) comp).isOpen) {
                            for (Component comp2 : ((HackButton) comp).getChildren()) {
                                if (comp2 instanceof ColorComponent) {
                                    ((ColorComponent) comp2).setOpen(false);
                                    this.parent.refresh();
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Component comp : this.subcomponents) {
            comp.mouseClicked(mouseX, mouseY, button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        for (Component comp : this.subcomponents) {
            comp.mouseReleased(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void keyTyped(char typedChar, int key) {
        for (Component comp : this.subcomponents) {
            comp.keyTyped(typedChar, key);
        }
    }


    public boolean isMouseOnButton(int x, int y) {
        if (x > parent.getX() + XswareGuiNew.MODULE_WIDTH && x < parent.getX() + parent.getWidth() - XswareGuiNew.MODULE_WIDTH && y > this.parent.getY() + this.offset && y < this.parent.getY() + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET + this.offset) {
            return true;
        }
        return false;
    }

    private void renderArrow() {
        switch (Gui.INSTANCE.arrowType.getValue()) {
            case "Type1":
                if (this.isOpen) {
                    RenderUtil.drawTriangleOutline(parent.getX() + 105f, parent.getY() + offset + 12f, 5f, 2, 1, 1, Gui.INSTANCE.fontColor.getValue().hashCode());
                } else {
                    RenderUtil.drawTriangleOutline(parent.getX() + 105f, parent.getY() + offset + 12f, 5f, 1, 2, 1, Gui.INSTANCE.fontColor.getValue().hashCode());
                }
                break;
            case "Type2":
                if (this.isOpen) {
                    GL11.glPushMatrix();
                    GL11.glTranslated(parent.getX() + 102f, parent.getY() + offset + 12f, 0);
                    GL11.glRotatef(-90f, 0f, 0f, 1f);
                    GL11.glTranslated(-(parent.getX() + 102f), -(parent.getY() + offset + 12f), 0);
                    RenderUtil.drawTriangleOutline(parent.getX() + 105f, parent.getY() + offset + 12f, 5f, 2, 1, 1, Gui.INSTANCE.fontColor.getValue().hashCode());
                    GL11.glPopMatrix();
                } else {
                    RenderUtil.drawTriangleOutline(parent.getX() + 105f, parent.getY() + offset + 12f, 5f, 2, 1, 1, Gui.INSTANCE.fontColor.getValue().hashCode());
                }
                break;
        }
    }
}
