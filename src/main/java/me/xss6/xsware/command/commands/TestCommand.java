package me.xss6.xsware.command.commands;

import me.xss6.xsware.command.Command;
import me.xss6.xsware.util.ClientMessage;

public class TestCommand extends Command {

    public TestCommand() {
        super("Test");
    }

    @Override
    public void execute(String[] message) {
        if (message.length == 0) {
            ClientMessage.sendErrorMessage("empty message");
            return;
        }
        for (String s : message) {
            ClientMessage.sendMessage(s);
        }
    }

}
