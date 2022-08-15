package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.util.ClientMessage;

public class ConfigCommand extends Command {

    public ConfigCommand() {
        super("Config", "C");
    }

    @Override
    public void execute(String[] message) {
        String folder = message[0].replaceAll("_", " ") + "/";
        if (folder.equalsIgnoreCase("/")) {
            ClientMessage.sendMessage("Current config is " + XSWARE.CONFIG_MANAGER.configName);
            return;
        }
        XSWARE.CONFIG_MANAGER.setActiveConfigFolder(folder);
        ClientMessage.sendMessage("Set config folder to " + ChatFormatting.BOLD + folder.substring(0, folder.length() - 1));
    }

}
