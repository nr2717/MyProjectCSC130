package project;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Printer
{
	public static void printToPrinter(String toPrint)
	{
		String printData = toPrint;
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new OutputPrinter(printData));
		boolean doPrint = job.printDialog();
		if(doPrint)
	    { 
			try 
			{
				job.print();
			}
			catch (PrinterException e)
			{
				System.out.println("No printer found!");
				}
		}
	}
}
