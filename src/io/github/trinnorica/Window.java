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
		
		setPreferredSize(new Dimension(1920/2, 1080/2));
		
		pack();
		setSize(new Dimension(1920/2, 1080/2));
		setMinimumSize(new Dimension(1920/2, 1080/2));
		add(new Screen());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ExternalFile.loadTexture("logos/logo.png"));
		setTitle("Trinnorica " + Utils.getVersion());
		setVisible(true);
		setResizable(false);
	}

}
