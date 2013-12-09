package project;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class myApplet extends Applet
{
	private loginFrame _loginFrame;
	private orderFrame _orderFrame;
	
	public void init()
	{
		_orderFrame = new orderFrame();
		_loginFrame = new loginFrame(_orderFrame);
		
		setLayout(null);
		setSize(800, 600);
		
		add(_loginFrame);
		_loginFrame.setVisible(true);
		
		add(_orderFrame);
		//_orderFrame.setVisible(true);
	}
	
	public void stop()
	{
		
	}
}
