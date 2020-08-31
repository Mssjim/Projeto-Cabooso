package com.mssjim.core;

import com.mssjim.Main;
import com.mssjim.utils.Utils;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

    	User a = event.getAuthor();
    	
    	// Bot Message
        if(event.getAuthor().isBot()) {
            return;
        }

        // Private Message
        if(event.getChannelType() == ChannelType.PRIVATE) {
            System.out.println("Mensagem Privada de " + a.getAsTag() + ": " + event.getMessage().getContentDisplay());
            Main.jda.getGuildById("614273992823537666").getMemberByTag("Mssjim#4702").getUser().openPrivateChannel().complete().sendMessage("Mensagem Privada de " + a.getAsTag() + ": " + event.getMessage().getContentDisplay()).queue();
            return;
        }
    	Message m = event.getMessage();
    	
        // Comando
        String message = m.getContentDisplay();
        if(message.startsWith(Utils.getPrefix)) {
            CommandHandler.handlerCommand(CommandHandler.parse.parse(m.getContentDisplay(), event));
        }
    }
}
