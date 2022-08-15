package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.util.ClientMessage;

import java.util.Locale;

public class ToggleCommand extends Command {

    public ToggleCommand() {
        super("Toggle", "T");
    }

    @Override
    public void execute(String[] message) {
        String name = message[0].replaceAll("_", " ");
        Hack hack = XSWARE.HACKS.getHackByName(name);
        if (hack != null) {
            hack.toggle();
        } else {
            ClientMessage.sendErrorMessage("Cannot find hack by name " + ChatFormatting.BOLD + name);
        }
    }
}
