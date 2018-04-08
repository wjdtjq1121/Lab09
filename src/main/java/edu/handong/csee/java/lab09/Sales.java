package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class Sales {

	private String name;
	private double money;

	private double highestSales;
	private double averageSales;
	private Sales[] team;
	private int numTeam;


	public void getData() {

		Scanner myKeyboard = new Scanner(System.in);
		System.out.println("Enter number of sales associates: ");
		this.numTeam = myKeyboard.nextInt();


		team = new Sales[numTeam];

		for(int i=0; i<numTeam; i++) {
			team[i] = new Sales();

			System.out.println("Enter data for associate number " + (i+1));
			System.out.println("Enter name of sales associate: ");
			myKeyboard.nextLine();
			team[i].name = myKeyboard.nextLine();

			System.out.println("Enter associate's sales: ");
			team[i].money = myKeyboard.nextDouble();

		}


	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	public void Cal() {


		double sum=0;
		double highestSales=0;

		for(int i=0;i<numTeam;i++) {

			if(highestSales < team[i].money)
				highestSales = team[i].money;

			sum+=team[i].money;
		}

		averageSales = sum/numTeam;

		this.highestSales = highestSales;
	}

	public void print() {
		
		
		System.out.printf("Average sales per associate is $%.1f \n", this.averageSales);
		System.out.printf("The highest sales figure is $%.1f \n", this.highestSales);

		System.out.println("The following had the highest sales: ");
		
		for(int i=0; i<numTeam; i++) {
		if(team[i].money == this.highestSales) {
			System.out.println("Name: " + this.team[i].name);
			System.out.printf("Sales: %.1f \n", this.team[i].money);
			
			if(this.averageSales < this.team[i].money)			
			System.out.printf("$%.1f above the average. \n", (this.team[i].money - this.averageSales));
			else
			System.out.printf("$%.1f below the average. \n", (this.averageSales - this.team[i].money));
			}		
		}

		System.out.println("The rest performed as follows: ");
		
		for(int i=0; i<numTeam; i++) {
			if(team[i].money != this.highestSales) {
				System.out.println("Name: " + this.team[i].name);
				System.out.printf("Sales: %.1f \n", this.team[i].money);
				
				if(this.averageSales < this.team[i].money)			
				System.out.printf("$%.1f above the average. \n", (this.team[i].money - this.averageSales));
				else
				System.out.printf("$%.1f below the average. \n", (this.averageSales - this.team[i].money));
				}		
			}
	
	
	
	
	
	}


	public static void main(String[] args) {

		Sales company = new Sales(); 
		
		company.getData();
		company.Cal();
		company.print();
		
		
		
		

	}

}

