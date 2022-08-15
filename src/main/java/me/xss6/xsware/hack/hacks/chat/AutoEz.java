package me.xss6.xsware.hack.hacks.chat;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.HackPriority;
import me.xss6.xsware.setting.type.BooleanSetting;
import net.minecraft.network.play.client.CPacketChatMessage;


@Hack.Registration(name = "Auto Ez", description = "lets people know how good XSWARE is", category = Hack.Category.CHAT, priority = HackPriority.Lowest)
public class AutoEz extends Hack {
    public static AutoEz INSTANCE;
    public AutoEz() {
        INSTANCE = this;
    }
    BooleanSetting discord = new BooleanSetting("Discord", false, this);

    private int delayCount;

    @Override
    public void onEnable() {
        this.delayCount = 0;
    }

    @Override
    public void onUpdate() {
        delayCount++;
    }

    public void announceDeath() {
        if (this.delayCount < 150 || !this.isEnabled()) return;
        delayCount = 0;
        mc.player.connection.sendPacket(new CPacketChatMessage("you just got nae nae'd by XSWARE" + (discord.getValue() ? " | discord.gg/shop2b" : "")));
    }

}
