package me.xss6.xsware.gui.component.components;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.gui.XswareGuiNew;
import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.gui.component.HackButton;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.setting.type.KeySetting;
import me.xss6.xsware.util.RenderUtil2D;
import org.lwjgl.input.Keyboard;

/**
 * @author XSS6
 * @auther Wallhacks
 * @since 29/04/2021
 */

public class ModuleBindComponent extends Component {
    private boolean isHovered;
    private boolean isBinding;
    private final HackButton parent;
    private KeySetting setting;
    private int offset;
    private int x;
    private int y;
    private final boolean normal;

    private Hack module;

    public ModuleBindComponent(HackButton button, int offset) {
        this.parent = button;
        this.offset = offset;
        this.normal = true;
        this.x = button.parent.getX() + button.parent.getWidth();
        this.y = button.parent.getY() + button.offset;
        setShown(true);
    }

    @Override
    public void renderComponent(int mouseX, int mouseY) {
        if (normal) {
            module = this.parent.mod;
            RenderUtil2D.drawRectMC(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET, this.isHovered ? XswareGuiNew.GUI_HOVERED_COLOR() : XswareGuiNew.GUI_COLOR());
            if (module.getBind() == -1) {
                if (Gui.INSTANCE.customFont.getValue()) {
                    XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + "NONE"), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                } else {
                    mc.fontRenderer.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + "NONE"), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                }
            } else {
                if (Gui.INSTANCE.customFont.getValue()) {
                    XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + getRenderKey()), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                } else {
                    mc.fontRenderer.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + getRenderKey()), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                }
            }

        } else {
            RenderUtil2D.drawRectMC(parent.parent.getX() + XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET, parent.parent.getX() + parent.parent.getWidth() - XswareGuiNew.SETTING_OFFSET, parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET, this.isHovered ? XswareGuiNew.GUI_HOVERED_COLOR() : XswareGuiNew.GUI_COLOR());
            if (setting.getKey() == -1) {
                if (Gui.INSTANCE.customFont.getValue()) {
                    XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + "NONE"), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                } else {
                    mc.fontRenderer.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + "NONE"), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                }
            } else {
                if (Gui.INSTANCE.customFont.getValue()) {
                    XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + getRenderKey()), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                } else {
                    mc.fontRenderer.drawStringWithShadow(isBinding ? "Listening..." : ((module.isHold() ? "Hold" : "Toggle") + " - " + getRenderKey()), parent.parent.getX() + XswareGuiNew.SUB_FONT_SIZE, parent.parent.getY() + offset + 3 + XswareGuiNew.MODULE_OFFSET, Gui.INSTANCE.fontColor.getValue().hashCode());
                }
            }
        }
    }

    @Override
    public void setOff(int newOff) {
        offset = newOff;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.isHovered = isMouseOnButton(mouseX, mouseY);
        this.y = parent.parent.getY() + offset;
        this.x = parent.parent.getX();
    }

    public boolean isMouseOnButton(int x, int y) {
        return x > this.parent.parent.getX() + XswareGuiNew.SETTING_OFFSET && x < this.parent.parent.getX() + XswareGuiNew.WIDTH - XswareGuiNew.SETTING_OFFSET && y > this.parent.parent.getY() + offset + XswareGuiNew.MODULE_OFFSET && y < this.parent.parent.getY() + offset + XswareGuiNew.HEIGHT + XswareGuiNew.MODULE_OFFSET;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (this.isBinding) {
            this.isBinding = false;
            if (normal) {
                switch (button) {
                    case 0:
                        module.setBind(-2);
                        break;
                    case 1:
                        module.setBind(-3);
                        break;
                    case 2:
                        module.setBind(-4);
                        break;
                    case 3:
                        module.setBind(-5);
                        break;
                    case 4:
                        module.setBind(-6);
                        break;

                }
            } else {
                XSWARE.LOGGER.info(button);
                switch (button) {
                    case 0:
                        setting.setKey(-2);
                        break;
                    case 1:
                        setting.setKey(-3);
                        break;
                    case 2:
                        setting.setKey(-4);
                        break;
                    case 3:
                        setting.setKey(-5);
                        break;
                    case 4:
                        setting.setKey(-6);
                        break;
                }
            }
            return;
        }
        if (isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.isOpen) {
            this.isBinding = !this.isBinding;
        }
        if (isMouseOnButton(mouseX, mouseY) && button == 1 && this.parent.isOpen) {
            this.module.toggleHold();
        }
    }

    @Override
    public void keyTyped(char typedChar, int key) {
        if (this.isBinding) {
            if (this.normal) {
                module.setBind(key);
                if (key == Keyboard.KEY_DELETE) {
                    module.setBind(-1);
                }
            } else {
                setting.setKey(key);
                if (key == Keyboard.KEY_DELETE) {
                    setting.setKey(-1);
                }
            }
            this.isBinding = false;
        }
    }

    @Override
    public HackButton getParent() {
        return parent;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    private String getRenderKey() {
        if (normal) {
            if (module == null) return "NONE";
            switch (module.getBind()) {
                case -2:
                    return "M0";
                case -3:
                    return "M1";
                case -4:
                    return "M2";
                case -5:
                    return "M3";
                case -6:
                    return "M4";
                default:
                    return Keyboard.getKeyName(module.getBind());
            }
        } else {
            switch (setting.getKey()) {
                case -2:
                    return "M0";
                case -3:
                    return "M1";
                case -4:
                    return "M2";
                case -5:
                    return "M3";
                case -6:
                    return "M4";
                default:
                    return Keyboard.getKeyName(setting.getKey());
            }
        }
    }
}
