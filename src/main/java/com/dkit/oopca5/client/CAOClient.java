package com.dkit.oopca5.client;

/* The client package should contain all code and classes needed to run the Client
 */

/* The CAOClient offers students a menu and sends messages to the server using TCP Sockets
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CAOClient
{
    public static void main(String[] args) {
        loginMenu();
    }

    public static void loginMenu() {
        System.out.println("********************************");
        System.out.println("CAO Login System");
        System.out.println("********************************");

        Scanner keyboard = new Scanner(System.in);

        int choice = -1;
        String strInput;

        while (choice < 0 || choice > 2) {
            System.out.println("Please choose an option:");
            System.out.println("0. Quit Application");
            System.out.println("1. Register");
            System.out.println("2. Login");

            boolean validChoice = false;
            boolean loggedIn;

            while (validChoice == false) { //This method of input validation was based on example from https://www.youtube.com/watch?v=Vs2ZR7-LJO0
                strInput = keyboard.nextLine();
                try {
                    choice = Integer.parseInt(strInput);
                    validChoice = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter an integer value");
                }
            }
            if (choice > 2 || choice < 0) {
                System.out.println("Please choose an option between 0 and 2"); //Graceful handling of invalid menu input
            } else if (choice == 1) {
                System.out.println("********Register selected*********");

                //To register, students must enter a date of birth and a password. CaoNumber should be auto-increment


                choice = 0; //Reset choice so menu will loop until user quits
            } else if (choice == 2) {
                System.out.println("********Login selected*********");

                //To login a student must enter their ca0Number, date of birth and password

                choice = 0; //Reset choice so menu will loop until user quits
            }
        }
    }

    public static void courseMenu() {
        System.out.println("********************************");
        System.out.println("CAO Course Choice System");
        System.out.println("********************************");

        Scanner keyboard = new Scanner(System.in);

        int choice = -1;
        String strInput;

        while (choice < 0 || choice > 5) {
            System.out.println("Please choose an option:");
            System.out.println("0. Quit Application");
            System.out.println("1. Logout");
            System.out.println("2. Display a Course");
            System.out.println("3. Display All Courses");
            System.out.println("4. Display Your Current Choices");
            System.out.println("5. Update Your Choices");

            boolean validChoice = false;
            boolean loggedIn;

            while (validChoice == false) { //This method of input validation was based on example from https://www.youtube.com/watch?v=Vs2ZR7-LJO0
                strInput = keyboard.nextLine();
                try {
                    choice = Integer.parseInt(strInput);
                    validChoice = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter an integer value");
                }
            }
            if (choice > 5 || choice < 0) {
                System.out.println("Please choose an option between 0 and 5"); //Graceful handling of invalid menu input
            } else if (choice == 1) {
                System.out.println("********Logout selected*********");

                //Logs a student out, returning them to the login menu

                choice = 0; //Reset choice so menu will loop until user quits
            } else if (choice == 2) {
                System.out.println("********Display a Course selected*********");

                //Displays a course given its course id

                choice = 0; //Reset choice so menu will loop until user quits
            } else if (choice == 3) {
                System.out.println("********Display All Courses selected*********");

                //Displays all courses

                choice = 0; //Reset choice so menu will loop until user quits
            } else if (choice == 4) {
                System.out.println("********Display Current Choices selected*********");

                //Displays the choices associated with the current student's caoNumber

                choice = 0; //Reset choice so menu will loop until user quits
            } else if (choice == 5) {
                System.out.println("********Update Choices selected*********");

                //Allows a user to input a list of course IDs in order of preference to update their choices

                choice = 0; //Reset choice so menu will loop until user quits
            }
        }
    }
}

