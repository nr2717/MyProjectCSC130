package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class pinListener implements ActionListener
{
	private int number;
	private JPasswordField passField;
	private pinModel _pinModel;
	private JLabel statusLabel; //Maybe for Status Error
	
	public pinListener(int number, JPasswordField passField, pinModel _pinModel, JLabel statusLabel)
	{
		this.number = number;
		this.passField = passField;
		this._pinModel = _pinModel;
		this.statusLabel = statusLabel;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		if(number == 10)
		{
			if(_pinModel.pinStr.length() > 0)
			{
				//System.out.print("Good");
				_pinModel.pinStr = _pinModel.pinStr.substring(0, _pinModel.pinStr.length() - 1);
				passField.setText(_pinModel.pinStr);
			}
			return ;
		}
		
		if(_pinModel.pinStr.length() < 4)
		{
			_pinModel.pinStr += number;
			//System.out.print(_pinModel.pinStr);
			passField.setText(_pinModel.pinStr);
			//statusLabel.setText("Input Password");
		}
		else
		{
			//statusLabel.setText("Error : Password Never more than 4");
		}
	}

}
