package me.xss6.xsware.hack.hacks.movement;

import me.xss6.xsware.hack.Hack;

@Hack.Registration(name = "Jetpack", description = "weeee", category = Hack.Category.MOVEMENT, isListening = false)
public class Jetpack extends Hack{
    @Override
    public void onTick() {
        if(mc.getMinecraft().gameSettings.keyBindJump.pressed)
        {
            mc.getMinecraft().player.jump();
        }
    }
}
