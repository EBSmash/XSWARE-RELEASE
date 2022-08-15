package me.xss6.xsware.hack.hacks.movement;

import me.xss6.xsware.hack.Hack;

@Hack.Registration(name = "Slippers", description = "Oh no I hope I don't fall", category = Hack.Category.MOVEMENT, isListening = false)
public class Slippers extends Hack{
    @Override
    public void onTick() {
        mc.player.onGround = false;
    }
}
