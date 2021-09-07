package sv.com.devskodigo;
/*
name: FlightsErp
purpose:
project's main class, it's the pipeline for submenu and execute a requested class
create an XLSX during first run
author: hftamayo
TODO:
1. clean the screen fuction -> OS independent
2. loop back to main menu
3. if the xlsx exist then open it instead of create it again
 */


import sv.com.devskodigo.view.menu.*;


import java.util.InputMismatchException;

import java.io.FileWriter;
import java.io.IOException;

public class FlightsErp {

    public static void main(String[] args){
        /*
        int decisionMenu = 0;
        int decisionSubMenu = 0;
        int decisionAction = 0;

        System.out.println("Welcome to Flights ERP - Comalapa Airport");
        ViewMenu viewMenu = new ViewMenu();
        viewMenu.showMainMenu();
        decisionMenu = viewMenu.selectOption(1);
        switch(decisionMenu){
            case 1: //catalogs
                viewMenu.showSubMenu(1);
                decisionAction = viewmenu

         */

        }

        /*
        do{
            System.out.println("Main Menu: please type the number related to one of the above options: ");
            System.out.println("1. Catalogs");
            System.out.println("2. Flight Operations");
            System.out.println("3. Reports");
            System.out.println("4. Exit");

            try{
                menuOption = rawData.nextInt();
                switch(menuOption){
                    case 1:
                    case 2:
                    case 3:
                        showSubMenu(menuOption);
                        break;
                    default:
                        System.out.println("thank you for use our product. Good bye");
                        mainMenu = 0;
                        break;
                }//end of switch
            }catch(InputMismatchException ime){
                System.out.println("Please type only integer numbers");
                ime.printStackTrace();
            }
        }while(mainMenu == 1);
         */

    }//end of main
}

