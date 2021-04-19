package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ShowDetails extends JFrame implements ActionListener
{

private JLabel manIdLabel, manNameLabel, manDesignationLabel, manAmountLabel,label1,label2,label3,label4,label5,label6,label7;
	private JTextField manIdTF, manNameTF, manDesignationTF, manTotalAmountTF,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
	private JButton button1,button2,button3,button4,buttonjc,buttonjc1;
	private JPanel panel;
	private JTable manTable;
	private JScrollPane manTableSP;
	
    private User user;
	private BazarRepo er;
	private UserRepo ur;
	private AllMembersRepo er1;
	private showDetailseRepo jc;
	
	
	public double jc1,jc2,jc3,jc4,jc5;
	
	public ShowDetails()
	{
		super("ShowDetails");
		this.setSize(1300,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		er = new BazarRepo();
		ur = new UserRepo();
		jc = new showDetailseRepo();
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "", ""}};
		
		String head[] = {"userId", "totalCost", "totalMeal", "getOrpaid","amountOfBazar"};
		
		manTable = new JTable(data,head);
		manTableSP = new JScrollPane(manTable);
		manTableSP.setBounds(600, 150, 600, 350);
		manTable.setEnabled(false);
		panel.add(manTableSP);


label3= new JLabel("Total Bazar");
label3.setBounds(80,20,80,40);
panel.add(label3);

text3= new JTextField(10);
text3.setBounds(170,20,150,40);
panel.add(text3);

label2= new JLabel("Total Meal");
label2.setBounds(420,20,80,40);
panel.add(label2);

text2= new JTextField(10);
text2.setBounds(510,20,150,40);
panel.add(text2);

label1= new JLabel("Meal Rate");
label1.setBounds(720,20,80,40);
panel.add(label1);

text1= new JTextField(10);
text1.setBounds(800,20,150,40);
panel.add(text1);

buttonjc= new JButton("Show");
buttonjc.setBounds(1050,20,100,40);
buttonjc.addActionListener(this);
panel.add(buttonjc);

label4= new JLabel("User Id");
label4.setBounds(80,100,100,40);
panel.add(label4);

text4= new JTextField();
text4.setBounds(170,100,150,40);
panel.add(text4);

text5= new JTextField();
text5.setBounds(80,170,120,40);
panel.add(text5);

label5= new JLabel("*");
label5.setBounds(220,170,80,40);
panel.add(label5);

text6= new JTextField();
text6.setBounds(250,170,120,40);
panel.add(text6);

button3= new JButton("Meal Cost");
button3.setBounds(80,230,100,40);
button3.addActionListener(this);
panel.add(button3);

text7= new JTextField();
text7.setBounds(200,230,120,40);
panel.add(text7);

label7= new JLabel("Get or Paid Amount");
label7.setBounds(120,320,150,50);
panel.add(label7);

text8= new JTextField();
text8.setBounds(80,390,120,40);
panel.add(text8);

label6= new JLabel("-");
label6.setBounds(220,390,80,40);
panel.add(label6);

text9= new JTextField();
text9.setBounds(250,390,120,40);
panel.add(text9);

button4= new JButton("Get/Paid");
button4.setBounds(80,450,100,40);
button4.addActionListener(this);
panel.add(button4);

text10= new JTextField();
text10.setBounds(210,450,120,40);
panel.add(text10);

button1= new JButton("Exit");
button1.setBounds(700,550,100,40);
button1.setBackground(Color.YELLOW);
button1.addActionListener(this);
panel.add(button1);

button2= new JButton("Back");
button2.setBounds(100,550,100,40);
button2.setBackground(Color.YELLOW);
button2.addActionListener(this);
panel.add(button2);

buttonjc1= new JButton("GetAll");
buttonjc1.setBounds(1050,550,100,40);
buttonjc1.setBackground(Color.YELLOW);
buttonjc1.addActionListener(this);
panel.add(buttonjc1);



this.add(panel);

}
 public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(button3.getText()))
		{
			if(!text4.getText().equals("") || !text4.getText().equals(null))
			{
				showDetailse e = jc.searchshowDetailse(text4.getText());
				if(e!= null)
				{
					text5.setText(e.gettotalMeal()+"");
					
					//text5.setText(e.getbId());
					text8.setText(e.getamountOfBazar()+"");
					
					text4.setEnabled(false);
					//text4.setEnabled(true);
					text5.setEnabled(true);
					//bzAmountTF.setEnabled(true);
					
					//updateBtn.setEnabled(true);
					//deleteBtn.setEnabled(true);
					//refreshBtn.setEnabled(true);
					//insertBtn.setEnabled(false);
					//button3.setEnabled(false);
					
					 PersonFrame r2 = new PersonFrame ();
                     text6.setText(String.valueOf(r2.mealRate()));
					 
					 jc1=r2.mealRate();
					 jc2=Double.parseDouble(e.gettotalMeal()+"");
					 jc3=jc1*jc2;
					jc4=Double.parseDouble(e.getamountOfBazar()+"");
					jc5=jc4-jc3;
					int myInt = (int)jc5;
					int myInt1 = (int)jc3;
					
					text7.setText(String.valueOf(myInt1));
					text9.setText(String.valueOf(myInt1));
					text10.setText(String.valueOf(myInt));
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Data");
				}
			}
		}
		
		

		
		
	    else if(command.equals(button2.getText()))
		{
			MemberHome lf = new MemberHome(user);
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(button1.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
			//System.exit(0);
		}
		
		else if(command.equals(buttonjc.getText()))
		{
			BazarRepo r = new BazarRepo();
             text3.setText(String.valueOf(r.sum_bazar()));
			 
			 AllMembersRepo  r1 = new AllMembersRepo ();
             text2.setText(String.valueOf(r1.sum_TotalBazar()));
			 
			 
			 PersonFrame r2 = new PersonFrame ();
             text1.setText(String.valueOf(r2.mealRate()));
			 
			 
		}
		
		
		else if(command.equals(buttonjc1.getText()))
		{
			String data[][] = jc.getshowDetailse();
			String head[] = {"userId", "totalCost", "totalMeal", "getOrpaid","amountOfBazar"};
			
                        
			panel.remove(manTableSP);
			
			manTable = new JTable(data,head);
			manTable.setEnabled(false);
			manTableSP = new JScrollPane(manTable);
			manTableSP.setBounds(600, 150, 600, 350);
			panel.add(manTableSP);
			
			panel.revalidate();
			panel.repaint();
		}
		else{}
	}
}
