package edu.handong.csee.java.lab09; // Set the package where this class belongs to

import java.util.Scanner; // gets the Scanner class from the package (libarary) java.util

/**
 * This class defines to get the sales and names of salesmen. </br>
 * gets total people from the user and get the highest sales person and average sales of salesmen.</br>
 * @author HAN
 */
public class Sales { // its a class which can access from other package

	private String name; // declares name member
	private double money; // declares money member

	private double highestSales; // declares top sales member
	private double averageSales; // declares aver. member
	private Sales[] team; // declares the array Sales
	private int numTeam; // declares total num of salesmen member

	/**
	 * This class defines to get the data sales and names of salesmen. </br>
	 * gets total people from the user and store them in the array team.</br>
	 * @author HAN
	 */
	public void getData() { // a method to get the data from the user 

		Scanner myKeyboard = new Scanner(System.in); // sets up things so the program can accept keyboard input
		System.out.println("Enter number of sales associates: "); // prints to ask the user to get the num of salesmen
		this.numTeam = myKeyboard.nextInt(); // stores the value in numteam


		team = new Sales[numTeam]; // makes the number of user inputs with using array.

		for(int i=0; i<numTeam; i++) { // executes loop recurrence
			team[i] = new Sales(); // instantiate array team.

			System.out.println("Enter data for associate number " + (i+1)); // prints which num of men
			System.out.println("Enter name of sales associate: "); // asks user to put the name of specific man
			myKeyboard.nextLine(); // gets the enter key here, so error doesnt occur
			team[i].name = myKeyboard.nextLine(); // stores the string value in the array team

			System.out.println("Enter associate's sales: "); // asks user to put sales value
			team[i].money = myKeyboard.nextDouble(); // stores the value in array team
		}
	}


	/**
	 * This class defines to compute average and highest sales. </br>
	 * @author HAN
	 */
	public void Cal() { // a method, to calculate the data
		double sum=0; // initialize the sum member
		double highestSales=0; // initialize the highestsales member

		for(int i=0;i<numTeam;i++) { // executes for loop

			if(highestSales < team[i].money) // condition if the other guy earns more money
				highestSales = team[i].money; // stores the value in highestsales member

			sum+=team[i].money; // stack up the money value
		}

		averageSales = sum/numTeam; // divide by num of sales men to get average

		this.highestSales = highestSales; // stores the value in the class, not in this local method member.
	}

	/**
	 * This class shows the final result of average and highest sum and each salesman's name and sales. </br>
	 * @author HAN
	 */
	public void print() { // a method to show the result of average, highest sales, and each salesman's name and sales.


		System.out.printf("Average sales per associate is $%.1f \n", this.averageSales); // prints the average sales
		System.out.printf("The highest sales figure is $%.1f \n", this.highestSales); // prints the highest sales

		System.out.println("The following had the highest sales: "); // prints what next step is coming

		for(int i=0; i<numTeam; i++) { // executes recurrence statement
			if(team[i].money == this.highestSales) { // condition if the array index has the highest value
				System.out.println("Name: " + this.team[i].name); // prints the name of array index
				System.out.printf("Sales: %.1f \n", this.team[i].money); // prints the sales of array index

				if(this.averageSales < this.team[i].money)	// condition if the guy earns much money
					System.out.printf("$%.1f above the average. \n", (this.team[i].money - this.averageSales)); // prints the guy earns much money.
				else // otherwise
					System.out.printf("$%.1f below the average. \n", (this.averageSales - this.team[i].money)); // prints the guy earns less money
			}		
		}

		System.out.println("The rest performed as follows: "); // prints the other sales men info

		for(int i=0; i<numTeam; i++) { // executes for loop
			if(team[i].money != this.highestSales) { // condition the guys are not the highestsales 
				System.out.println("Name: " + this.team[i].name); // prints the index of names
				System.out.printf("Sales: %.1f \n", this.team[i].money); //prints the index of money

				if(this.averageSales < this.team[i].money)			// condition they guy earns much money than average
					System.out.printf("$%.1f above the average. \n", (this.team[i].money - this.averageSales)); // prints the sales the guy earns much money
				else // otherwise
					System.out.printf("$%.1f below the average. \n", (this.averageSales - this.team[i].money)); // prints the sales the guy earns less money
			}		
		}

	}

	/**
	 * first, execute the instantiation. </br>
	 * It calls three methods to get data and compute data and show the data.</br>
	 * @author HAN
	 */
	public static void main(String[] args) { // a void method, invoked by the system

		Sales company = new Sales();  // instantiate the sales names company

		company.getData(); // calls a method getdata
		company.Cal(); // calls a method to compute data
		company.print(); // calls a method to print the all the statement of average, highest value, and each salesman's name and sales.
	}

}

