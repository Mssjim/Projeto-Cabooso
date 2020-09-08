package com.mssjim.swing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.mssjim.assets.URL;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	private String titulo;
	private int largura;
	private int altura;

	public Janela(String titulo) {

		// Estilo da Janela
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		setTitulo(titulo);
		centralizar();
		setTitle(getTitulo());
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource(URL.icone)).getImage());
		setVisible(true);
	}

	public void setContent(JPanel panel) {
		setContentPane(panel);
		setLargura(panel.getWidth());
		setAltura(panel.getHeight() + getInsets().top);
		centralizar();
	}

	public void centralizar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - getLargura()) / 2, (screenSize.height - getAltura()) / 2, getLargura(),
				getAltura());
	}

	public String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private int getLargura() {
		return largura;
	}

	private void setLargura(int largura) {
		this.largura = largura;
	}

	private int getAltura() {
		return altura;
	}

	private void setAltura(int altura) {
		this.altura = altura;
	}
}
