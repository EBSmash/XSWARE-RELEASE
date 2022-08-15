package me.xss6.xsware.gui.hud.element.elements;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.gui.hud.element.HudElement;
import me.xss6.xsware.hack.hacks.client.HudEditor;
import me.xss6.xsware.util.HudUtil;

/**
 * @author XSS6
 * @since 22/06/2021
 */
@HudElement.Element(name = "Watermark", posX = 100, posY = 100)
public class HudWatermark extends HudElement{
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
        text = ChatFormatting.GOLD + XSWARE.MODNAME + ChatFormatting.RESET
                + " v" + XSWARE.INSTANCE.MODVER;
        HudUtil.drawHudString(text, getX(), getY(), HudEditor.INSTANCE.fontColor.getValue().hashCode());
    }
}
