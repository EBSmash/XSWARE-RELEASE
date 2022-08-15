package me.xss6.xsware.hack.hacks.chat;

import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.hack.HackPriority;
import me.xss6.xsware.setting.type.BooleanSetting;

@Hack.Registration(name = "Toggle Msgs", description = "Says in chat when you toggle something", category = Hack.Category.CHAT, priority = HackPriority.Lowest)
public class ToggleMessages extends Hack {

    public static ToggleMessages INSTANCE;

    public ToggleMessages() {
        INSTANCE = this;
    }

    public BooleanSetting compact = new BooleanSetting("Compact", true, this);
}
