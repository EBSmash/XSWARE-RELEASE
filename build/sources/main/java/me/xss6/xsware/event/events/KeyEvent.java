package me.xss6.xsware.event.events;

import me.xss6.xsware.event.EventStage;

public class KeyEvent
        extends EventStage {
    public boolean info;
    public boolean pressed;

    public KeyEvent(int stage, boolean info, boolean pressed) {
        super(stage);
        this.info = info;
        this.pressed = pressed;
    }
}

