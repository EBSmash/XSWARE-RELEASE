package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.hack.hacks.player.PlayerSpoofer;
import me.xss6.xsware.util.ClientMessage;

/**
 * @author XSS6
 * @since 28/04/2021
 * FIXED UR SHIT ¬ xss6
 */

public class PlayerSpooferCommand extends Command {

    public PlayerSpooferCommand(){
        super("PlayerSpoof", "PlayerSpoofer", "PS");
    }

    @Override
    public void execute(String[] message) {
        if (message.length == 0){
            ClientMessage.sendErrorMessage("Enter a name dumbass!");
            return;
        }
        if (message.length == 1){
            if (message[0].isEmpty()){
                ClientMessage.sendErrorMessage("Enter a name dumbass!");
                return;
            }
            String name = message[0];
            PlayerSpoofer.INSTANCE.name = name;
            // reset skin
            PlayerSpoofer.INSTANCE.disable();
            PlayerSpoofer.INSTANCE.enable();
            // goods
            ClientMessage.sendMessage("Set skin to " + ChatFormatting.BOLD + name);
        }
    }
}
