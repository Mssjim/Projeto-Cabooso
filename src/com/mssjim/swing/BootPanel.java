package com.mssjim.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mssjim.Main;
import com.mssjim.assets.Cor;

public class BootPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField fldToken;

	public BootPanel() {
		setSize(400, 120);

		setLayout(null);

		JLabel lbl = new JLabel("Insira o token do bot:");
		lbl.setForeground(Cor.principal);
		lbl.setFont(new Font("Consolas", Font.BOLD, 19));
		lbl.setBounds(20, 11, 360, 36);
		add(lbl);

		fldToken = new JTextField();
		fldToken.setBounds(20, 48, 360, 25);
		fldToken.setToolTipText("Token");
		add(fldToken);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String token = fldToken.getText();
				Main.iniciar(token);
			}
		});
		btnOk.setBounds(290, 85, 90, 25);
		add(btnOk);
	}
}
