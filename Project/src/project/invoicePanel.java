package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.JPanel;

public class invoicePanel extends JPanel
{
	private String printData;
	
	public invoicePanel(String printData)
	{
		this.printData = printData;
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		int x = 10;
		int y = 0;

		// Calculate the line height
		Font font = new Font("Adobe Garamond Pro Bold", Font.BOLD, 30);
		FontMetrics metrics = g.getFontMetrics(font);
		int lineHeight = metrics.getHeight();

		BufferedReader br = new BufferedReader(new StringReader(printData));

		// Draw the page:
		try
		{
			String line;
			// Just a safety net in case no margin was added.
			
			while ((line = br.readLine()) != null)
			{
				y += lineHeight;
				g2d.drawString(line, x, y);
			}
		}
		catch (IOException e)
		{
			
		}
	}
}
