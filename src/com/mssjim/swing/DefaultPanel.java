package com.mssjim.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import com.mssjim.Main;
import com.mssjim.assets.Cor;
import com.mssjim.assets.URL;
import com.mssjim.comandos.cmdBan;
import com.mssjim.comandos.cmdChannels;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

public class DefaultPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JDA jda = Main.jda;

	public static JLabel lblServers;
	public static JTextPane tpServers;
	public static JLabel lblMembers;
	public static JTextPane tpMembers;
	public static JTextArea textArea;
	
	private final JButton btnFlood;
	private final JButton btnMessage;
	private final JButton btnChannels;
	private final JButton btnKick;
	private final JButton btnBan;
	private final JPanel menu;
	

	public DefaultPanel() {
		setSize(800, 600);
		setLayout(null);
				
		menu = new JPanel();
		menu.setLayout(null);
		menu.setBounds(640, 0, 160, 70);
		menu.setBackground(Cor.escura);
		menu.addMouseListener(menuListener);
		
		JLabel lblUsuario = new JLabel(Main.jda.getSelfUser().getAsTag());
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("SanSerif", Font.BOLD, 14));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(0, 0, 160, 70);
		menu.add(lblUsuario);

		JButton btnEncerrarSessao = new JButton("Alterar Token");
		btnEncerrarSessao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEncerrarSessao.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEncerrarSessao.setBackground(Cor.escura);
		btnEncerrarSessao.setForeground(Color.WHITE);
		btnEncerrarSessao.setBounds(0, 70, 155, 30);
		btnEncerrarSessao.addMouseListener(menuListener);
		btnEncerrarSessao.addActionListener(encerrarSessao);
		menu.add(btnEncerrarSessao);

		JPanel menuBar = new JPanel();
		menuBar.setBackground(Cor.principal);
		menuBar.setBounds(0, 0, 800, 70);
		menuBar.setLayout(null);
		
		btnFlood = new JButton(new ImageIcon(getClass().getResource(URL.btnFlood)));
		btnFlood.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFlood.setBounds(20, 100, 200, 60);
		btnFlood.setEnabled(false);
		
		btnMessage = new JButton(new ImageIcon(getClass().getResource(URL.btnMessage)));
		btnMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMessage.setBounds(20, 180, 200, 60);
		btnMessage.setEnabled(false);
		
		btnChannels = new JButton(new ImageIcon(getClass().getResource(URL.btnChannels)));
		btnChannels.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChannels.setBounds(20, 260, 200, 60);
		btnChannels.setEnabled(false);
		
		btnKick = new JButton(new ImageIcon(getClass().getResource(URL.btnKick)));
		btnKick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKick.setBounds(20, 340, 200, 60);
		btnKick.setEnabled(false);
		
		btnBan = new JButton(new ImageIcon(getClass().getResource(URL.btnBan)));
		btnBan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBan.setBounds(20, 420, 200, 60);
		btnBan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new cmdBan();
			}
		});
		
		JLabel imgLogo = new JLabel(new ImageIcon(getClass().getResource(URL.logo)));
		imgLogo.setBounds(0, 0, 70, 70);
		menuBar.add(imgLogo);
		
		JLabel lblLogo = new JLabel("Projeto Cabooso");
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(80, 0, 550, 70);
		menuBar.add(lblLogo);
		
		add(menu);
		add(menuBar);
		add(btnFlood);
		add(btnMessage);
		add(btnChannels);
		add(btnKick);
		add(btnBan);
		btnFlood.setBackground(Cor.principal);
		
		lblServers = new JLabel("Servidores");
		lblServers.setHorizontalAlignment(SwingConstants.CENTER);
		lblServers.setBounds(240, 100, 260, 20);
		lblServers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblServers.setForeground(Cor.principal);
		add(lblServers);
		
		tpServers = new JTextPane();
		tpServers.setBounds(240, 130, 260, 200);
		tpServers.setFont(new Font("Tahoma", Font.PLAIN,11));
		tpServers.setEditable(false);
		tpServers.setOpaque(false);
		tpServers.setBorder(BorderFactory.createEmptyBorder());
		tpServers.setBackground(new Color(0,0,0,0));
		add(tpServers);		
		
		lblMembers = new JLabel("Membros");
		lblMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembers.setBounds(520, 100, 260, 20);
		lblMembers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMembers.setForeground(Cor.principal);
		add(lblMembers);
		
		tpMembers = new JTextPane();
		tpMembers.setBounds(520, 130, 260, 200);
		tpMembers.setFont(new Font("Tahoma", Font.PLAIN,11));
		tpMembers.setEditable(false);
		tpMembers.setOpaque(false);
		tpMembers.setBorder(BorderFactory.createEmptyBorder());
		tpMembers.setBackground(new Color(0,0,0,0));
		add(tpMembers);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 340, 540, 240);
		add(scrollPane);
		
		textArea = new JTextArea();
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		scrollPane.setViewportView(textArea);
		
	}

// Metodos

// Action Listeners
	
	private final ActionListener encerrarSessao = arg0 -> {
		// TODO Encerrar sessão
	};
		
	private final MouseAdapter menuListener = new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
			menu.setSize(160, 100);
		}
		public void mouseExited(MouseEvent e) {
			menu.setSize(160, 70);
		}
	};
	private JScrollPane scrollPane;
}
