package me.xss6.xsware.hack.hacks.chat;

import me.xss6.xsware.hack.Hack;

@Hack.Registration(name = "Clear Chatbox", description = "makes the chatbox clear", category = Hack.Category.CHAT, isListening = false)
public class ClearChatbox extends Hack {

    public static ClearChatbox INSTANCE;

    public ClearChatbox() {
        INSTANCE = this;
    }

}
