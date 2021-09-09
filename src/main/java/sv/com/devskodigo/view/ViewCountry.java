package sv.com.devskodigo.view;

import sv.com.devskodigo.model.dao.CountryDao;
import sv.com.devskodigo.model.dto.CountryDto;

import java.util.Scanner;

public class ViewCountry {
    private String countryName = "";
    private float countryCoords = 0;
    private Scanner rawData;

    public ViewCountry(){

    }

    public void getData(){
        rawData = new Scanner(System.in);
        System.out.println("Please type the below requested information: ");
        System.out.println("Country's name");
        countryName = rawData.nextLine();
        System.out.println("Country's GPS Coords");
        countryCoords = rawData.nextFloat();
    }

    public void setData(){
        CountryDao countryDao =  new CountryDao();
        countryDao.insert(new CountryDto(0, this.countryName, this.countryCoords));
    }
}
