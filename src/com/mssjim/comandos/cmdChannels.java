package com.mssjim.comandos;

import java.nio.channels.Channel;

import com.mssjim.Main;
import com.mssjim.core.Command;
import com.mssjim.swing.DefaultPanel;

import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdChannels implements Command {
	
	public cmdChannels() {
		action(null, null);
	}

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
    	event.getMessage().delete().queue();
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
//    	for(int i=0; i<100; i++) {
//    		Main.jda.getGuildById("714239535478997055").createTextChannel("Caboose").queue();
//    		Main.jda.getGuildById("714239535478997055").createCategory("Caboose").queue();
//    		Main.jda.getGuildById("714239535478997055").createVoiceChannel("Caboose").queue();
//    	}
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
