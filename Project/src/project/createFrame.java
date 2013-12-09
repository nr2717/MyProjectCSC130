package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class createFrame extends JFrame
{
	private ArrayList<Item> cacList;
	private ArrayList<Item> bevList;
	private ArrayList<Item> sunList;
	
	private String[] typeStrings = { "Cups and Cones", "Beverages", "Sundaes" };
	
	private JLabel typeLabel, nameLabel, costLabel;
	private JComboBox typeBox;
	private JTextField nameTextField, costTextField;
	private JButton submitBtn, cancelBtn;
	
	private JFrame frame = this;
	
	private orderFrame parentFrame;
	
	public createFrame(String title, final ArrayList<Item> cacList, final ArrayList<Item> bevList, final ArrayList<Item> sunList, final orderFrame parentFrame)
	{
		super(title);
		
		this.cacList = cacList;
		this.bevList = bevList;
		this.sunList = sunList;
		this.parentFrame = parentFrame;
		
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(240, 180);
		
		typeLabel = new JLabel("Type");
		typeLabel.setBounds(10, 10, 70, 20);
		
		typeBox = new JComboBox(typeStrings);
		typeBox.setBounds(typeLabel.getX() + typeLabel.getWidth(), 10, 140, 20);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, typeLabel.getY() + typeLabel.getHeight() + 10, 70, 20);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(typeLabel.getX() + typeLabel.getWidth(), typeLabel.getY() + typeLabel.getHeight() + 10, 140, 20);
		
		costLabel = new JLabel("Cost");
		costLabel.setBounds(10, nameLabel.getY() + nameLabel.getHeight() + 10, 70, 20);
		
		costTextField = new JTextField();
		costTextField.setBounds(typeLabel.getX() + typeLabel.getWidth(), nameLabel.getY() + nameLabel.getHeight() + 10, 140, 20);
		
		submitBtn = new JButton("Create");
		submitBtn.setBounds(10, costLabel.getY() + costLabel.getHeight() + 20, 100, 30);
		submitBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(nameTextField.getText().equals("") || costTextField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Please Input All Field", "Error", JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}
				else
				{
					try
					{
						float newCost = Float.parseFloat(costTextField.getText());
						
						Item newItem = new Item();
						newItem.setName(nameTextField.getText());
						newItem.setCost(newCost);
						
						if(typeBox.getSelectedIndex() == 0)
						{
							cacList.add(newItem);
						}
						else if(typeBox.getSelectedIndex() == 1)
						{
							bevList.add(newItem);
						}
						else if(typeBox.getSelectedIndex() == 2)
						{
							sunList.add(newItem);
						}
						
						JOptionPane.showMessageDialog(frame, "Create Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						parentFrame.createBtn();
						parentFrame.repaint();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(frame, "Please input only number in cost", "Error", JOptionPane.ERROR_MESSAGE);
						frame.setVisible(true);
					}
				}
			}
		});
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(submitBtn.getX() + submitBtn.getWidth() + 10, costLabel.getY() + costLabel.getHeight() + 20, 100, 30);
		cancelBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				dispose();
			}
		});
		
		add(typeLabel);
		add(typeBox);
		add(nameLabel);
		add(nameTextField);
		add(costLabel);
		add(costTextField);
		add(submitBtn);
		add(cancelBtn);
	}
}
