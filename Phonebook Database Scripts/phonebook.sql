/*phonebook.sql will create a database called phonebook
this database will hold phone contacts and store information
such as id, first and last name phone number, gender, age, 
zip code, and a primary key*/

/* Assignment: Milestone 4 Inital Enhancement DAD 220*/
/* Author: Brandon Moy */
/* Version: 1.1 */
/* Date: 7.29.2020*/

/*type "source Phonebook/phonebook.sql" to run script */

/*Creates a database called phonebook*/
CREATE DATABASE IF NOT EXISTS phonebook;

/*uses the database phonebook*/
USE phonebook;

/*creates a table named "contacts" to store contact information*/
CREATE TABLE contacts(
    person_id INT(8) UNSIGNED NOT NULL auto_increment, /*creates person_id  row*/
    first_name VARCHAR(255) NOT NULL,   /*creates first name row*/
    last_name VARCHAR(255) NOT NULL,    /*creates last name row*/
    phone_number VARCHAR (20) NOT NULL,   /*creates phone_number row*/
    age INT(8) UNSIGNED NULL,   /*creates age row*/
    zip_code INT(5) UNSIGNED NULL,  /*creates zip_code row*/
    PRIMARY KEY (person_id) /*creates primary key field*/ 
    )AUTO_INCREMENT =1; /*increments by 1*/

/*inserts contact information into the table "contacts"*/
INSERT INTO contacts(first_name, last_name, phone_number, age, zip_code)
    VALUES("Brandon","Moy", "(650)623-2095", 25, 94404),
    ("Serena", "C", "(650)515-5132", 25, 94404),
    ("Betty", "LM", "(650)703-2095", 60, 94404),
    ("Nick", "M", "(650)766-2095", 28, 94404),
    ("Bill","WM", "(650)766-2888", 65, 94404);
    
/* Intial Enhancement 1.1 */    
/*Default phonebook view is ordered by first name in ascending order*/
SELECT * FROM contacts ORDER BY first_name ASC;

/* Intial Enhancement 1.2 */
/*Uncomment line below to view phonebook by first name descending order*/
/*SELECT * FROM contacts ORDER BY first_name DESC;*/

/* Intial Enhancement 1.3 */
/*Uncomment line below to view phonebook by last name ascending order*/
/*SELECT * FROM contacts ORDER BY last_name ASC;*/

/* Intial Enhancement 1.4 */
/*Uncomment line below to view phonebook by last name descending order*/
/*SELECT * FROM contacts ORDER BY last_name DESC;*/