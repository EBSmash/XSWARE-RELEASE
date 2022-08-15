package me.xss6.xsware.hack.hacks.misc;

import me.xss6.xsware.RPC;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.HackPriority;


@Hack.Registration(name = "Discord RPC", description = "It is discordrpc !", category = Hack.Category.MISC, priority = HackPriority.Lowest)
public class DiscordRPC extends Hack {


    public void onEnable() {
        RPC.startRPC();
    }

    public void onDisable() {
        RPC.stopRPC();
    }
}
