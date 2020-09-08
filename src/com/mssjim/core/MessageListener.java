package com.mssjim.core;

import com.mssjim.Main;
import com.mssjim.swing.DefaultPanel;
import com.mssjim.utils.Utils;


import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
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
            Main.jda.getGuildById("606767365572526091").getMemberByTag("Mssjim#4702").getUser().openPrivateChannel().complete().sendMessage("Mensagem Privada de " + a.getAsTag() + ": " + event.getMessage().getContentDisplay()).queue();
            return;
        }

    	Guild g = event.getGuild();
    	Member u = event.getMember();
    	Message m = event.getMessage();
    	
    	if(Main.log) {
    		if(event.getMessage().getEmbeds().isEmpty()) {
    			DefaultPanel.textArea.append("<html><b>" + g.getName() + " </b></html> " + event.getTextChannel().getName() + ": <" + u.getUser().getName() + "> " + m.getContentRaw() + "\n");
    		} else {
    			DefaultPanel.textArea.append(g.getName() + " - " + event.getTextChannel().getName() + ": <" + u.getUser().getName() + "> " + m.getEmbeds().get(0).getTitle() + " / " + m.getEmbeds().get(0).getDescription() +"\n");
    		}
    	}
    	
        // Comando
        String message = m.getContentDisplay();
        if(message.startsWith(Utils.getPrefix)) {
            CommandHandler.handlerCommand(CommandHandler.parse.parse(m.getContentDisplay(), event));
        }
    }
}
