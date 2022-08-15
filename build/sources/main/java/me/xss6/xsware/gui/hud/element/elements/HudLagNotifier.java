package me.xss6.xsware.gui.hud.element.elements;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.gui.hud.element.HudElement;
import me.xss6.xsware.hack.hacks.client.HudEditor;
import me.xss6.xsware.util.HudUtil;

@HudElement.Element(name = "Lag Notifier", posY = 100, posX = 100)
public class HudLagNotifier extends HudElement {
    String length;

    @Override
    public int getWidth(){
        return HudUtil.getHudStringWidth(length);
    }

    @Override
    public void onRender2D(Render2DEvent event){
        length = ChatFormatting.RED + "Server is not responding " + Math.round(XSWARE.SERVER_MANAGER.serverRespondingTime() / 1000.0f);
        if(XSWARE.SERVER_MANAGER.isServerNotResponding()){
            HudUtil.drawHudString(length, getX(), getY(), HudEditor.INSTANCE.fontColor.getValue().hashCode());
        }
    }
}
