package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class regFrame extends JFrame
{
	private ArrayList<Person> personList;
	private JLabel userLabel, passLabel;
	private JTextField userTextField;
	private JPasswordField passField;
	private JButton submitBtn, cancelBtn;
	private JFrame frame = this;
	
	public regFrame(String title, final ArrayList<Person> personList)
	{
		super(title);
		this.personList = personList;
		
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(240, 150);
		
		userLabel = new JLabel("Username ");
		userLabel.setBounds(10, 10, 100, 20);
		
		userTextField = new JTextField();
		userTextField.setBounds(userLabel.getX() + userLabel.getWidth() + 10, 10, 100, 20);
		
		passLabel = new JLabel("Password(4) ");
		passLabel.setBounds(10, userLabel.getY() + userLabel.getHeight() + 10, 100, 20);
		
		passField = new JPasswordField();
		passField.setBounds(userLabel.getX() + userLabel.getWidth() + 10, userLabel.getY() + userLabel.getHeight() + 10, 100, 20);
		
		submitBtn = new JButton("Register");
		submitBtn.setBounds(10, passField.getY() + passField.getHeight() + 20, 100, 30);
		
		submitBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(userTextField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Please Input Username", "Error", JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}
				else if(passField.getText().length() != 4)
				{
					JOptionPane.showMessageDialog(frame, "Password need to have 4 Character", "Error", JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}
				else
				{
					Person temp = new Person();
					temp.setUsername(userTextField.getText());
					//temp.setPassword(passField.getPassword().toString());
					temp.setPassword(passField.getText());
					personList.add(temp);
					JOptionPane.showMessageDialog(frame, "Register Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
			}
		});
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(userLabel.getX() + userLabel.getWidth() + 10, passField.getY() + passField.getHeight() + 20, 100, 30);
		
		cancelBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				dispose();
			}
		});
		
		add(userLabel);
		add(userTextField);
		add(passLabel);
		add(passField);
		add(submitBtn);
		add(cancelBtn);
	}
}
