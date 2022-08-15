package me.xss6.xsware.hack.hacks.movement;

import me.xss6.xsware.hack.Hack;

@Hack.Registration(name = "Infinite Jump", description = "Jump.. infinitely", category = Hack.Category.MOVEMENT, isListening = false)
public class InfiniteJump extends Hack{
    @Override
    public void onTick() {
        mc.player.onGround = true;
    }
}
