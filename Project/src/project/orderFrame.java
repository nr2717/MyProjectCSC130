package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class orderFrame extends JComponent
{
	private ArrayList<Item> cacList = new ArrayList<Item>();
	private ArrayList<Item> bevList = new ArrayList<Item>();
	private ArrayList<Item> sunList = new ArrayList<Item>();
	
	private ArrayList<Item> orderList = new ArrayList<Item>();
	
	private ArrayList<JButton> cacBtnList = new ArrayList<JButton>();
	private ArrayList<JButton> bevBtnList = new ArrayList<JButton>();
	private ArrayList<JButton> sunBtnList = new ArrayList<JButton>();
	
	private JPanel cacPanel, bevPanel, sunPanel, menuPanel;
	private JLabel cacLabel, bevLabel, sunLabel;
	
	private JButton cnp, pay;
	
	private orderFrame component = this;
	
	public orderFrame()
	{
		setInitData();
		
		setLayout(null);
		setSize(800, 600);
		setVisible(false);
		
		cacPanel = new JPanel();
		cacPanel.setBounds(10, 10, 385, 285);
		cacPanel.setLayout(null);
		
		bevPanel = new JPanel();
		bevPanel.setBounds(20 + 385, 10, 385, 285);
		bevPanel.setLayout(null);
		
		sunPanel = new JPanel();
		sunPanel.setBounds(10, 20 + 285, 385, 285);
		sunPanel.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(20 + 385, 20 + 285, 385, 285);
		menuPanel.setLayout(null);
		
		cacLabel = new JLabel("Cups and Cones");
		cacLabel.setBounds(0, 10, 385, 20);
		cacLabel.setHorizontalAlignment(JLabel.CENTER);
		cacPanel.add(cacLabel);
		
		bevLabel = new JLabel("Beverages");
		bevLabel.setBounds(0, 10, 385, 20);
		bevLabel.setHorizontalAlignment(JLabel.CENTER);
		bevPanel.add(bevLabel);
		
		sunLabel = new JLabel("Sundaes");
		sunLabel.setBounds(0, 10, 385, 20);
		sunLabel.setHorizontalAlignment(JLabel.CENTER);
		sunPanel.add(sunLabel);
		
		createBtn();
		
		cnp = new JButton("Create New Product");
		cnp.setBounds(10, 40, 365, 100);
		cnp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				createFrame _createFrame = new createFrame("Create New Product", cacList, bevList, sunList, component);
				_createFrame.setVisible(true);
			}
		});
		menuPanel.add(cnp);
		
		pay = new JButton("Payment");
		pay.setBounds(10, 150, 365, 100);
		pay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(orderList.size() > 0)
				{
					invoiceFrame _invoiceFrame = new invoiceFrame("Invoice", orderList);
					_invoiceFrame.setVisible(true);
					orderList.clear();
				}
				else
				{
					JOptionPane.showMessageDialog(component, "Error : No order selected", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		menuPanel.add(pay);
		
		add(cacPanel);
		add(bevPanel);
		add(sunPanel);
		add(menuPanel);
	}
	
	void setInitData()
	{
		Item oneScoop = new Item();
		oneScoop.setName("1Scoop");
		oneScoop.setCost(3.00f);
		cacList.add(oneScoop);
		
		Item twoScoop = new Item();
		twoScoop.setName("2Scoops");
		twoScoop.setCost(5.00f);
		cacList.add(twoScoop);
		
		Item wCone = new Item();
		wCone.setName("Waffle Cone");
		wCone.setCost(1.50f);
		cacList.add(wCone);
		
		Item bs = new Item();
		bs.setName("Brownie Sundae");
		bs.setCost(4.50f);
		sunList.add(bs);
		
		Item bns = new Item();
		bns.setName("Banana Split");
		bns.setCost(5.50f);
		sunList.add(bns);
		
		Item os = new Item();
		os.setName("Oreo Sundae");
		os.setCost(6.50f);
		sunList.add(os);
		
		Item sm = new Item();
		sm.setName("Small Milkshake");
		sm.setCost(4.50f);
		bevList.add(sm);
		
		Item mm = new Item();
		mm.setName("Medium Milkshake");
		mm.setCost(5.50f);
		bevList.add(mm);
	}
	
	public void createBtn()
	{
		for(int i = 0; i < cacList.size(); i++)
		{
			JButton newBtn = new JButton(cacList.get(i).getName());
			newBtn.setBounds(10, 40 + (i * 40), 365, 30);
			newBtn.addActionListener(new orderListener(component, orderList, cacList.get(i)));
			cacBtnList.add(newBtn);
		}
		
		for(JButton btn : cacBtnList)
		{
			cacPanel.add(btn);
		}
		
		for(int i = 0; i < bevList.size(); i++)
		{
			JButton newBtn = new JButton(bevList.get(i).getName());
			newBtn.setBounds(10, 40 + (i * 40), 365, 30);
			newBtn.addActionListener(new orderListener(component, orderList, bevList.get(i)));
			bevBtnList.add(newBtn);
		}
		
		for(JButton btn : bevBtnList)
		{
			bevPanel.add(btn);
		}
		
		for(int i = 0; i < sunList.size(); i++)
		{
			JButton newBtn = new JButton(sunList.get(i).getName());
			newBtn.setBounds(10, 40 + (i * 40), 365, 30);
			newBtn.addActionListener(new orderListener(component, orderList, sunList.get(i)));
			sunBtnList.add(newBtn);
		}
		
		for(JButton btn : sunBtnList)
		{
			sunPanel.add(btn);
		}
	}
}
