package sv.com.devskodigo;

/*
name: DataOperations.java -> Interface
purpose: pattern for managing of persistence operations
author: hftamayo
comments:
1. testing

 */

public interface DataOperations {
    void readDataset();
    void selectOption(); //the users needs to specify what operation will execute
    void getData(); //get user's input
    void addData(); //save data into the file
    void updateData(); //update changes into the file
    void searchData(int opt); //search for an specific record
    void deleteData(); //delete a record
    void updateStatus(); //some clases operate a status field: 0:inactive, 1: active
}
