package com.notebook.dao;

import com.notebook.entity.Criteria;
import com.notebook.entity.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author NikBor on 14.05.2016.
 *         The class implements the DAO interface.
 *         Overrides methods for working with the data store.
 *         Operational data store - collection List.
 *         Continuous data storage - disk file.
 */
public class RecordDAOImpl implements RecordDAO {

    public static final String DEFAULT_FILE_NAME = "notebookBD.dat";

    private List<Employee> employees = new ArrayList<>();

    /* Load records from the disk to the collection before using the Nootebook.*/

    /**
     * @return the List<Employee> from the disk
     * * return the List<Employee> from the disk
     */
    @SuppressWarnings("unchecked")
    @Override
    public void loadRecords() {
        File file = new File(DEFAULT_FILE_NAME);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            this.employees = (List<Employee>) ois.readObject();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            this.employees = new ArrayList<>();
        }

    }

    /**
     * Save the entries in the file on the HDD.
     */
    @Override
    public void saveRecords(List<Employee> employees) {
        Collections.sort(employees);
        File file = new File(DEFAULT_FILE_NAME);
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(file))) {
            ois.writeObject(employees);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    /**
     * Adding an entry in the notebook.
     */
    @Override
    public void addRecord(Employee employee) {
        long id = getID();
        employee.setId(id);
        employees.add(employee);
    }

    /**
     * Remove records for her ID.
     */
    @Override
    public void deleteContact(Long contactId) {
        for (Iterator<Employee> it = employees.iterator(); it.hasNext(); ) {
            Employee cnt = it.next();
            if (cnt.getId().equals(contactId)) {
                it.remove();
            }
        }
    }

    /**
     * @return the List<Employee>  records for her ID
     * return the List<Employee> records for her ID
     */
    @Override
    public Employee getContact(Long contactId) {
        for (Employee record : employees) {
            if (record.getId().equals(contactId)) {
                return record;
            }
        }
        return null;
    }

    /**
     * @return the List<Employee>  of all records
     * return the List<Employee> of all records
     */
    @Override
    public List<Employee> findRecords() {
        return employees;
    }

    /**
     * @return the List<Employee>  of records only employees.
     * return the List<Employee> of records only employees.
     */
    @Override
    public List<Employee> findEmployeeRecords() {
        List<Employee> tempList = new ArrayList<>();
        for (Employee employee : employees) {
            if (!employee.isManager()) {
                tempList.add(employee);
            }
        }
        return tempList;
    }

    /**
     * @return the List<Employee>  of records only managers.
     * return the List<Employee> of records only manager.
     */
    @Override
    public List<Employee> findManagerRecords() {
        List<Employee> tempList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.isManager()) {
                tempList.add(employee);
            }
        }
        return tempList;
    }

    /**
     * @return the List<Employee>  search results according to the criterion(FIRST_NAME;LAST_NAME;BIRTHDAY).
     * return the List<Employee> search results according to the criterion(FIRST_NAME;LAST_NAME;BIRTHDAY).
     */
    @Override
    public List<Employee> findRecordCriterion(Criteria criteria, String value) {
        List<Employee> tempList = new ArrayList<>();
        if (Criteria.FIRST_NAME == criteria) {
            for (Employee rec : employees) {
                if (rec.getFirstName().equalsIgnoreCase(value)) {
                    tempList.add(rec);
                }
            }
            return tempList;
        }
        if (Criteria.LAST_NAME == criteria) {
            for (Employee rec : employees) {
                if (rec.getLastName().equalsIgnoreCase(value)) {
                    tempList.add(rec);
                }
            }
            return tempList;
        }
        if (Criteria.BIRTHDAY == criteria) {
            int ti = Integer.parseInt(value);
            for (Employee rec : employees) {
                if (rec.getYearBirth() == ti) {
                    tempList.add(rec);
                }
            }
            return tempList;
        }

        return null;
    }

    /**
     * @return the Long id personal user's code.
     * return the Long id personal user's code.
     */
    //Method to obtain an individual employee number.
    private Long getID() {
        if (employees.isEmpty()) {
            return 1L;
        }
        int met = employees.size() - 1;
        long id = employees.get(met).getId();
        return ++id;
    }

    /**
     * We create the file for data storage on a disk at the first start of program.
     * The file is create in the root catalog of the project.
     */
    public static void сreateFile() {
        File file = new File(DEFAULT_FILE_NAME);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            throw new RuntimeException("Something wrong. Please try to restart application.", ex);
        }
    }
}
