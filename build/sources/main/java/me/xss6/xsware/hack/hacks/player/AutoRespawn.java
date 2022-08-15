package me.xss6.xsware.hack.hacks.player;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.BooleanSetting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEndCrystal;
import net.minecraft.item.ItemExpBottle;

@Hack.Registration(name = "AutoRespawn", description = "Respawns you automatically on death", category = Hack.Category.PLAYER)
public class AutoRespawn extends Hack {
	@Override
	public void onTick() {
		if(mc.player.isDead)
		{
			mc.player.respawnPlayer();
		}

	}
}
