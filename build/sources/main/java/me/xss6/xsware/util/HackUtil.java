package me.xss6.xsware.util;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.hack.Hack;

public class HackUtil implements Globals {

    public static boolean shouldPause(Hack hack) {
        if (XSWARE.HACKS.ishackEnabled("Surround") && !hack.getName().equalsIgnoreCase("Surround")) {
            return true;
        }
        return false;
    }

}
