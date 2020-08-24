package com.notebook.dao;

import com.notebook.entity.Criterion;
import com.notebook.entity.Employee;

import java.util.List;

/**
 * Created by NikBor on 14.05.2016.__Data Access Object
 * Interface with methods for working with the data store.
 * The implementation of DAO design pattern.
 */

public interface RecordDAO {
    /**
     * Adding an entry in the notebook.
     */
    void addRecord(Employee employee);

    /**
     * Remove records for her ID.
     */

    void deleteRecord(Long contactId);

    /**
     * Get a single contact.
     */
    Employee getRecord(Long recordId);

    /**
     * Get the list of employees.
     */
    List<Employee> getRecords();

    /**
     * Get the list of employees.
     */
    List<Employee> findEmployeeRecords();

    /**
     * Get the list of managers.
     */
    List<Employee> findManagerRecords();

    /**
     * Load records from the disk to the collection before using the Nootebook.
     */
    void loadRecords();

    /**
     * Save the entries in the file on the HDD.
     */
    void saveRecords(List<Employee> employees);

    /**
     * Search entries by criterion.
     */
    List<Employee> findRecordCriterion(Criterion criterion, String value);
    /**
     * Sorting entries by criterion.
     */
    void sortingRecordCriterion(Criterion criterion);
}

