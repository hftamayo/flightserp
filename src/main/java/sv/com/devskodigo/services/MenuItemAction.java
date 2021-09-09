package sv.com.devskodigo.services;

import sv.com.devskodigo.view.menu.CrudMenu;

public class MenuItemAction {

    private int userOption = 0;
    private int maxValue = 0;

    public MenuItemAction(){

    }

    public void executeAction(int uo, int mv){
        userOption = uo;
        maxValue = mv;
        String crudAction = "";

        if(userOption < 1 || userOption > maxValue){
            System.out.println("Invalid option, please try again");
        }
        else{

            switch(userOption){
                case 1:
                    //USER CRUD
                    dtoName = "User";
                    break;
                case 2:
                    //COUNTRY CRUD
                    dtoName = "Country";
                    break;
                case 3:
                    //CITY CRUD
                    System.out.println("please instantiate CITY");
                    break;
                case 4:
                    //AIRLINE CRUD
                    System.out.println("please instantiate AIRLINE");
                    break;
                case 5:
                    //AIRCRAFT CRUD
                    System.out.println("please instantiate AIRCRAFT");
                    break;
                case 6:
                    //FLIGHTS CRUD
                    System.out.println("please instantiate FLIGHTS");
                    break;
                case 7:
                    //REPORTS CRUD
                    System.out.println("please instantiate REPORTS");
                    break;
                case 8:
                    //EXIT
                    System.out.println("Thank you for use our services!");
                    System.exit(0);
                    break;
            }
            CrudMenu crudMenu = new CrudMenu();
            crudMenu.showCrudOptions();


        }//end of else
    }//end of executeOption
}
