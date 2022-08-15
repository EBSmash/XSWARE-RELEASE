package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.util.ClientMessage;
import org.lwjgl.input.Keyboard;

public class BindCommand extends Command {

    public BindCommand() {
        super("Bind");
    }

    @Override
    public void execute(String[] message) {
        if (message.length != 2) {
            ClientMessage.sendErrorMessage("Invalid format");
            return;
        }
        String name = message[0].replaceAll("_", " ");
        Hack hack = XSWARE.HACKS.getHackByName(name);
        if (hack == null) {
            ClientMessage.sendErrorMessage("Cannot find hack " + ChatFormatting.BOLD + name);
            return;
        }
        String bindName = message[1];
        if (bindName.equalsIgnoreCase("none")) {
            ClientMessage.sendMessage("Removed bind for " + hack.getName());
            hack.setBind(-1);
            return;
        }
        int key = Keyboard.getKeyIndex(bindName.toUpperCase());
        if (key == 0) {
            ClientMessage.sendErrorMessage("Unknown key");
        } else {
            hack.setBind(key);
            ClientMessage.sendMessage(hack.getName() + " set bind to " + hack.getBindName());
        }
    }
}
