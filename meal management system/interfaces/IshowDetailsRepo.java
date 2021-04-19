package interfaces;

import java.lang.*;
import entity.*;

public interface IshowDetailsRepo
{
	public void insertshowDetils(showDetailse e);
	public void deleteshowDetailse(String userId);
	public void updateshowDetailse(showDetailse e);
	public showDetailse searchshowDetailse(String userId);
	//public double sum_bazar();
	public String[][] getshowDetailse();
}