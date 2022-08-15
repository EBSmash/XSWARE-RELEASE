package me.xss6.xsware.hack.hacks.movement;

import me.xss6.xsware.hack.Hack;

@Hack.Registration(name = "AntiCobweb", description = "Cobwebs don't work on me!!", category = Hack.Category.MOVEMENT, isListening = false)
public class AntiCob extends Hack {
    public void onTick() {
        mc.player.isInWeb = false;
    }
}
