/*
 * 1.0 Enhancement
 * Southern NH University
 * CS 499 - Milestone 1 Code Review
 * Software Engineering Design: IT 149 - AnimalHabitat
 * Student: Brandon Moy
 * Date: 7/12/2020
 */

package monitor;

public class AnimalHabitatList {
	String pick;
    //File strings to view animals/animal habitats.
    String lions = "Animal - Lion\nName: Leo\nAge: 5\n*****Health concerns: Cut on left front paw\nFeeding schedule: Twice daily\n";
    String tigers = "Animal - Tiger\nName: Maj\nAge: 15\nHealth concerns: None\nFeeding schedule: 3x daily\n";
    String bears = "Animal - Bear\nName: Baloo\nAge: 1\nHealth concerns: None\n*****Feeding schedule: None on record\n";
    String giraffes = "Animal - Girafee\nName: Spots\nAge: 12\nHealth concerns: None\nFeeding schedule: Grazing\n";
    //enhancement 2 created additional animal
    String pandas = "Animals - Panda\nName: Bao\nAge: 2\nHealth concerns: premature\nFeeding schedule: Three times daily\n";
    String zebras = "Animals - Zebra\nName: Zephyer\nAge: 20\n*****Health concerns: Broken leg\nFeeding schedule: Three times daily\n";
    String eagles =  "Animals - Eagle\nName: Gold\nAge: 6\nHealth concerns: None\nFeeding schedule: Worms ever 3 hours\n";
    
    //enhancement 2 created additional animal
    String elephants = "Habitat - Elephants\nTemperature: Mild to Hot\nFood source: Daily Grass in habitat and twice a day fruit\n*****Cleanliness: Needs cleaning from feces\n";
    String sea_otters = "Habitat - Sea Otters\nTemperature: Below 50F\n*****Food source: Three times a day, fish feeded\nCleanliness: Passed\n";
    String rabbits =  "Habitat - Rabbits\nTemperature: Natural\n*****Food source: Grass\nCleanliness: Passed\n";
    //old strings
    String penguins = "Habitat - Penguin\nTemperature: Freezing\n*****Food source: Fish in water running low\nCleanliness: Passed\n";
    String birds = "Habitat - Bird\nTemperature: Moderate\nFood source: Natural from environment\nCleanliness: Passed\n";
    String aquarium = "Habitat - Aquarium\nTemperature: Varies with output temperature\nFood source: Added daily\n*****Cleanliness: Needs cleaning from algae\n";
    
    //main will pull this if userChoice is animals
    public void animalChoice(String animalPick ){

		//Details for lion 
    	if (animalPick.equals("lions")){
            pick = animalPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (lions.contains("*****")){
                System.out.print(lions.replace("*****","ALERT: "));
                System.out.println("");
            }
            //if no "*****" will print original file without replacing anything
            else{
                System.out.println(lions);
            }
        }
        //details for tigers
        else if (animalPick.equals("tigers")){
            pick = animalPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (tigers.contains("*****")){
                System.out.print(tigers.replace("*****","ALERT: "));
                System.out.println("");
            }
            //if no "*****" will print original file without replacing anything
            else{
                System.out.println(tigers);
            }
        }
        //Details for bears
        else if (animalPick.equals("bears")){
            pick = animalPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (bears.contains("*****")) {
                System.out.print(bears.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(bears);
            }
        }
    	//enhancement 2 created additional animal
    	//Details for pandas 
        else if (animalPick.equals("pandas")){
            pick = animalPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (pandas.contains("*****")){
                System.out.print(pandas.replace("*****","ALERT: "));
                System.out.println("");
            }
            //if no "*****" will print original file without replacing anything
            else{
                System.out.println(pandas);
            }
        }
        //Details for giraffes
        else if (animalPick.equals("giraffes")){
            pick = animalPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (giraffes.contains("*****")) {
                System.out.print(giraffes.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(giraffes);
            }
        }
    	//enhancement 2 created additional animal
        //Details for eagles
        else if (animalPick.equals("eagles")){
            pick = animalPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (eagles.contains("*****")){
                System.out.print(eagles.replace("*****","ALERT: "));
                System.out.println("");
            }
            //if no "*****" will print original file without replacing anything
            else{
                System.out.println(eagles);
            }
        }
    	//enhancement 2 created additional animal
        //Details for zebras 
        else if (animalPick.equals("zebras")){
            pick = animalPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (zebras.contains("*****")){
                System.out.print(zebras.replace("*****","ALERT: "));
                System.out.println("");
            }
            //if no "*****" will print original file without replacing anything
            else{
                System.out.println(zebras);
            }
        }
        //returns user to first loop in Monitor of deciding between animal, habitat, or exit
        else{
        	//enhancement 3 reminds user that proper spelling and capitalization is needed
            System.out.println("***Error: Check spelling and capitalization***");
            System.out.println("");
        }
    }
    
    //main will pull this if userChoice is habitats
    public void habitatChoice(String habitatPick){
    	
        //details on penguins
        if (habitatPick.equals("penguins")){
           pick = habitatPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (penguins.contains("*****")) {
                System.out.print(penguins.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(penguins);
            }
        }
        //enhancement 2 created additional habitat
        //details on elephants
        else if (habitatPick.equals("elephants")){
           pick = habitatPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (elephants.contains("*****")) {
                System.out.print(elephants.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(elephants);
            }
        }
        //details on birds
        else if (habitatPick.equals("birds")){
            pick = habitatPick;
            if (birds.contains("*****")) {
                System.out.print(birds.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(birds);
            }
        }
        //enhancement 2 created additional habitat
        //details on sea_otters
        else if (habitatPick.equals("sea otters")){
           pick = habitatPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (sea_otters.contains("*****")) {
                System.out.print(sea_otters.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(sea_otters);
            }
        }
        //details on aquarium
        else if (habitatPick.equals("aquarium")){
            pick = habitatPick;
            if (aquarium.contains("*****")) {
                System.out.print(aquarium.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(aquarium);
            }
        }
        //enhancement 2 created additional habitat
        //details on rabbits 
        else if (habitatPick.equals("rabbits")){
           pick = habitatPick;
            //if statement finds "*****" and replaces it with dialog box and ALERT to display the Alert
            if (rabbits.contains("*****")) {
                System.out.print(rabbits.replace("*****", "ALERT: "));
                System.out.println("");
            } //if no "*****" will print original file without replacing anything
            else {
                System.out.println(rabbits);
            }
        }
        //returns user to first loop of Monitor when deciding between animal, habitat, or exit
        else{
        	//enhancement 3 reminds user that proper spelling and capitalization is needed
            System.out.println("***Error: Check spelling and capitalization***");
        }
    }
                
    }
    

