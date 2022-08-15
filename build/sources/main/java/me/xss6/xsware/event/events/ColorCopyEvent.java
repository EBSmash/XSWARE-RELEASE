package me.xss6.xsware.event.events;

import me.xss6.xsware.event.EventStage;
import me.xss6.xsware.gui.component.Component;
import me.xss6.xsware.util.elements.Colour;

public class ColorCopyEvent extends EventStage {
    public Colour copedColor;
    public Component colorComponent;
    public EventType eventType;

    public ColorCopyEvent(Colour val, Component component, EventType eventType){
        this.copedColor = val;
        this.colorComponent = component;
        this.eventType = eventType;
    }

    public enum EventType {
        COPY,
        PAST
    }
}
