package me.xss6.xsware.event.events;

import me.xss6.xsware.event.processor.Event;

/**
 * @author XSS6
 * @since 05/06/2021
 */

public class TestEvent extends Event {
    public long startTime;
    public TestEvent(){
        startTime = System.nanoTime();
    }
}
