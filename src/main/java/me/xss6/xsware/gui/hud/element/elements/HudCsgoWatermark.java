package me.xss6.xsware.gui.hud.element.elements;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.gui.hud.element.HudElement;
import me.xss6.xsware.hack.hacks.client.HudEditor;
import me.xss6.xsware.util.HudUtil;
import me.xss6.xsware.util.RenderUtil2D;
import me.xss6.xsware.util.elements.Colour;
import me.xss6.xsware.util.elements.Rainbow;

@HudElement.Element(name = "CSGO Watermark", posX = 100, posY = 100)
public class HudCsgoWatermark extends HudElement {
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
    public void onRender2D(Render2DEvent event) {
        int padding = 5;
        Colour fill = new Colour(77, 77, 77, 255);
        Colour outline = new Colour(127, 127, 127, 255);
        RenderUtil2D.drawBorderedRect(this.getX() - padding, this.getY() - padding,
                this.getX() + padding + this.getWidth(), this.getY() + padding + this.getHeight() - 1, 1, fill.hashCode(), outline.hashCode(), false);
        RenderUtil2D.drawHLineG(this.getX() - padding, this.getY() - padding,
                (this.getX() + padding + this.getWidth()) - (this.getX() - padding), Rainbow.getColour().hashCode(), Rainbow.getFurtherColour(HudEditor.INSTANCE.welcomerOffset.getValue()).hashCode());
        text = ChatFormatting.GOLD + "XS" + ChatFormatting.RESET + "WARE";
        if (HudEditor.INSTANCE.welcomerName.getValue()) {
            text += " | " + mc.player.getName();
        }
        if (HudEditor.INSTANCE.welcomerFps.getValue()) {
            text += " |" + HudUtil.getFpsLine() + ChatFormatting.RESET;
        }
        if (HudEditor.INSTANCE.welcomerTps.getValue()) {
            text += " |" + HudUtil.getTpsLine() + ChatFormatting.RESET;
        }
        if (HudEditor.INSTANCE.welcomerPing.getValue()) {
            text += " |" + HudUtil.getPingLine() + ChatFormatting.RESET;
        }
        if (HudEditor.INSTANCE.welcomerTime.getValue()) {
            text += " | " + HudUtil.getAnaTimeLine() + ChatFormatting.RESET;
        }
        if (HudEditor.INSTANCE.customFont.getValue()) {
            XSWARE.GUI_FONT_MANAGER.drawStringRainbow(text, getX(), getY(), true);
        }
        HudUtil.drawHudString(text, getX(), getY(), HudEditor.INSTANCE.fontColor.getValue().hashCode());
    }

}
