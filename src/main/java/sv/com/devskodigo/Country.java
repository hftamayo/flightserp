package sv.com.devskodigo;

/*
name: Country.java
purpose: manage country catalog
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
import java.util.*;
import java.io.IOException;

public class Country implements DataOperations {

    private int menuOption;
    private Scanner rawData;

    @Getter @Setter
    private int countryId;
    @Getter @Setter
    private String countryName;
    @Getter @Setter
    private float countryCoords;

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public Country(){
        readDataset();
        selectOption();
    }

    @Override
    public void readDataset(){
        menuOption = 0;
        rawData = new Scanner(System.in);
        try{
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Country");
            System.out.println("Country dataset loaded");
        }catch(Exception ioe){
            System.out.println("Error during reading dataset routine");
            ioe.printStackTrace();
        }
    }//end of readDataSet()

    @Override
    public void selectOption(){
        System.out.println("Country dataset: please type a number equivalent to any of the options above: ");
        System.out.println("1. Add a Record");
        System.out.println("2. Update a Record");
        System.out.println("3. Delete a Record");
        System.out.println("4. Search for a Record");
        try{
            menuOption = rawData.nextInt();
            switch(menuOption){
                case 1:
                    this.getData();
                    break;
                case 2:
                    this.searchData(2);
                    break;
                case 3:
                    this.searchData(3);
                    break;
                case 4:
                    this.searchData(4);
                    break;
            }

        }catch(InputMismatchException ime){
            System.out.println("Please only type integer numbers");
            ime.printStackTrace();
        }
    }//end of selectOption method

    @Override
    public void getData(){
        System.out.println("Pleae type id number");
        this.setCountryId(rawData.nextInt());
        System.out.println("Pleae type name");
        this.setCountryName((rawData.next()));
        System.out.println("Please type GPS coords");
        this.setCountryCoords(rawData.nextFloat());
        this.addData();

    }

    @Override
    public void addData(){
        try{
            //just for testing purpose: System.out.println(this.getCountryId()+"-"+this.getCountryName()+"-"+this.getCountryCoords());
            Map<String, Object[]> data = new TreeMap<String, Object[]>();
            data.put("1", new Object[] {"ID", "COUNTRY_NAME", "GPS_COORDS"});
            data.put("2", new Object[] {this.getCountryId(), this.getCountryName(), this.getCountryCoords()});

            //Iterate over data and write to sheet
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
                    if(obj instanceof String)
                        cell.setCellValue((String)obj);
                    else if(obj instanceof Integer)
                        cell.setCellValue((Integer)obj);
                }
            }
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("flights.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Your data is saved");
        }catch(Exception e){
            System.out.println("An error has ocurred");
            e.printStackTrace();
        }

    }

    @Override
    public void searchData(int usrOpt){
        int countryIdTarget = 0;
        boolean dataFound = false;

        try{
            System.out.println("please type Country ID you're looking for:");
            countryIdTarget = rawData.nextInt();
            //searchData routine
            if(dataFound){
                switch(usrOpt){
                    case 2: //updateData
                        this.updateData();
                        break;
                    case 3: //deleteData
                        this.deleteData();
                        break;
                }//end of switch(usrOpt)
            }//end of dataFound
        }catch(Exception e){
            System.out.println("An error ocurred");
        }

    }//end of searchData


    @Override
    public void updateData(){

    }


    @Override
    public void deleteData(){

    }

    @Override
    public void updateStatus(){

    }
}
