package me.xss6.xsware.command.commands;

import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.hack.hacks.combat.Burrow;
import me.xss6.xsware.util.ClientMessage;
import me.xss6.xsware.util.WhitelistUtil;
import net.minecraft.block.Block;

import java.io.IOException;

/**
 * @author XSS6
 * @since 08/05/2021
 */

public class BurrowBlockCommand extends Command {
    public BurrowBlockCommand(){
        super("BurrowBlock", "bb");
    }
    String bBlock = "";

    @Override
    public void execute(String[] message) {
        Burrow bClass = (Burrow) XSWARE.HACKS.getHackByName("Burrow");
        Block b = WhitelistUtil.findBlock(message[0]);

        if(b.equals(null)){
            ClientMessage.sendMessage("Cannot set Block to " + message[0]);
            return;
        }
        bClass.setBlock(b);
        ClientMessage.sendMessage("Set Block to " + message[0]);
        bBlock = message[0];
        try {
            XSWARE.CONFIG_MANAGER.saveBurrowBlock();
        }catch (IOException e){
        }
    }

    public String getBBlock(){
        return bBlock;
    }

    public void setBBlock(String b){
        bBlock = b;
    }
}
