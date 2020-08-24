package com.notebook;

import com.notebook.entity.Criterion;
import com.notebook.entity.Employee;
import com.notebook.service.RecordManagement;
import com.notebook.ui.OutputConsole;
import com.notebook.ui.ReadKeyboardConsole;
import com.notebook.ui.RecordsFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author NikBor on 30.05.2016.
 */

/**
 * Class notebook sells the console user interface.
 * Generates multipage menu for the realization of the basic functions: Copy records
 * into memory, add, delete, sort, search records and store them on the hard copy.
 */
public class Notebook {

    public static void main(String[] args) throws IOException {

        RecordManagement recordManagement = new RecordManagement();
        recordManagement.loadRecords(); // Load records
        do {
            OutputConsole.printMenuMain();
            int temp = ReadKeyboardConsole.readPointMenu(4);/** Reading the menu item number 1-4.*/
            switch (temp) {
                case 1:/**Start the implementation of a functional item 1 of the main menu*/
                {
                    OutputConsole.printMenu11();
                    int temp1 = ReadKeyboardConsole.readPointMenu(2);
                    switch (temp1) {
                        case 1: {/**Start the implementation of a functional item 1.1 of the main menu.*/
                            Employee c = RecordsFactory.readPersonData();   /**Create a new entry.*/
                            if (c != null) recordManagement.addRecord(c); /**Added to the collection.*/
                        }/**End the implementation of a functional item 1.1 of the main menu.*/
                        case 2:
                            continue; /**Return to the main menu.*/
                    }
                }/**End the implementation of a functional item 1 of the main menu.*/

                case 2:/**Start the implementation of a functional item 2 of the main menu*/
                {
                    OutputConsole.printMenu21();
                    int temp2 = ReadKeyboardConsole.readPointMenu(4); /** Reading the menu item number 1-4.*/
                    switch (temp2) {
                        case 1: /**Start the implementation of a functional item 2.1 of the  menu.*/
                        {
                            List<Employee> employees = recordManagement.getRecords();
                            OutputConsole.printFormat1();
                            OutputConsole.printRecordsConsole(employees);
                            break;
                        }/**End the implementation of a functional item 2.1 of the  menu.*/
                        case 2: /**Start the implementation of a functional item 2.2 of the  menu.*/
                        {
                            OutputConsole.printFormat2();
                            List<Employee> templist = recordManagement.findEmployeeRecords();
                            OutputConsole.printRecordsConsole(templist);
                            break;
                        }/**End the implementation of a functional item 2.2 of the  menu.*/

                        case 3: /**Start the implementation of a functional item 2.3 of the  menu.*/
                        {
                            OutputConsole.printFormat3();

                            OutputConsole.printRecordsConsole(recordManagement.findManagerRecords());
                            break;
                        }  /**End the implementation of a functional item 2.3 of the  menu.*/
                        case 4:
                            continue; /**Return to the main menu.*/
                    }

                    continue;
                }/**End the implementation of a functional item 2 of the main menu*/
                case 3: /**Start the implementation of a functional item 3 of the main menu.*/
                {
                    OutputConsole.printMenu31();
                    int temp3 = ReadKeyboardConsole.readPointMenu(8);// Read the menu item number 1-8
                    List<Employee> records = recordManagement.getRecords();//это удалить после переноса sort d
                    switch (temp3) {
                        case 1: /**Start the implementation of a functional item 3.1 of the  menu.*/
                        {
                            String value = ReadKeyboardConsole.readCriterion(1);
                            {
                                OutputConsole.printRecordsConsole(recordManagement.findRecordCriterion(Criterion.FIRST_NAME, value));
                            }
                            break;
                        }/**End the implementation of a functional item 3.1 of the  menu.*/
                        case 2: /**Start the implementation of a functional item 3.2 of the  menu.*/
                        {
                            String value = ReadKeyboardConsole.readCriterion(2);
                            OutputConsole.printRecordsConsole(recordManagement.findRecordCriterion(Criterion.LAST_NAME, value));
                            break;
                        }/**End the implementation of a functional item 3.2 of the  menu.*/

                        case 3: /**Start the implementation of a functional item 3.3 of the  menu.*/
                        {
                            String value = ReadKeyboardConsole.readCriterion(3);
                            OutputConsole.printRecordsConsole(recordManagement.findRecordCriterion(Criterion.BIRTHDAY, value));

                            break;
                        }  /**End the implementation of a functional item 3.3 of the  menu.*/
                        case 4: /**Start the implementation of a functional item 3.4 of the  menu.*/
                        {
                            long id = ReadKeyboardConsole.readIDForDelete();
                            System.out.println(recordManagement.getContact(id));
                            OutputConsole.printFormat7();
                            if (ReadKeyboardConsole.readPointMenu(2)==2){
                            recordManagement.deleteRecord(id);}
                            OutputConsole.printRecordsConsole(records);
                            break;
                        }  /**End the implementation of a functional item 3.4 of the  menu.*/

                        case 5:///**Start the implementation of a functional item 3.5 of the  menu.*/
                        {
                            //Collections.sort(records, Employee.FamilyComparator);
                            recordManagement.sortingRecordCriterion(Criterion.FIRST_NAME);
                            OutputConsole.printFormat4();
                            OutputConsole.printRecordsConsole(recordManagement.getRecords());
                            break;
                        }/**End the implementation of a functional item 3.5 of the  menu.*/
                        case 6: /**Start the implementation of a functional item 3.6 of the  menu.*/
                        {
                           // Collections.sort(records, Employee.NameComparator);
                            OutputConsole.printFormat5();
                            recordManagement.sortingRecordCriterion(Criterion.LAST_NAME);
                            OutputConsole.printRecordsConsole(recordManagement.getRecords());
                            break;
                        }/**End the implementation of a functional item 3.6 of the  menu.*/
                        case 7:/**Start the implementation of a functional item 3.7 of the  menu.*/
                        {
                            OutputConsole.printFormat6();
                           //Collections.sort(records, Employee.YearBirthComparator);
                            recordManagement.sortingRecordCriterion(Criterion.BIRTHDAY);
                            OutputConsole.printRecordsConsole(recordManagement.getRecords());
                            break;
                        }/**End the implementation of a functional item 3.7 of the  menu.*/
                        case 8:
                            continue; /**Return to the main menu.*/
                    }

                }
                continue;

                case 4: /**Start the implementation of a functional item 4 of the main menu.*/
                {
                    OutputConsole.printMenu41();
                    List<Employee> employees = recordManagement.getRecords();
                    int temp4 = ReadKeyboardConsole.readPointMenu(2);// Read the menu item number 1-2
                    if (temp4 == 1) {
                        recordManagement.saveRecords(employees);
                    }
                    System.out.println(" ===== Блокнот закрыт ====  (Notebook To close) =====  ");
                    System.exit(0);
                }
            }
        } while (true);
    }


}
