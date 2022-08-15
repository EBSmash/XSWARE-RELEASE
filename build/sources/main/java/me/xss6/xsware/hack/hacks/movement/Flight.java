package me.xss6.xsware.hack.hacks.movement;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.DoubleSetting;
import org.lwjgl.input.Keyboard;

@Hack.Registration(name = "Flight", description = "MOM GET THE CAMERA", category = Hack.Category.MOVEMENT, isListening = false)
public class Flight extends Hack {

	DoubleSetting Flight = new DoubleSetting("Speed", 0.1, 0.0, 10.0, this);

	
	public void onDisable() {
		mc.player.capabilities.isFlying = false;
	}

	
	public void onTick() {
			mc.player.capabilities.isFlying = true;


			if(mc.gameSettings.keyBindJump.isPressed()) {
				mc.player.motionY += 0.2f;
			}
			
			if(mc.gameSettings.keyBindSneak.isPressed())
			{
				mc.player.motionY -= 0.2f;
			}
			
			if(mc.gameSettings.keyBindForward.isPressed()) {
				mc.player.capabilities.setFlySpeed(Flight.getAsFloat());
			}


	}
	

}
