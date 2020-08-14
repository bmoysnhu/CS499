/*
 * 1.0 Enhancement
 * Southern NH University
 * CS 499 - Milstone 1 Code Review
 * Software Engineering Design: IT 149 - AnimalHabitat
 * Student: Brandon Moy
 * Date: 7/12/2020
 */
package monitor;

import java.util.Scanner;

public class Monitor {
    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
        String userChoice = "";
        String userPick = "";
       
        AnimalHabitatList animal = new AnimalHabitatList();
        AnimalHabitatList habitat = new AnimalHabitatList();
        
        //giving the option to view animals, habitats or exit
        while(!userChoice.equals("exit")){
        	System.out.println("Do you want to monitor animals, habitats or exit?");
        	//Enhancement 3 User interface to display options before entering selection
        	System.out.println("	-Animals include lions, tigers, bears, giraffes, pandas, zebras, and eagles.");
        	System.out.println("	-Habitats include elephants, birds, rabbits, penguins, sea otters, and an aquarium ");
        	userChoice = scnr.nextLine();
        	System.out.println("");
        	
        	//if the chose animal, display details on animals and gets animal details from AnimalHabitatList
        	if (userChoice.equals("animals")){
        		System.out.println("Which animal would you like to monitor: (please type letter for letter)");
        		//Enhancement 3 shorten the length user has to type, user simply types the animal they want to view
        		System.out.println("Details on:\n  lions\n  tigers\n  bears\n  giraffes\n  pandas\n  zebras\n  eagles");
        		System.out.println("");
        		userPick = scnr.nextLine();
        		System.out.println("");
        		animal.animalChoice(userPick);
        	}
        
        	//if the chose habitat, display details on habitats and gets habitats details from AnimalHabitatList
        	else if(userChoice.equals("habitats")){
        		System.out.println("Which habitat would you like to monitor:");
        		//Enhancement 3 shorten the length user has to type, user simply types the habitat they want to view
        		System.out.println("Details on: \n  elephants\n  birds\n  rabbits\n  penguins\n  sea otters\n  aquarium");
        		System.out.println("");
        		userPick = scnr.nextLine();
        		System.out.println("");
        		habitat.habitatChoice(userPick);
        	}
        
        	//if exit, exit loop
        	else if(userChoice.equals("exit")){
        		System.out.println("GoodBye");
        		//enhancement 1 closing the scanner
        		scnr.close();
        	}
     
        	//for invalid entries and returns user to beginning prompt
        	else{
        		//enhancement 3 reminds user that proper spelling and capitalization is needed
        		System.out.println("***Error: Check spelling and capitalization***");
        		System.out.println("");
        	}
        }
    }
    
}