package spreadsheet123;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class Spreadsheet123 {


	public static void main(String[] args) {
   
	    // Add your command loop here
       Scanner input = new Scanner(System.in);
       
       Spreadsheet sheet = new Spreadsheet();
       System.out.print(sheet.getGridText());
       System.out.println();
  
       //construct new spreadsheet - creates 2D array
       String command;
       boolean running = true;
       while (running == true) {
         System.out.print("Command>> ");
         command = input.nextLine();
         if (command.toUpperCase().equals("QUIT")) { // <quit> //
            break;
         }
         else {
            System.out.println(sheet.processCommand(command));
         }
       }
                      
         
       System.out.println("You quit"); 
         
       
       
	}
}
