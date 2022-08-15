package me.xss6.xsware.event.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author XSS6
 * @since 04/06/2021
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CommitEvent {
    public EventPriority priority() default EventPriority.NONE;
}
