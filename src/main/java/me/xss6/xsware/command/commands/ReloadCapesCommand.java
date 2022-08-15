package me.xss6.xsware.command.commands;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.util.ClientMessage;

/**
 * @author XSS6
 * @since 01/05/2021
 */

public class ReloadCapesCommand extends Command {

    public ReloadCapesCommand(){
        super("ReloadCapes", "ReloadCape");
    }

    @Override
    public void execute(String[] message) {
        XSWARE.CAPE_MANAGER.reload();
        ClientMessage.sendMessage("Reloaded Capes!");
    }
}
