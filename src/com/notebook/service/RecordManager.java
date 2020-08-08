package com.notebook.service;

import com.notebook.dao.RecordDAO;
import com.notebook.entity.Criteria;
import com.notebook.entity.Employee;

import java.util.List;

/**
 * @author NikBor on 12.05.2016.
 *         Notepad records management.
 *         Methods to perform the user commands.
 */
public class RecordManager {

    private RecordDAO dao;

    public RecordManager() {
        this.dao = RecordDAOFactory.getContactDAO();
    }

    /**
     * Adding an entry in the notebook.
     */
    public void addRecord(Employee employee) {
        dao.addRecord(employee);
    }

    /**
     * Remove records for her ID.
     */
    public void deleteContact(Long contactId) {
        dao.deleteContact(contactId);
    }

    /**
     * Get a single contact.
     */
    public Employee getContact(Long contactId) {
        return dao.getContact(contactId);
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
    public List<Employee> findRecords() {
        return dao.findRecords();
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
    public List<Employee> findRecordCriterion(Criteria criteria, String value) {
        return dao.findRecordCriterion(criteria, value);
    }

}













