package com.notebook.service;

import com.notebook.dao.RecordDAO;
import com.notebook.entity.Criterion;
import com.notebook.entity.Employee;

import java.util.List;

/**
 * @author NikBor on 12.05.2016.
 *         Notepad records management.
 *         Methods to perform the user commands.
 */
public class RecordManagement {

    private final RecordDAO dao;

    public RecordManagement() {
        this.dao = RecordDAOFactory.getContactDAO();
    }

    /**
     * Adding an entry in the notebook.
     */
    public void addRecord(Employee employee) {
        dao.addRecord(employee);
    }

    /**
     * Remove record for her ID.
     */
    public void deleteRecord(Long recordId) {
        dao.deleteRecord(recordId);
    }

    /**
     * Get a single record.
     */
    public Employee getContact(Long recordId) {
        return dao.getRecord(recordId);
    }

    /**
     * Get the list of employees.
     */
    public List<Employee> findEmployeeRecords() {
        return dao.findEmployeeRecords();
    }

    /**
     * Get the list of managers.
     */
    public List<Employee> findManagerRecords() {
        return dao.findManagerRecords();
    }

    /**
     * Getting all entries.
     */
    public List<Employee> getRecords() {
        return dao.getRecords();
    }

    /**
     * Load records from the disk to the collection before using the Nootebook.
     */
    public void loadRecords() {
        dao.loadRecords();
    }

    /**
     * Save the entries in the file on the HDD.
     */
    public void saveRecords(List<Employee> employees) {
        dao.saveRecords(employees);
    }

    /**
     * Search entries by criterion.
     */
    public List<Employee> findRecordCriterion(Criterion criterion, String value) {
        return dao.findRecordCriterion(criterion, value);
    }
    /**
     * Sorting entries by criterion.
     */
    public void sortingRecordCriterion(Criterion criterion) {
        dao.sortingRecordCriterion (criterion);
    }

}













