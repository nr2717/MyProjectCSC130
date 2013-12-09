package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class invoiceFrame extends JFrame
{
	private ArrayList<Item> orderList;
	
	private invoicePanel invoice;
	
	private JButton printBtn;
	
	private String endLine = "----------------------------------------------------\n";
	
	private float taxRate = 5;
	
	public invoiceFrame(String title, ArrayList<Item> orderList)
	{
		super(title);
		
		int space = 30 * orderList.size();
		
		this.orderList = orderList;
		
		setLayout(null);
		//setLocationRelativeTo(null);
		setResizable(false);
		setSize(400, 430 + space);
		
		String shopName = "Ice Cream World\n";
		String address = "1234 Chocolate Rd\nAnnandale, VA 20130\n";
		String telephone = "(703)131-3000\n";
		
		String fullStr = shopName + address + telephone + endLine;
		
		float sumCost = 0;
		
		for(Item tempItem : orderList)
		{
			fullStr += String.format("%-30s", tempItem.getName()) + String.format("%6s", "$") + String.format("%.2f", tempItem.getCost()) + "\n";
			sumCost += tempItem.getCost();
		}
		
		fullStr += endLine;
		fullStr += "Subtotal "+ String.format("%36s", "$") + String.format("%.2f", sumCost) + "\n";
		fullStr += "Tax " + taxRate + "% "+ String.format("%36s", "$") + String.format("%.2f", sumCost * (taxRate / 100)) + "\n";
		fullStr += endLine;
		fullStr += "Total " + String.format("%41s", "$") + String.format("%.2f", sumCost + (sumCost * (taxRate / 100))) + "\n";
		
		invoice = new invoicePanel(fullStr);
		invoice.setBounds(0, 0, 200, 340 + space);
		
		printBtn = new JButton("Print");
		printBtn.setBounds(10, invoice.getY() + invoice.getHeight(), getWidth() - 30, 40);
		printBtn.addActionListener(new printListener(fullStr));
		
		add(invoice);
		add(printBtn);
	}
}
