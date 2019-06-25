package lab1;

import javax.swing.*;

/**
 * <p>Title: Lab #1</p>
 *
 * <p>Description: Airplane Class - An object of type Airplane contains a 
 * reference to a Seat array. The airplane has 10 seats. The first 4 seats are
 * first class and the remaining are coach class seats. A 
 * user can book a seat or cancel a seat. There is also a toString method that 
 * can be used to see the current status of all seats.</p>
 *
 * @author <your names>
 */
public class Airplane
{
	private Seat[] seats;

	/**
	 * default constructor --
	 * Creates an Airplane that has 10 seats; the first 4 are first
	 * class and the remaining 6 are coach class seats.
	 */
	public Airplane()
	{
		seats = new Seat[10];
		for (int i=0; i<4; i++)
			seats[i] = new Seat("First Class", i+1);
		for (int i=4; i<seats.length; i++)
			seats[i] = new Seat("Coach Class", i+1);
	}

	/**
	 * assignFirstClass --
	 * Assigns the next available first class seat if one is available. A message is
	 * displayed indicating the number and class of the seat that has been reserved if 
	 * one is available; if not, a message is displayed indicating that there are no 
	 * more first class seats available.
	 */
	public void assignFirstClass()
	{
		int u=0;
		int j=0;
		for(int i=0; i<4;i++)
		{
			if(seats[i].isEmpty() == true)
			{
			u++;
			}
		}
		String[] choicesNum= new String[u];
		for(int n=0; n<4;n++)
		{
		if(seats[n].isEmpty() == true)
		{
			choicesNum[j] = seats[n].getSeatNumber() + "";
				j++;
		}
		}
		if(u>0)
		{
		int choice = JOptionPane.showOptionDialog(null,
				"Enter your choice...", 			//text displayed in the window
				"Reservation System Menu",          //text displayed in the window's title bar
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				choicesNum,                			//text to be displayed in each button
				choicesNum[0]);            			//default button
		
		int w =Integer.parseInt(choicesNum[choice]);
		seats[w-1].assignSeat();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Sorry, there are no more first class seats avaliable.");
		}
	
	}
	
	/**
	 * assignCoachClass --
	 * Assigns the next available coach class seat if one is available. A message is
	 * displayed indicating the number and class of the seat that has been reserved if 
	 * one is available; if not, a message is displayed indicating that there are no 
	 * more coach class seats available.
	 */
	public void assignCoachClass()
	{
		int u=0;
		int j=0;
		for(int i=4; i<10;i++)
		{
			if(seats[i].isEmpty() == true)
			{
			u++;
			}
		}
		String[] choicesNum= new String[u];
		for(int n=4; n<10;n++)
		{
		if(seats[n].isEmpty() == true)
		{
			choicesNum[j] = seats[n].getSeatNumber() + "";
				j++;
		}
		}
		if(u>0)
		{
		int choice = JOptionPane.showOptionDialog(null,
				"Enter your choice...", 			//text displayed in the window
				"Reservation System Menu",          //text displayed in the window's title bar
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				choicesNum,                			//text to be displayed in each button
				choicesNum[0]);            			//default button
		
		int w =Integer.parseInt(choicesNum[choice]);
		seats[w-1].assignSeat();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Sorry, there are no more coach class seats avaliable.");
		}
	
	}

	/**
	 * cancelSeat --
	 * The user is asked to enter the number of the seat they wish to cancel. As long
	 * as the number is valid and the seat is currently occupied, then the requested
	 * seat is cancelled. An appropriate message is displayed to inform the user of 
	 * the result. 
	 */
	public void cancelSeat()
	{
		int sNum = Integer.parseInt(JOptionPane.showInputDialog
				("Enter the number of the seat you would like to cancel."));
		sNum--;
		if (sNum < 0 || sNum >= seats.length)
			JOptionPane.showMessageDialog(
					null,
					"Sorry, the seat number you entered is invalid.",
					"Reservation System",
					JOptionPane.DEFAULT_OPTION);
		else
			if (seats[sNum].isEmpty())
				JOptionPane.showMessageDialog(
						null,
						"Sorry, the seat you specified is not reserved!",
						"Reservation System",
						JOptionPane.DEFAULT_OPTION);
			else
			{
				seats[sNum].cancelSeat();
				JOptionPane.showMessageDialog(
						null,
						"Thank you, your reservation has been cancelled. Please come back again soon.",
						"Reservation System",
						JOptionPane.DEFAULT_OPTION);
			}
	}

	/**
	 * toString --
	 * Returns a string representing the current state of the airplane.
	 * @return the status of all seats on the plane
	 */
	public String toString()
	{
		String str= new String();
		for(int i=0;i<10;i++)
		{
			str =str + seats[i].toString() + "\n"; 
		}
			return str;
	}
}

