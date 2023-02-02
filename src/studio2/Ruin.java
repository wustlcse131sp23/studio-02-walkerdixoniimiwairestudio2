package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("What would you like the start amount to be?");
		int startAmount = in.nextInt();
		
		System.out.println("What would you like the win limit to be?");
		int winLimit = in.nextInt(); 
		
		System.out.println("How many days would you like to play for?");
		int days = in.nextInt(); 
		int dollars = startAmount;
		
		int ruins = 0;
		
		for (int totalSimulations = 1; totalSimulations <= days ;totalSimulations++)
		{
			for (int i=0; dollars > 0 && dollars < winLimit; i++)
			{
				double coinflip = Math.random();
				boolean winChance = true;
				winChance = coinflip >= 0.3;
				int money = (winChance) ? 1: -1;
			
				dollars = dollars + money;
			
				if (dollars == 0)
				{
					System.out.println("RUIN!  You have " + dollars + " dollars.");
					System.out.println("Number of plays it took: " + i);
					ruins = ruins +1;
				}
				else if (dollars == winLimit)
				{
					System.out.println("SUCCESS!  You have " + dollars + " dollars.");
					System.out.println("Number of plays it took: " + i);
				}
			
			}
			dollars = startAmount;
			
			System.out.println("Number of days played: " + totalSimulations);
		}
		
		double ruinRate = (double)ruins/ days;
		System.out.println("Ruin rate from simulation: " + ruinRate);
		
		double expectedRuin = (Math.pow(.3/.7, startAmount) - Math.pow(.3/.7, winLimit)/(1 - Math.pow(.3/.7, winLimit)));
		System.out.println("Expected ruin rate from simulation: " + expectedRuin);
		
		
	}

}
