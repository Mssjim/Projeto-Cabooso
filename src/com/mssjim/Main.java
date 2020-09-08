package com.mssjim;

import javax.security.auth.login.LoginException;
import javax.swing.WindowConstants;

import com.mssjim.comandos.cmdBan;
import com.mssjim.comandos.cmdNatal2;
import com.mssjim.comandos.cmdChannels;
import com.mssjim.comandos.cmdNatal4;
import com.mssjim.core.CommandHandler;
import com.mssjim.core.MessageListener;
import com.mssjim.listeners.MemberJoinListener;
import com.mssjim.listeners.ReadyListener;
import com.mssjim.swing.BootPanel;
import com.mssjim.swing.Janela;
import com.mssjim.utils.Utils;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static JDA jda;
    public static boolean log = false;
    
    public static Janela janela;

    public static void main(String[] args) {
    	janela = new Janela("Projeto Cabooso");
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	janela.setContent(new BootPanel());

    	System.out.println("Aguardando token...");
        
    }
    
    public static void iniciar(String token) {
    	System.out.println(token);
    	JDABuilder builder = new JDABuilder(AccountType.BOT)
                .setToken(token)
                .setAutoReconnect(true)
                .setActivity(Activity.watching("A Destruição"));
        
        
        // Listeners
        builder.addEventListeners(new ReadyListener());
        builder.addEventListeners(new MessageListener());
        builder.addEventListeners(new MemberJoinListener());

        // Geral
        //CommandHandler.commands.put("gartic", new cmdNatal());      // Ban
        //CommandHandler.commands.put("help", new cmdNatal2());      // Ademar
        //CommandHandler.commands.put("caboose", new cmdNatal3());  // Cria canais
        //CommandHandler.commands.put("iniciar", new cmdNatal4()); // Flood PV

        try {
            jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
            // Todo Exibir Erro
        }
    }
}
