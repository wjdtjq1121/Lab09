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

			System.out.println("Enter data for associate number" + (i+1));
			System.out.println("Enter name of sales associate: ");
			myKeyboard.nextLine();
			team[i].name = myKeyboard.nextLine();

			System.out.println("Enter associate's sales: ");
			team[i].money = myKeyboard.nextDouble();

		}


	}


	public void Cal() {


		double sum=0;
		double highestSales=0;

		for(int i=0;i<numTeam;i++) {

			if(highestSales < team[i].money)
				highestSales = team[i].money;

			sum+=team[i].money;
		}

		averageSales = sum/3;

		this.highestSales = highestSales;
	}

	public void print() {

		System.out.println("Average sales per associate is " + this.averageSales);
		System.out.println("The highest sales figure is $ " + this.highestSales);

		System.out.println("This guy earns this amount  " + team[0].money);

	}

	//
	//	public String getName() {
	//		return name;
	//	}
	//
	//	public void setName(String name) {
	//		this.name = name;
	//	}
	//
	//	public int getSales() {
	//		return sales;
	//	}
	//
	//	public void setSales(int sales) {
	//		this.sales = sales;
	//	}


	public static void main(String[] args) {

		Sales company = new Sales(); 
		
		company.getData();
		company.Cal();
		company.print();
		
		
		
		

	}

}
