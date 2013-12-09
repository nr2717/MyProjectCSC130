package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class printListener implements ActionListener
{
	String toPrint;
	
	public printListener(String toPrint)
	{
		this.toPrint = toPrint;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		Printer.printToPrinter(toPrint);
	}
}
