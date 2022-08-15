package me.xss6.xsware.gui.hud.element.elements;

import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.gui.hud.element.HudElement;
import me.xss6.xsware.hack.hacks.client.HudEditor;
import me.xss6.xsware.util.HudUtil;

/**
 * @author XSS6
 * @since 22/06/2021
 */

@HudElement.Element(name = "Clock", posX = 100, posY = 100)
public class HudClock extends HudElement {

    String text = "";

    @Override
    public int getHeight() {
        return HudUtil.getHudStringHeight();
    }

    @Override
    public int getWidth(){
        return HudUtil.getHudStringWidth(text);
    }

    @Override
    public void onRender2D(Render2DEvent event){
        text = HudUtil.getAnaTimeLine() + " | " + HudUtil.getDate();
        HudUtil.drawHudString(text, this.getX(), this.getY(), HudEditor.INSTANCE.fontColor.getValue().hashCode());
    }
}
