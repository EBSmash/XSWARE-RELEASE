package me.xss6.xsware.event;

import me.xss6.xsware.event.processor.Event;

public class EventStage extends Event {
    private int stage;

    public EventStage() {
    }

    public EventStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return this.stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}

