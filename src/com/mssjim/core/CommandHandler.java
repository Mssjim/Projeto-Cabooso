package com.mssjim.core;

import java.util.HashMap;

public class CommandHandler {

    public static HashMap<String, Command> commands = new HashMap<>();
    public static final CommandParser parse = new CommandParser();

    public static void handlerCommand(CommandParser.commandContainer cmd) {
        if(commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(!safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
                System.out.println(cmd.event.getAuthor().getName() + ": " + cmd.event.getMessage().getContentDisplay());
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
                System.out.println(cmd.event.getAuthor().getName() + "(NS) : " + cmd.event.getMessage().getContentDisplay());
            }
        }
    }
}
