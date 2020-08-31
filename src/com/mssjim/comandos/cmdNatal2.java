package com.mssjim.comandos;

import com.mssjim.core.Command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdNatal2 implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
    	event.getMessage().delete().complete();
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {  
		event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("649793621150924800")).complete();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
