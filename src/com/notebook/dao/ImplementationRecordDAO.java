package com.notebook.dao;

import com.notebook.entity.Criterion;
import com.notebook.entity.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NikBor on 14.05.2016.
 * The class implements the DAO interface.
 * Overrides methods for working with the data store.
 * Operational data store - collection List.
 * Continuous data storage - disk file.
 */
public class ImplementationRecordDAO implements RecordDAO {

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
            System.out.println(ex.getMessage() + "  create file");
            ImplementationRecordDAO.createFile(); // добавлен вызов метода при исключнии
            this.employees = new ArrayList<>();// this can be deleted
        }
    }

    @Override  /* Save the entries in the file on the HDD. */
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

    @Override /*Adding an entry in the notebook.*/
    public void addRecord(Employee employee) {
        long id = getID();
        employee.setId(id);
        employees.add(employee);
    }

    @Override /*Remove records for her ID.*/
    public void deleteRecord(Long recordId) {
        employees.removeIf(cnt -> cnt.getId().equals(recordId));
    }

    @Override /* return the List<Employee> records for her ID */
    public Employee getRecord(Long recordId) {
        return employees.stream().filter(record -> record.getId().equals(recordId)).findFirst().orElse(null);
    }
    /* return the List<Employee> of all records */
    @Override
    public List<Employee> getRecords() {
        return employees;
    }
    /* return the List<Employee> of records only employees.*/
    @Override
    public List<Employee> findEmployeeRecords() {
        return employees.stream().filter(Employee::isEmployee).collect(Collectors.toList());
    }

    /* return the List<Employee> of records only managers.*/
    @Override
    public List<Employee> findManagerRecords() {
        return employees.stream().filter(obj -> !obj.isEmployee()).collect(Collectors.toList());
    }

    /* return the List<Employee> search results according to
     the criterion(FIRST_NAME;LAST_NAME;BIRTHDAY).*/
    @Override
    public List<Employee> findRecordCriterion(Criterion criterion, String value) {

        if (Criterion.FIRST_NAME == criterion) {
            return employees.stream().filter(emp -> emp.getFirstName().equalsIgnoreCase(value))
                    .collect(Collectors.toList());
        }
        if (Criterion.LAST_NAME == criterion) {
            return employees.stream().filter(emp -> emp.getLastName().equalsIgnoreCase(value))
                    .collect(Collectors.toList());
        }
        if (Criterion.BIRTHDAY == criterion) {
            int ti = Integer.parseInt(value);
            return employees.stream().filter(emp -> emp.getYearBirth() == ti).collect(Collectors.toList());
        }
        return null;
    }

    /* return the List<Employee> sorting results according to
        the criterion(FIRST_NAME;LAST_NAME;BIRTHDAY).*/
    @Override
    public void sortingRecordCriterion(Criterion criterion) {
        if (Criterion.FIRST_NAME == criterion) {
            Collections.sort(employees, Employee.FamilyComparator);
        }
        if (Criterion.LAST_NAME == criterion) {
            Collections.sort(employees, Employee.NameComparator);
        }
        if (Criterion.BIRTHDAY == criterion) {
            Collections.sort(employees, Employee.YearBirthComparator);
        }
    }

    /* return the Long id personal user's code.*/
    //Method to obtain an individual employee number.
    private Long getID() {
        if (employees.isEmpty()) {
            return 1L;
        }
        int met = employees.size() - 1;
        long id = employees.get(met).getId();
        return ++id;
    }

    /* We create the file for data storage on a disk at the first start of program.
     * The file is create in the root catalog of the project.
     */
    public static void createFile() {
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
