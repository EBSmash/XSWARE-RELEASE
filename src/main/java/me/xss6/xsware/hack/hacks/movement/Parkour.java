package me.xss6.xsware.hack.hacks.movement;

import me.xss6.xsware.hack.Hack;
import net.minecraft.entity.Entity;

@Hack.Registration(name = "Parkour", description = "Jumps automatically when on edge of a block", category = Hack.Category.MOVEMENT, isListening = false)

public class Parkour extends Hack{
    public void onTick() {
        if(mc.player.onGround && !mc.player.isSneaking() && !this.mc.gameSettings.keyBindSneak.pressed && this.mc.world.getCollisionBoxes((Entity)mc.player, mc.player.getEntityBoundingBox().offset(0.0D, -0.5D, 0.0D).expand(-0.001D, 0.0D, -0.001D)).isEmpty())
        {
            mc.player.jump();
        }
    }
}
