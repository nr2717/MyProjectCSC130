package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class orderListener implements ActionListener
{
	private ArrayList<Item> orderList;
	private Item orderItem;
	private orderFrame component;
	
	public orderListener(orderFrame component, ArrayList<Item> orderList, Item orderItem)
	{
		this.component = component;
		this.orderList = orderList;
		this.orderItem = orderItem;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		int status = JOptionPane.showConfirmDialog(component, "Confirm " + orderItem.getName() + "?", "Confirm Order", JOptionPane.YES_NO_OPTION);
		if(status == 0) orderList.add(orderItem);
	}
}
