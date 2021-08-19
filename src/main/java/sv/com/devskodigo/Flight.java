package sv.com.devskodigo;

/*
name: City.java
purpose: manage city catalog
author: hftamayo
comments:
1. send a confirmation if dataSet was successfull

 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flight implements DataOperations {

    private int menuOption;
    private Scanner rawData;

    @Getter @Setter
    private int flightId;
    @Getter @Setter
    private int flightDescriptor;
    @Getter @Setter
    private LocalDateTime flightDateTimeRep;
    @Getter @Setter
    private LocalDateTime flightDateTimeArr;
    @Getter @Setter
    private int flightStatus;
    @Getter @Setter
    private char flightWeatherRpt;
    @Getter @Setter
    private int aircfratId;
    @Getter @Setter
    private int airlineId;
    @Getter @Setter
    private int flightCountryIdDep;
    @Getter @Setter
    private int flightCityIdDep;
    @Getter @Setter
    private int flightCountryIdArr;
    @Getter @Setter
    private int flightCityIdArr;
    @Getter @Setter
    private int userId;

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Map<String, Object[]> data;
    int recordCounter = 1; //1 is Spreadsheet's Header
    List cellDataList;
    Iterator rowIterator;

    //constructor method
    public Flight(){

    }

    //open dataset

    @Override
    public void readDataset(){
        menuOption = 0;
        rawData = new Scanner(System.in);
        try{
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Flight");
            data = new TreeMap<String, Object[]>();
            data.put("1", new Object[] {"ID", "DESCRIPTOR", "DT DEPARTURE", "DT ARRIVE", "STATUS",
                    "WEATHER RPT", "AIRCRAFT", "AIRLINE", "COUNTRY DEP", "CITY DEP", "COUNTRY ARR",
                    "CITY ARR", "USER"});
            System.out.println("City dataset loaded");
        }catch(Exception ioe){
            System.out.println("Error during reading dataset routine");
            ioe.printStackTrace();
        }
    }//end of readDataSet()

    @Override
    public void selectOption(){
        System.out.println("City dataset: please type a number equivalent to any of the options above: ");
        int usrContinue = 1;
        do{
            System.out.println("1. Add a Record");
            System.out.println("2. Display data");
            System.out.println("3. Back to Previous Menu");

            try{
                menuOption = rawData.nextInt();
                switch(menuOption){
                    case 1:
                        this.getData();
                        break;
                    case 2:
                        this.searchData(); //updateData
                        break;
                    case 3:
                        usrContinue = 0;
                        break;
                }

            }catch(InputMismatchException ime){
                System.out.println("Please only type integer numbers");
                ime.printStackTrace();
            }
        }while(usrContinue == 1);

    }//end of selectOption method

    @Override
    public void getData(){
        System.out.println("Pleae type id number");
        this.setCityId(rawData.nextInt());
        //numeric input data does not send enter at the end
        rawData.nextLine();
        System.out.println("Pleae type name");
        this.setCityName((rawData.nextLine()));
        System.out.println("Please type GPS coords");
        this.setCityCoords(rawData.nextFloat());
        rawData.nextLine();
        System.out.println("Please type an existing country id");
        this.setCityId(rawData.nextInt());
        this.addData();
    }

    @Override
    public void addData(){
        String localRecordCounter;
        try{
            //just for testing purpose: System.out.println(this.getCountryId()+"-"+this.getCountryName()+"-"+this.getCountryCoords());
            localRecordCounter = String.valueOf(recordCounter++);
            data.put(localRecordCounter, new Object[] {this.getCityId(), this.getCityName(), this.getCityCoords(), this.getCityId()});

            //it is necesary to iterate the data to savbe it into a row
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset)
            {
                Row row = sheet.createRow(rownum++);
                Object [] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr)
                {
                    Cell cell = row.createCell(cellnum++);
                    if(obj instanceof String) //name
                        cell.setCellValue((String)obj);
                    else if(obj instanceof Integer) //countryid and cityid
                        cell.setCellValue((Integer)obj);
                    else if(obj instanceof Float) //float
                        cell.setCellValue((Float)obj);
                }
            }
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("city.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Your data is saved");
        }catch(Exception e){
            System.out.println("An error has ocurred");
            e.printStackTrace();
        }

    }

    @Override
    public void searchData(){
        int entityTarget;
        int updateRowOperation = 0;
        boolean dataFound = false;

        try{
            System.out.println("Displaying current list of countries");
            //searchData routine
            cellDataList = new ArrayList();
            rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = (Row) rowIterator.next();
                Iterator iterator = row.cellIterator();
                List cellTempList = new ArrayList();
                while (iterator.hasNext()) {
                    Cell cell = (Cell) iterator.next();
                    cellTempList.add(cell);
                }
                cellDataList.add(cellTempList);
            }
            if(cellDataList.size() > 0){
                dataFound = true;
                //print the content of the cellDataList
                for (int i = 0; i < cellDataList.size(); i++) {
                    List cellTempList = (List) cellDataList.get(i);
                    for (int j = 0; j < cellTempList.size(); j++) {
                        Cell cell = (Cell) cellTempList.get(j);
                        String stringCellValue = cell.toString();
                        System.out.print(stringCellValue + "\t");
                    }
                    System.out.println();
                }
            }

            //ask the user what other operation will need to execute
            if(dataFound){
                System.out.println("please type City ID you wish to update:");
                entityTarget = rawData.nextInt();
                System.out.println("Please type: 1->Edit Record, 2->Delete Record, 3->Back to Previous Menu");
                updateRowOperation = rawData.nextInt();

                switch(updateRowOperation){
                    case 1: //updateData
                        this.updateData(entityTarget);
                        break;
                    case 2: //deleteData
                        this.deleteData(entityTarget);
                        break;
                    case 3:
                        break;
                }//end of switch(usrOpt)
            }//end of dataFound
        }catch(Exception e){
            System.out.println("An error ocurred");
        }

    }//end of searchData


    @Override
    public void updateData(int recordId){
        System.out.println("Cheers from Update: coming next");
    }


    @Override
    public void deleteData(int recordId){
        System.out.println("Cheers from delete: coming next");
    }

    @Override
    public void updateStatus(int recordId){

    }
}
