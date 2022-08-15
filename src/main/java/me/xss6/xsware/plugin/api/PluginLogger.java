package me.xss6.xsware.plugin.api;

import me.xss6.xsware.XSWARE;

/**
 * @author XSS6
 * @since 21/06/2021
 */

public class PluginLogger {
    public static void print(String msg){
        XSWARE.LOGGER.info("Plugin -> " + msg);
    }
}
