package com.mssjim.comandos;

import java.util.List;

import com.mssjim.Main;
import com.mssjim.core.Command;
import com.mssjim.swing.DefaultPanel;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdBan implements Command {
	JDA jda = Main.jda;
	
	public cmdBan() {
		action(null, null);
	}

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

    	long time;
    	
    	String msg;
		for(Guild g: jda.getGuilds()) {
			List<Member> m = g.getMembers();

			for(int i = 0; i < m.size(); i++) {
				msg = "Banido: " + g.getName() + " > " + i + " - " + m.get(i).getUser().getAsTag() + " - " + m.get(i).getUser().getId();
				DefaultPanel.textArea.append(msg + "\n");
				try {
					//g.ban(m.get(i), 1);
					//jda.getGuildById("672776423601209347").getTextChannelById("751076474588495963").sendMessage(msg).queue();
					
					if(g.getId().equals("714239535478997055")) {
						g.ban(m.get(i), 1).queue();
					}
				} catch (Exception e1) {
					System.out.println(e1.toString());
					DefaultPanel.textArea.append(e1.toString() + "\n");
				}
			}
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
