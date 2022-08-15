package me.xss6.xsware.event.events;

import me.xss6.xsware.event.EventStage;
import net.minecraft.entity.player.EntityPlayer;

public class DeathEvent extends EventStage {
    public EntityPlayer player;

    public DeathEvent(EntityPlayer player) {
        this.player = player;
    }
}

