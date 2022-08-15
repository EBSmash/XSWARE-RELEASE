package me.xss6.xsware.command.commands;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.util.ClientMessage;

/**
 * @author XSS6
 * @since 30/05/2021
 */

public class IrcChatCommand extends Command {

    public IrcChatCommand(){
        super("irc");
    }
    @Override
    public void execute(String[] message) {
        if(message[0].equals("set")){
            switch (message[1]) {
                case "global":
                    XSWARE.CLIENT_HANDLING.newClient();
                    XSWARE.CHAT_HANDLING.setRunning(true);
                    XSWARE.CHAT_HANDLING.setToGlobal();
                    XSWARE.CHAT_HANDLING.start();
                    ClientMessage.sendIRCMessage("");
                    break;
                case "direct":
                case "dm":
                    if (message.length > 2) {
                        XSWARE.CLIENT_HANDLING.newClient();
                        XSWARE.CHAT_HANDLING.setRunning(true);
                        XSWARE.CHAT_HANDLING.setToDirect(message[2]);
                        XSWARE.CHAT_HANDLING.start();
                        ClientMessage.sendIRCMessage("");
                    }
                    break;
                case "server":
                    XSWARE.CHAT_HANDLING.setRunning(false);
                    XSWARE.CHAT_HANDLING.setToServer();
                    ClientMessage.sendIRCMessage("");
                    break;
            }
        }
    }
}
