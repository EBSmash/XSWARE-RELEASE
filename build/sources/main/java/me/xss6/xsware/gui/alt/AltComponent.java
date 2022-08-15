package me.xss6.xsware.gui.alt;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.util.RenderUtil2D;
import me.xss6.xsware.util.elements.Alt;

import java.awt.*;

/**
 * @author XSS6
 * @since 02/05/2021
 */

public class AltComponent {
    Alt alt;
    int offset;
    MainAltGui parent;

    public AltComponent(Alt alt, int offset, MainAltGui parent) {
        this.alt = alt;
        this.offset = offset;
        this.parent = parent;
    }

    public void render() {
        RenderUtil2D.drawRectMC(MainAltGui.x, MainAltGui.y + offset, MainAltGui.x + MainAltGui.width, MainAltGui.y + offset + MainAltGui.height, MainAltGui.GUI_TRANSPARENCY);
        XSWARE.GUI_FONT_MANAGER.drawStringWithShadow(alt.getUsername(), MainAltGui.x + 20, MainAltGui.y + offset + 10, new Color(255, 255, 255).hashCode());
    }

}
