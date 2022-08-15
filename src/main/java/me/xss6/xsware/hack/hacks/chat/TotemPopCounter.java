package me.xss6.xsware.hack.hacks.chat;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.setting.type.BooleanSetting;
import me.xss6.xsware.util.ClientMessage;

@Hack.Registration(name = "Totem Pop Counter", description = "counts totems that people have popped", category = Hack.Category.CHAT)
public class TotemPopCounter extends Hack {
    public static TotemPopCounter INSTANCE;
    public TotemPopCounter(){
        INSTANCE = this;
    }

    public BooleanSetting kdMessages = new BooleanSetting("KD Messages", true, this);

    @Override
    public void onUpdate() {
        if (nullCheck()) return;
        if (!XSWARE.POP_MANAGER.toAnnouce.isEmpty()) {
            try {
                for (String string : XSWARE.POP_MANAGER.toAnnouce) {
                    ClientMessage.sendOverwriteClientMessage(string);
                }
                XSWARE.POP_MANAGER.toAnnouce.clear();
            } catch (Exception e) {
                //empty catchblock goo brrrrrrrrr
            }
        }
    }
}
