package sv.com.devskodigo.view.menu;

import sv.com.devskodigo.view.menu.interfaces.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewMenu implements SelectOptionAction, ShowMainMenuAction, ShowOpsAction, ShowSubMenuAction{

    public final static String[] arrMenu = new String[] {"1. Catalogs", "2. Flights", "3. Exit"};
    //ReturnToPrevious will be always the last option
    public final static String[] arrMnuCatalogs = new String[] {"1. User", "2. Country", "3. City", "4. Airline", "5. Aircraft"};
    public final static String[] arrSubMnuActionsCatalogs = new String[] {"1. Add", "2. Seach", "3. Update", "4. Delete", "5. Upd Status"};

    public final static String[] arrMnuFlights = new String[] {"1. Flights", "2. Reports"};
    public final static String[] arrSubMnuActionsReports = new String[] {"1. Add", "2. Update", "3. Search", "4. Send"};

    private static Scanner rawData = new Scanner(System.in);

    public ViewMenu(){
    }

    @Override
    public void showMainMenu() {
        System.out.println("Main Menu");
        for(int i=0; i< arrMenu.length; i++){
            System.out.print(arrMenu[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void showSubMenu(int xlevel){
        switch (xlevel){
            case 1:
                System.out.println("Sub Menu: Catalog");
                break;

            case 2:
                System.out.println("Sub Menu: Flights");
                break;

            default:
                break;
        }
    }

    @Override
    public void showOperations() {

    }

    @Override
    public int selectOption(int xlevel) {
        int selectionMenu = 0;
        System.out.println("Please type the number corresponding to one of the options listed above:");
        try{
            selectionMenu = rawData.nextInt();
        }catch(InputMismatchException ime){
            System.out.println("Please type only integer numbers");
            //ime.printStackTrace();
        }
        return selectionMenu;
    }//fin del metodo selectOption

}//fin de la clase
