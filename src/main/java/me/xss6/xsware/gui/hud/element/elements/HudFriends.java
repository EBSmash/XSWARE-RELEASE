package me.xss6.xsware.gui.hud.element.elements;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.event.events.Render2DEvent;
import me.xss6.xsware.gui.hud.element.HudElement;
import me.xss6.xsware.hack.hacks.client.HudEditor;
import me.xss6.xsware.util.HudUtil;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

@HudElement.Element(name = "Friends", posX = 100, posY = 100)
public class HudFriends extends HudElement {

    int biggest = 0;
    int yVal = 0;

    @Override
    public int getHeight(){
        return yVal;
    }

    @Override
    public int getWidth(){
        return biggest;
    }

    @Override
    public void onRender2D(Render2DEvent event){
        yVal = XSWARE.GUI_FONT_MANAGER.getTextHeight();
        List<String> friends = new ArrayList<>();
        for (EntityPlayer player : mc.world.playerEntities) {
            if (XSWARE.FRIEND_MANAGER.isFriend(player.getName())) {
                friends.add(player.getName());
            }
        }
        int y = getY();

        if (friends.isEmpty()) {
            HudUtil.drawHudString(ChatFormatting.BOLD + "No friends online", getX(), y, HudEditor.INSTANCE.fontColor.getValue().hashCode());
            biggest = XSWARE.GUI_FONT_MANAGER.getTextWidth("No friends online");
        } else {
            HudUtil.drawHudString(ChatFormatting.BOLD + "the_fellas", getX(), y, HudEditor.INSTANCE.fontColor.getValue().hashCode());
            y += 12;
            int temp = 0;
            for (String friend : friends) {
                HudUtil.drawHudString(friend, getX(), y, HudEditor.INSTANCE.fontColor.getValue().hashCode());
                if(temp < XSWARE.GUI_FONT_MANAGER.getTextWidth(friend)){
                    temp = XSWARE.GUI_FONT_MANAGER.getTextWidth(friend);
                    if(temp < XSWARE.GUI_FONT_MANAGER.getTextWidth("the_fellas")){
                        temp = XSWARE.GUI_FONT_MANAGER.getTextWidth("the_fellas");
                    }
                }
                y += 12;
                yVal += 12;
            }
            biggest = temp;
        }
    }
}
