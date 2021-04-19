package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class showDetailseRepo implements IshowDetailsRepo
{
	DatabaseConnection dbc;
	
	public showDetailseRepo()
	{
		dbc = new DatabaseConnection();
	}
    public void insertshowDetils(showDetailse e)
	{
		
		String query = "INSERT INTO showdetails VALUES ('"+e.getuserId()+"','"+e.getamountOfBazar()+"','"+e.gettotalMeal()+"','"+e.gettotalCost()+"',"+e.getgetOrpaid()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	
	
	   public showDetailse searchshowDetailse(String userId)
	{
		showDetailse emp = null;
		String query = "SELECT `userId`,`totalMeal`, `amountOfBazar` FROM `showdetails` WHERE `userId`='"+userId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				//String userId = dbc.result.getString("userId");
				double totalMeal = dbc.result.getDouble("totalMeal");
				double amountOfBazar = dbc.result.getDouble("amountOfBazar");
				
				emp = new showDetailse();
				emp.setuserId(userId);
				emp.settotalMeal(totalMeal);
				emp.setamountOfBazar(amountOfBazar);
				//emp.settotalCost(totalCost);
				//emp.setgetOrpaid(getOrpaid);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void deleteshowDetailse(String userId)
	{
		String query = "DELETE from showdetails WHERE userId='"+userId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateshowDetailse(showDetailse e)
	{
		String query = "UPDATE showdetails SET userId='"+e.getuserId()+"', amountOfBazar = '"+e.getamountOfBazar()+"', totalMeal = "+e.gettotalMeal()+", totalCost = "+e.gettotalCost()+", getOrpaid = "+e.getgetOrpaid()+" WHERE userId='"+e.getuserId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public String[][] getshowDetailse()
	{
		ArrayList<showDetailse> ar = new ArrayList<showDetailse>();
		String query = "SELECT * FROM showdetails;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String userId = dbc.result.getString("userId");
				double amountOfBazar = dbc.result.getDouble("amountOfBazar");
				double totalMeal = dbc.result.getDouble("totalMeal");
			    double totalCost = dbc.result.getDouble("totalCost");
				double getOrpaid = dbc.result.getDouble("getOrpaid");
				
				showDetailse e = new showDetailse(userId,amountOfBazar,totalMeal,totalCost,getOrpaid);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((showDetailse)obj[i]).getuserId();
			data[i][1] = (((showDetailse)obj[i]).getamountOfBazar())+"";
			data[i][2] = (((showDetailse)obj[i]).gettotalMeal())+"";
			data[i][3] = (((showDetailse)obj[i]).gettotalCost())+"";
			data[i][4] = (((showDetailse)obj[i]).getgetOrpaid())+"";
		}
		return data;
	}
       
}
