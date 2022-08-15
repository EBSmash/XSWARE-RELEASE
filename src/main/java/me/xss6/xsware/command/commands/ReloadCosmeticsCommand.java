package me.xss6.xsware.command.commands;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.util.ClientMessage;

/**
 * @author XSS6
 * @since 01/05/2021
 */

public class ReloadCosmeticsCommand extends Command {
    public ReloadCosmeticsCommand(){
        super("ReloadCosmetics", "ReloadCosmetic");
    }

    @Override
    public void execute(String[] message) {
        XSWARE.COSMETIC_MANAGER.reload();
        ClientMessage.sendMessage("Reloaded Cosmetics!");
    }
}
