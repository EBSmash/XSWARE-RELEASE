package me.xss6.xsware.plugin;

/**
 * @author XSS6
 * @since 06/07/2021
 */

public interface Plugin {
    default void init(){
    }

    default String name(){
        return getClass().getSimpleName();
    }
}
