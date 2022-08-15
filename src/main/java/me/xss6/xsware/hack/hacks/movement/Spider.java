package me.xss6.xsware.hack.hacks.movement;

import me.xss6.xsware.hack.Hack;
import net.minecraft.client.Minecraft;
@Hack.Registration(name = "Spider", description = "Spiderman, Spiderman", category = Hack.Category.MOVEMENT, isListening = false)

public class Spider extends Hack{

    public void onTick() {
        if(mc.player.collidedHorizontally) {
            Minecraft.getMinecraft().player.motionY = (0.2);
            Minecraft.getMinecraft().player.fallDistance = 0;


            if(Minecraft.getMinecraft().player.motionY < 0.15D) {
                Minecraft.getMinecraft().player.motionY = (-0.15D);
            }

        }
    }
}
