package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginFrame extends JComponent
{
	private pinModel _pinModel = new pinModel();
	private JPanel loginPanel;
	private JLabel imageLabel, statusLabel;
	private JPasswordField passField;
	private JButton inputBtn[] = new JButton[12];
	private JButton createBtn;
	private orderFrame _orderFrame;
	
	private ArrayList<Person> personList = new ArrayList<Person>();
	
	public loginFrame(final orderFrame _orderFrame)
	{
		this._orderFrame = _orderFrame;
		
		Person test = new Person();
		test.setUsername("Admin");
		test.setPassword("1234");
		personList.add(test);
		
		setLayout(null);
		setSize(800, 600);
		setVisible(false);
		
		ImageIcon icon = createImageIcon("images/header2.jpg", "Image");
		
		imageLabel = new JLabel(icon);
		imageLabel.setBounds(10, 10, 780, 290);
		
		passField = new JPasswordField(4);
		int passFieldWidth = 100;
		passField.setBounds((getWidth()/2) - (passFieldWidth/2), imageLabel.getY() + imageLabel.getHeight() + 40, passFieldWidth, 20);
		passField.setHorizontalAlignment(JTextField.CENTER);
		passField.disable();
		
		statusLabel = new JLabel("Input Password");
		int statusLabelWidth = 300;
		statusLabel.setBounds((getWidth()/2) - (statusLabelWidth/2), passField.getY() + passField.getHeight() + 10, statusLabelWidth, 20);
		statusLabel.setHorizontalAlignment(JTextField.CENTER);
		
		loginPanel = new JPanel();
		loginPanel.setBounds((getWidth()/2) - (75), statusLabel.getY() + statusLabel.getHeight() + 10, 150, 130);
		
		for(int i = 0; i < inputBtn.length; i++)
		{
			if(i < 9)
			{
				inputBtn[i] = new JButton(String.valueOf(i + 1));
				//inputBtn[i].setBounds(i * 100, i * 100, 50, 50);
				inputBtn[i].addActionListener(new pinListener(i + 1, passField, _pinModel, statusLabel));
				loginPanel.add(inputBtn[i]);
			}
			else if(i == 9)
			{
				inputBtn[i] = new JButton("<");
				//inputBtn[i].setBounds(i * 100, i * 100, 50, 50);
				inputBtn[i].addActionListener(new pinListener(i + 1, passField, _pinModel, statusLabel));
				loginPanel.add(inputBtn[i]);
			}
			else if(i == 10)
			{
				inputBtn[i] = new JButton("0");
				//inputBtn[i].setBounds(i * 100, i * 100, 50, 50);
				inputBtn[i].addActionListener(new pinListener(0, passField, _pinModel, statusLabel));
				loginPanel.add(inputBtn[i]);
			}
			else if(i == 11)
			{
				inputBtn[i] = new JButton(">");
				//inputBtn[i].setBounds(i * 100, i * 100, 50, 50);
				inputBtn[i].addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						for(Person temp : personList)
						{
							if(temp.getPassword().equals(passField.getText()))
							{
								//System.out.println(temp.getUsername());
								setVisible(false);
								_orderFrame.setVisible(true);
								
								break;
							}
						}
					}
				});
				loginPanel.add(inputBtn[i]);
			}
		}
		
		createBtn = new JButton("Create New User");
		createBtn.setBounds(10, getHeight() - 40, 150, 30);
		createBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				regFrame _regFrame = new regFrame("Create New User", personList);
				_regFrame.setVisible(true);
			}
		});
		
		add(imageLabel);
		add(passField);
		add(statusLabel);
		add(loginPanel);
		add(createBtn);
	}
	
	protected ImageIcon createImageIcon(String path, String description)
	{
		URL imgURL = getClass().getResource(path);
		if (imgURL != null)
		{
			return new ImageIcon(imgURL, description);
		}
		else
		{
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
