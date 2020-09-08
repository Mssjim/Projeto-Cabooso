package com.mssjim.listeners;

import com.mssjim.Main;
import com.mssjim.swing.DefaultPanel;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {
        System.out.println("Servidores:");
        Main.janela.setContent(new DefaultPanel());

        int guilds = 0;
        
        for(Guild g: event.getJDA().getGuilds()) {
        	guilds++;
            System.out.println(g.getName());
            DefaultPanel.lblServers.setText("Servidores [" + guilds + "]");
            DefaultPanel.tpServers.setText(DefaultPanel.tpServers.getText() + g.getName() + "\n");
        }
    }
}
