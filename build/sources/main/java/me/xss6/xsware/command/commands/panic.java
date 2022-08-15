package me.xss6.xsware.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.xss6.xsware.XSWARE;
import me.xss6.xsware.command.Command;
import me.xss6.xsware.hack.Hack;
import me.xss6.xsware.util.ClientMessage;

public class panic extends Command {

    public panic() {
        super("Panic", "P");
    }

    @Override
    public void execute(String[] message) {
        try {
            for(Hack h : XSWARE.HACKS.getHacks()) {
                if(h == null)
                {
                    continue;
                }
                if(h.isEnabled()) {
                    h.toggle();
                }

            }
        }catch (Exception ex){}

    }
}
