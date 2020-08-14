/*addContact.sql be used to add contacts into DB phonebook*/
/*User will have to change the values in insert to add contacts*/

/* Assignment: Milestone 4 Inital Enhancement DAD 220*/
/* Intial Enhancement 2 */
/* Author: Brandon Moy */
/* Version: 1.0 */
/* Date: 7.29.2020*/

/*type "source Phonebook/addContact.sql" to run script */

/*uses the database phonebook*/
USE phonebook;

/*inserts contact information into the table "contacts"*/
/*Change insert values to add new contacts to the phonebook*/
INSERT INTO contacts(first_name, last_name, phone_number, age, zip_code)
    VALUES("Stevie","H", "(650)678-6731", 24, 94404),
    ("Kevin", "Chow", "(415)785-5333", 25, 94016),
    ("Mike", "0", "(650)223-5613", 25, 94404),
    ("Henry", "A", "(510)664-8906", 28, 94612),
    ("Tiffany","Y", "(650)443-5566", 26, 94017);
  
/*Default phonebook view is ordered by first name in ascending order*/
SELECT * FROM contacts ORDER BY first_name ASC;

/*Uncomment line below to view phonebook by first name descending order*/
/*SELECT * FROM contacts ORDER BY first_name DESC;*/

/*Uncomment line below to view phonebook by last name ascending order*/
/*SELECT * FROM contacts ORDER BY last_name ASC;*/

/*Uncomment line below to view phonebook by last name descending order*/
/*SELECT * FROM contacts ORDER BY last_name DESC;*/