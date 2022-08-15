package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.util.ClientMessage;
import me.xss6.xsware.util.elements.XswarePlayer;

public class EnemyCommand extends Command {

    public EnemyCommand() {
        super("Enemy", "E");
    }

    @Override
    public void execute(String[] message) {
        if (message.length == 0) {
            ClientMessage.sendErrorMessage("Need more info than that mate");
            return;
        }
        if (message.length == 1) {
            if (message[0].equalsIgnoreCase("list")) {
                if (XSWARE.ENEMY_MANAGER.hasEnemies()) {
                    ClientMessage.sendMessage(ChatFormatting.BOLD + "Listing enemies");
                    for (XswarePlayer player : XSWARE.ENEMY_MANAGER.getEnemies()) {
                        ClientMessage.sendMessage(player.getName());
                    }
                } else {
                    ClientMessage.sendMessage("u got no enemies :)");
                }
            } else if (message[0].equalsIgnoreCase("clear")) {
                XSWARE.ENEMY_MANAGER.clear();
                ClientMessage.sendMessage("Cleared enemies list");
            } else {
                ClientMessage.sendErrorMessage("Enemy <add/del/list/clear>");
            }
            return;
        }
        String word1 = message[0];
        String word2 = message[1];
        if (word1 == null) return;
        switch (word1) {
            case "add":
                if (word2 == null) {
                    ClientMessage.sendErrorMessage("need name");
                    return;
                }
                XSWARE.ENEMY_MANAGER.addEnemy(word2);
                ClientMessage.sendMessage(ChatFormatting.GREEN + word2 + ChatFormatting.RESET + " is now your enemy");
                break;
            case "del":
                XSWARE.ENEMY_MANAGER.removeEnemy(word2);
                ClientMessage.sendMessage(ChatFormatting.RED + word2 + ChatFormatting.RESET + " is no longer your enemy");
                if (word2 == null) {
                    ClientMessage.sendErrorMessage("need name");
                    return;
                }
                break;
            default:
                ClientMessage.sendErrorMessage("enemy <add/del/list>");
        }
    }
}
