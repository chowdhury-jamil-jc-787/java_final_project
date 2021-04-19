package entity;

import java.lang.*;

public class showDetailse
{
	private String userId;
	private double getOrpaid;
	private double totalMeal;
	private double amountOfBazar;
	private double totalCost;
	
	public showDetailse(){}
	
	public showDetailse(String userId,double getOrpaid, double totalMeal, double amountOfBazar,double totalCost)
	{
		this.userId= userId;
		this.getOrpaid = getOrpaid;
		this.totalMeal = totalMeal;
		this.amountOfBazar = amountOfBazar;
		this.totalCost= totalCost;
	}
	
	public void setuserId(String userId){this.userId = userId;}
	public void setgetOrpaid(double getOrpaid){this.getOrpaid = getOrpaid;}
	public void settotalMeal(double totalMeal){this.totalMeal = totalMeal;}
	public void setamountOfBazar(double amountOfBazar){this.amountOfBazar = amountOfBazar;}
	public void settotalCost(double totalCost){this.totalCost = totalCost;}
	
	public String getuserId(){return userId;}
	public double getgetOrpaid(){return getOrpaid;}
	public double gettotalMeal(){return totalMeal;}
	public double getamountOfBazar(){return amountOfBazar;}
	public double gettotalCost(){return totalCost;}
	
	
}