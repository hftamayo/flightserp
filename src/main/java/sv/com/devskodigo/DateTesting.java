package sv.com.devskodigo;

import java.util.*;
import java.text.*;

public class DateTesting {
    private Date dtToDept;
    private Date dtToArrive;
    private String dtInput;
    private Scanner rawData;


    public void getData(){
        try{
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            rawData = new Scanner(System.in);

            System.out.println("Please type Date Time to Departure (yyyy-mm-dd hh:mm)");
            dtInput = rawData.nextLine();
            dtToDept = ft.parse(dtInput);

            System.out.println("Please type Date Time to Arrive (yyyy-mm-dd hh:mm)");
            dtInput = rawData.nextLine();
            dtToArrive = ft.parse(dtInput);

            System.out.println("dateTime Departure: "+dtToDept);
            System.out.println("dateTime Arrive: "+dtToArrive);


        }catch(ParseException pe){
            System.out.println("An error ocurred during dateTime data Input");
            pe.printStackTrace();
        }
    }

}
