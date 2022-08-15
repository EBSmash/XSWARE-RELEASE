package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.util.ClientMessage;

public class DrawnCommand extends Command {

    public DrawnCommand() {
        super("Drawn");
    }

    @Override
    public void execute(String[] message) {
        Hack hack = XSWARE.HACKS.getHackByName(message[0].replaceAll("_", " "));
        if (hack == null) {
            ClientMessage.sendErrorMessage("Cannot find hack by name " + ChatFormatting.BOLD + message[0]);
            return;
        }
        if (XSWARE.HACKS.isDrawHack(hack)) {
            XSWARE.HACKS.removeDrawnHack(hack);
            ClientMessage.sendMessage("Removed " + ChatFormatting.BOLD + hack.getName() + ChatFormatting.RESET + " from drawn list");
        } else {
            XSWARE.HACKS.addDrawHack(hack);
            ClientMessage.sendMessage("Added " + ChatFormatting.BOLD + hack.getName() + ChatFormatting.RESET + " to drawn list");
        }
    }
}
