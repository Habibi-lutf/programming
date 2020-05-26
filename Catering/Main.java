package practice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Array of three elements for three Dessert (borek, cake and drink)
		int [] Dessert = {30,15,30};
		
		// Array of three elements for three trays(borek, cake and drink)
		int [] trays= {0, 0, 0};
		
		//fill the trays for the first time
		fillTray(Dessert, trays);
	
		//user input
		Scanner input = new Scanner(System.in);
		
		//instance of Dessert
		Dessert []numberOfGuest = new Dessert[10];
	
		//inst... the Guest List
		for(int i = 0 ; i < numberOfGuest.length; i++) {
			numberOfGuest[i]=new Dessert();
		}
						
		//Display and control the guest.
		while((Dessert[0]+Dessert[1]+Dessert[2]) != 0) {
			//dsiplay stock and Trays
			System.out.print("Stock: You have " + Dessert[0]+" Borek ,  "+ Dessert[1]+" Cake  and "+ Dessert[2]+" Drink in Stock");
			System.out.print("\nTrays: You have " + trays[0]+" Borek ,  "+ trays[1]+" Cake  and "+ trays[2]+" Drink in Trays");
			System.out.println();//remove buffer
		
			System.out.println("\n Enter the Guest number that want to eat ");
			String guest=input.nextLine();
						
			switch(guest) {
			
			//# of Guest.
			case "1": {
				guestEat(Dessert, trays, numberOfGuest,0);	
			}break;
			case "2": {
				guestEat(Dessert, trays, numberOfGuest,1);
			}break;
			case "3":{
				guestEat(Dessert, trays, numberOfGuest,2);
			}break;
			case "4":{
				guestEat(Dessert, trays, numberOfGuest,3);
			}break;
			case "5":{
				guestEat(Dessert, trays, numberOfGuest,4);
			}break;
			case "6":{
				guestEat(Dessert, trays, numberOfGuest,5);
			}break;
			case "7":{
				guestEat(Dessert, trays, numberOfGuest,6);
			}break;
			case "8":{
				guestEat(Dessert, trays, numberOfGuest,7);
			}break;
			case "9":{
				guestEat(Dessert, trays, numberOfGuest,8);
			}break;
			case "10":{
				guestEat(Dessert, trays, numberOfGuest,9);
			}break;
			
			default:{
				System.out.println("This guest is not in the Party ");
				}
			}
		}
	}
	public static void fillTray(int[] D, int[] T) {
		
		for(int i= 0; i<D.length; i++) {
			D[i]-=5;
			T[i]+=5;
		}
		System.out.println("Trays Filled Automatically at first time!");
		
	}
	public static void guestEat(int[] D, int[] T,Dessert [] Guests, int guestNumber) {
		
		int borek=0;
		int cake=0;
		int drink=0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Dessert Name (Borek, Cake or Drink)");
		String str=input.nextLine();
		str=str.toUpperCase();
		
		if(str.contentEquals("BOREK")) {
			if(T[0]>0) {
				if(Guests[guestNumber].getBorek()==5) {
					System.out.print("\n You already ate 5 borek.Try Something else");
					System.out.println(" ---> Press any key to Continue...\n");
					input.nextLine();
				}
				else {
					System.out.println("\nSo far this Guest had : "+ Guests[guestNumber].getBorek()+" Borek, "+
																	 Guests[guestNumber].getCake()+" Cake and "+Guests[guestNumber].getDrink()+" Drink");
		
					System.out.println("\n you are only allowed to eat only "+ (5-Guests[guestNumber].getBorek())+"\n Enter # of Borek");
									
					//user input
					borek=input.nextInt();
					boolean ctrl=false;
					while(!ctrl) {
						if(borek < 0 || borek>(5-Guests[guestNumber].getBorek())) {
							System.out.println("You are Allowed to eat only "+ (5-Guests[guestNumber].getBorek())+" more Borek"+"\n Enter # of Borek");
							borek=input.nextInt();
						}
						else {
							ctrl=true;
						}
					}
					//record of borek
					Guests[guestNumber].setBorek(borek);	
					
					//deduct from the trays.
					if(T[0]!=0 && T[0]>=borek) {
						T[0]-=borek;
					}
					else {
						D[0]-=borek;
					}
					
					//refill tray if it is available in stock
					if(T[0]==0 && D[0]>0){
						T[0]=5;
						D[0]-=5;
						System.out.println("\nBorek Tray Refilled By Waiter!\n");
					}	
				}							
			}
			else {
				System.out.print("\n ALERT.... Sorry, there is no more Borek in stock or in Trays!\n");
				System.out.println(" ---> Press any key to Continue...\n");
				input.nextLine();
			}
			
		}
		else if(str.equals("CAKE")) {
			if(T[1]>0) {
				if(Guests[guestNumber].getCake()==2) {
					System.out.print("\n You already ate 2 Slices of Cake.Try Something else");
					System.out.println(" ---> Press any key to Continue...\n");
					input.nextLine();
				}
				else {
					System.out.println("\nSo far this Guest had : "+ Guests[guestNumber].getBorek()+" Borek, "+
							 Guests[guestNumber].getCake()+" Cake and "+Guests[guestNumber].getDrink()+" Drink");
		
					System.out.println("\n you are only allowed to eat only "+ (2-Guests[guestNumber].getCake()+"\n Enter # of Cake"));
									
					//user input
					cake=input.nextInt();
					boolean ctrl=false;
					while(!ctrl) {
						if(cake < 0 || cake>(2-Guests[guestNumber].getCake())) {
							System.out.println("You are Allowed to eat "+ (2-Guests[guestNumber].getCake())+" more Slices of Cake"+"\n Enter # of Cake");
							cake=input.nextInt();
						}
						else {
							ctrl=true;
						}
					}
					//record of Cake
					Guests[guestNumber].setCake(cake);	
					
					//deduct from the trays.
					if(T[1]!=0 && T[1]>=cake) {
						T[1]-=cake;
					}
					else {
						D[1]-=cake;
					}
					
					//refill tray if it is available in stock
					if(T[1]==0 && D[1]>0){
						T[1]=5;
						D[1]-=5;
						System.out.println("\nCake Tray Refilled By Waiter!\n");
					}	
				}					
					
			}
			else {
				System.out.print("\n ALERT.... Sorry, there is no more Cake in stock or in Trays!\n");
				System.out.println(" ---> Press any key to Continue...\n");
				input.nextLine();
			}
		}
		
		else if(str.equals("DRINK")) {
			if(T[2]>0) {
				if(Guests[guestNumber].getDrink()==5) {
					System.out.print("\n You already used 5 Drinks.Try Something else");
					System.out.println(" ---> Press any key to Continue...\n");
					input.nextLine();
				}
				else {
					System.out.println("\nSo far this Guest had : "+ Guests[guestNumber].getBorek()+" Borek, "+
							 Guests[guestNumber].getCake()+" Cake and "+Guests[guestNumber].getDrink()+" Drink");
		
					System.out.println("\n you are only allowed to drink "+ (5-Guests[guestNumber].getDrink()+" Drink(s)"+"\n Enter # of drink"));
									
					//user input
					drink=input.nextInt();
					boolean ctrl=false;
					while(!ctrl) {
						if(drink < 0 || cake>(5-Guests[guestNumber].getDrink())) {
							System.out.println("You are Allowed to drink "+ (5-Guests[guestNumber].getDrink())+" more Soda"+"\n Enter # of drink");
							cake=input.nextInt();
						}
						else {
							ctrl=true;
						}
					}
					//record of Cake
					Guests[guestNumber].setDrink(drink);;	
					
					//deduct from the trays.
					if(T[2]!=0 && T[2]>=drink) {
						T[2]-=drink;
					}
					else {
						D[2]-=drink;
					}
					
					//refill tray if it is available in stock
					if(T[2]==0 && D[2]>0){
						T[2]=5;
						D[2]-=5;
						System.out.println("\nDrink Tray Refilled By Waiter!\n");
					}
				}					
					
			}
			else {
				System.out.print("\n ALERT.... Sorry, there is no more Drink in stock or in Trays!\n");
				System.out.println(" ---> Press any key to Continue...\n");
				input.nextLine();
			}
			
		}
	}
}

