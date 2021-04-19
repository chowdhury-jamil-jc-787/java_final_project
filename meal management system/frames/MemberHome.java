package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class MemberHome extends JFrame implements ActionListener
{
	JButton logoutBtn, manageEmpBtn, allMemberBtn, bazarBtn,detailsBtn,mealcountBtn;
	JPanel panel;
	
	User user;
	
	public MemberHome(User user)
	{
		super("Welcome Member Home");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 310, 150,40);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		manageEmpBtn = new JButton("Manager");
		manageEmpBtn.setBounds(50, 90, 200, 40);
		manageEmpBtn.addActionListener(this);
		panel.add(manageEmpBtn);
		
		allMemberBtn = new JButton("All Member");
		allMemberBtn.setBounds(275, 90, 200, 40);
		allMemberBtn.addActionListener(this);
		panel.add(allMemberBtn);
		
		
		bazarBtn = new JButton("Bazar");
		bazarBtn.setBounds(500, 90, 200,40);
		bazarBtn.addActionListener(this);
		panel.add(bazarBtn);
		
		/*contactBtn1 = new JButton("Contacts");
		contactBtn1.setBounds(575, 90, 150,40);
		contactBtn1.addActionListener(this);
		panel.add(contactBtn1);*/
		
		detailsBtn = new JButton("Show Details");
		detailsBtn.setBounds(350, 240, 300,40);
		detailsBtn.addActionListener(this);
		panel.add(detailsBtn);
		
		mealcountBtn = new JButton("Meal Count");
		mealcountBtn.setBounds(50, 180, 300,40);
		mealcountBtn.addActionListener(this);
		panel.add(mealcountBtn);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageEmpBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				ManagerFrame mf = new ManagerFrame(user);
				mf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(allMemberBtn.getText()))
		{
			
				AllMemberFrame am = new AllMemberFrame(user);
				am.setVisible(true);
				this.setVisible(false);
				
			
		}
		else if(command.equals(bazarBtn.getText()))
		{
			
				BazarFrame bf = new BazarFrame(user);
				bf.setVisible(true);
				this.setVisible(false);
			
		}
		else if(command.equals(detailsBtn.getText()))
		{
				ShowDetails bf = new ShowDetails();
				bf.setVisible(true);
				this.setVisible(false);
	
		}
		else if(command.equals(mealcountBtn.getText()))
		{
				PersonFrame bf = new PersonFrame();
				bf.setVisible(true);
				this.setVisible(false);
	
		}
		else{}
	}
}