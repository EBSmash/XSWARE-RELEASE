package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.hack.hacks.client.Gui;
import me.xss6.xsware.util.ClientMessage;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("Help", "H");
    }

    @Override
    public void execute(String[] message) {
        ClientMessage.sendMessage(ChatFormatting.BOLD + "Command list");
        ClientMessage.sendMessage("Your gui is currently bound to " + ChatFormatting.BOLD + Gui.INSTANCE.getBindName());
        for (Command command : XSWARE.COMMANDS.getCommands()) {
            ClientMessage.sendMessage(command.getNames().get(0));
        }
    }

}
