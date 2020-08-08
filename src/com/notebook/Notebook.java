package com.notebook;

import com.notebook.dao.RecordDAOImpl;
import com.notebook.entity.Criteria;
import com.notebook.entity.Employee;
import com.notebook.service.RecordManager;
import com.notebook.ui.PrintMenuConsole;
import com.notebook.ui.ReadKeyboardConsole;
import com.notebook.ui.RecordsFactory;

import java.io.IOException;
import java.util.Collections;
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

    public static void main(String args[]) throws IOException {
        RecordDAOImpl.сreateFile();
        RecordManager cm = new RecordManager();
        cm.loadRecords();
        do {
            PrintMenuConsole.printMenuMain();
            int temp = ReadKeyboardConsole.readPointMenu(4);/** Reading the menu item number 1-4.*/
            switch (temp) {
                case 1:/**Start the implementation of a functional item 1 of the main menu*/
                {
                    PrintMenuConsole.printMenu11();
                    int temp1 = ReadKeyboardConsole.readPointMenu(2);
                    switch (temp1) {
                        case 1: {/**Start the implementation of a functional item 1.1 of the main menu.*/
                            Employee c = RecordsFactory.readPersonData();   /**Create a new entry.*/
                            if (c != null) cm.addRecord(c); /**Added to the collection.*/
                        }/**End the implementation of a functional item 1.1 of the main menu.*/
                        case 2:
                            continue; /**Return to the main menu.*/
                    }
                }/**End the implementation of a functional item 1 of the main menu.*/

                case 2:/**Start the implementation of a functional item 2 of the main menu*/
                {
                    PrintMenuConsole.printMenu21();
                    int temp2 = ReadKeyboardConsole.readPointMenu(4); /** Reading the menu item number 1-4.*/
                    switch (temp2) {
                        case 1: /**Start the implementation of a functional item 2.1 of the  menu.*/
                        {
                            List<Employee> employees = cm.findRecords();
                            PrintMenuConsole.printFormat1();
                            PrintMenuConsole.printRecordsConsole(employees);
                            break;
                        }/**End the implementation of a functional item 2.1 of the  menu.*/
                        case 2: /**Start the implementation of a functional item 2.2 of the  menu.*/
                        {
                            PrintMenuConsole.printFormat2();
                            List<Employee> templist = cm.findEmployeeRecords();
                            PrintMenuConsole.printRecordsConsole(templist);
                            break;
                        }/**End the implementation of a functional item 2.2 of the  menu.*/

                        case 3: /**Start the implementation of a functional item 2.3 of the  menu.*/
                        {
                            PrintMenuConsole.printFormat3();
                            List<Employee> templist = cm.findManagerRecords();
                            PrintMenuConsole.printRecordsConsole(templist);
                            break;
                        }  /**End the implementation of a functional item 2.3 of the  menu.*/
                        case 4:
                            continue; /**Return to the main menu.*/
                    }

                    continue;
                }/**End the implementation of a functional item 2 of the main menu*/
                case 3: /**Start the implementation of a functional item 3 of the main menu.*/
                {
                    PrintMenuConsole.printMenu31();
                    int temp3 = ReadKeyboardConsole.readPointMenu(8);// Read the menu item number 1-8
                    List<Employee> records = cm.findRecords();
                    switch (temp3) {
                        case 1: /**Start the implementation of a functional item 3.1 of the  menu.*/
                        {
                            String value = ReadKeyboardConsole.readCriterion(1);
                            {
                                List<Employee> templist = cm.findRecordCriterion(Criteria.FIRST_NAME, value);
                                PrintMenuConsole.printRecordsConsole(templist);
                            }
                            break;
                        }/**End the implementation of a functional item 3.1 of the  menu.*/
                        case 2: /**Start the implementation of a functional item 3.2 of the  menu.*/
                        {
                            String value = ReadKeyboardConsole.readCriterion(2);
                            List<Employee> templist = cm.findRecordCriterion(Criteria.LAST_NAME, value);
                            PrintMenuConsole.printRecordsConsole(templist);
                            break;
                        }/**End the implementation of a functional item 3.2 of the  menu.*/

                        case 3: /**Start the implementation of a functional item 3.3 of the  menu.*/
                        {
                            String value = ReadKeyboardConsole.readCriterion(3);
                            List<Employee> templist = cm.findRecordCriterion(Criteria.BIRTHDAY, value);
                            PrintMenuConsole.printRecordsConsole(templist);

                            break;
                        }  /**End the implementation of a functional item 3.3 of the  menu.*/
                        case 4: /**Start the implementation of a functional item 3.4 of the  menu.*/
                        {
                            long id = ReadKeyboardConsole.readIDForDelete();
                            cm.deleteContact(id);
                            PrintMenuConsole.printRecordsConsole(records);
                            break;
                        }  /**End the implementation of a functional item 3.4 of the  menu.*/

                        case 5:///**Start the implementation of a functional item 3.5 of the  menu.*/
                        {
                            Collections.sort(records, Employee.FamilyComparator);
                            PrintMenuConsole.printFormat4();
                            PrintMenuConsole.printRecordsConsole(records);
                            break;
                        }/**End the implementation of a functional item 3.5 of the  menu.*/
                        case 6: /**Start the implementation of a functional item 3.6 of the  menu.*/
                        {
                            Collections.sort(records, Employee.NameComparator);
                            PrintMenuConsole.printFormat5();
                            PrintMenuConsole.printRecordsConsole(records);
                            break;
                        }/**End the implementation of a functional item 3.6 of the  menu.*/
                        case 7:/**Start the implementation of a functional item 3.7 of the  menu.*/
                        {
                            PrintMenuConsole.printFormat6();
                            Collections.sort(records, Employee.YearBirthComparator);
                            PrintMenuConsole.printRecordsConsole(records);
                            break;
                        }/**End the implementation of a functional item 3.7 of the  menu.*/
                        case 8:
                            continue; /**Return to the main menu.*/
                    }

                }
                continue;

                case 4: /**Start the implementation of a functional item 4 of the main menu.*/
                {
                    PrintMenuConsole.printMenu41();
                    List<Employee> employees = cm.findRecords();
                    int temp4 = ReadKeyboardConsole.readPointMenu(2);// Read the menu item number 1-2
                    if (temp4 == 1) {
                        cm.saveRecords(employees);
                    }
                    System.out.println(" ===== Блокнот закрыт ====  (Notebook To close) =====  ");
                    System.exit(0);
                }
            }
        } while (true);
    }


}
