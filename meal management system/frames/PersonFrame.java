package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;



public class PersonFrame extends JFrame implements ActionListener
{
	
	private JLabel perAmountLabel, perMealLabel;
	private JTextField perAmountTF,perMealTF,perMealRateTF;
	private JButton mealRateBtn, mealCountBtn,exitBtn,backBtn,eqlBtn;
	private JPanel panel;
	public int TotalBazars;
	
	public double a,b;
	public static double d=0;
	public static int c=0;

public int mealRate()
{
	return c;
}

	User user;
	
	public PersonFrame(){
		
		super("Total Bazar");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user; 
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		perAmountLabel= new JLabel("Total Bazar");
		perAmountLabel.setBounds(50,20,100,40);
		panel.add(perAmountLabel);
		
		perMealLabel= new JLabel("Total Meal");
		perMealLabel.setBounds(50,80,150,40);
		panel.add(perMealLabel);
		
		perAmountTF= new JTextField(50);
		perAmountTF.setBounds(150,20,150,40);
		panel.add(perAmountTF);
		
		perMealTF= new JTextField(10);
		perMealTF.setBounds(150,80,150,40);
		panel.add(perMealTF);
		
		mealRateBtn= new JButton("Meal Rate");
		mealRateBtn.setBounds(50,200,100,40);
		panel.add(mealRateBtn);
	
        perMealRateTF= new JTextField(10);
		perMealRateTF.setBounds(150,200,150,40);
		panel.add(perMealRateTF);
		
	   /* mealCountBtn= new JButton("Meal Count");
		mealCountBtn.setBounds(300,200,100,40);
		mealCountBtn.addActionListener(this);
		mealCountBtn.setBackground(Color.YELLOW);
		panel.add(mealCountBtn);*/
		
		exitBtn= new JButton("Exit");
		exitBtn.setBounds(60,300,100,40);
		exitBtn.addActionListener(this);
		exitBtn.setBackground(Color.YELLOW);
		panel.add(exitBtn);
		
		backBtn= new JButton("Back");
		backBtn.setBounds(200,300,100,40);
		backBtn.setBackground(Color.YELLOW);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		eqlBtn= new JButton("=");
        eqlBtn.setBounds(150,140,150,40);
		eqlBtn.addActionListener(this);
		eqlBtn.setBackground(Color.YELLOW);
		panel.add(eqlBtn);
		
		this.add(panel);
	}
	
 public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
 
  if(command.equals(backBtn.getText()))
		{
			MemberHome eh = new MemberHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(exitBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
			
		}
		/*else if(command.equals(mealCountBtn.getText()))
		{
			MealCountFrame mc = new MealCountFrame();
				mc.setVisible(true);
				this.setVisible(false);
		}*/
		else if(command.equals(eqlBtn.getText()))
		{
			BazarRepo r = new BazarRepo();
             perAmountTF.setText(String.valueOf(r.sum_bazar()));
			 
			 AllMembersRepo  r1 = new AllMembersRepo ();
             perMealTF.setText(String.valueOf(r1.sum_TotalBazar()));
			 
			 a=r.sum_bazar();
			 b=r1.sum_TotalBazar();
			 d=a/b;
			 int myInt = (int)d;
			 c = myInt;
			 
			 
			 perMealRateTF.setText(String.valueOf(c));
			 
		}
		else{}
	}
}