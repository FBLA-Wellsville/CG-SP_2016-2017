package io.github.trinnorica;

import java.awt.Dimension;

import javax.swing.JFrame;

import io.github.trinnorica.utils.Utils;
import res.ExternalFile;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Window(){
		setResizable(false);
		setPreferredSize(new Dimension(1920/2, 1080/2));
		
		pack();
		
		add(Main.setScreen(new Screen()));
		Utils.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ExternalFile.loadTexture("logos/logo.png"));
		setTitle("Eldesith " + Utils.getVersion());
		setVisible(true);
		
		setLocationRelativeTo(null);
	}

}
