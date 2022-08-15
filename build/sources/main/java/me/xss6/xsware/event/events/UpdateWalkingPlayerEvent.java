package me.xss6.xsware.event.events;

import me.xss6.xsware.event.EventStage;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class UpdateWalkingPlayerEvent
        extends EventStage {
    public UpdateWalkingPlayerEvent(int stage) {
        super(stage);
    }
}

