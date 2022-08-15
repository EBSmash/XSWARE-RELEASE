package me.xss6.xsware.hack.hacks.misc;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.HackPriority;

@Hack.Registration(name = "NoRotate", description = "Could cause desync", category = Hack.Category.MISC, priority = HackPriority.Lowest)
public class NoRotate extends Hack{
    public static NoRotate INSTANCE;

    public NoRotate(){
        INSTANCE = this;
    }
}
