package com.notebook.entity;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author NikBor on 14.05.2016.
 *         The class provides a template to create the object: Employee.
 */
public class Employee implements Serializable, Comparable<Employee> {

    /**
     * personal user's code
     */

    protected Long id;
    /**
     * personal employee's firstName
     */
    protected String firstName;
    /**
     * personal employee's lastName
     */
    protected String lastName;
    /**
     * personal employee's number phone
     */
    protected String phone;
    /**
     * personal employee's yearBirth
     */
    protected int yearBirth;

    /**
     * Constructor default
     */
    public Employee() {
    }

    /**
     * Constructor.
     *
     * @param firstName Employee's firstName.
     * @param lastName  Employee's lastName.
     * @param phone     Employee's number phone.
     * @param yearBirth Employee's yearBirth.
     */
    public Employee(String firstName, String lastName, String phone, int yearBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.yearBirth = yearBirth;
    }

    /**
     * @return the personal employee's code id
     * return  the personal employee's code id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id personal user's code to set
     *           personal user's code to set
     */
    public void setId(Long id) {
        if (this.id == null) {
            this.id = id;
        } else {
            throw new IllegalStateException("ID of existing record can't be changed.");
        }
    }

    /**
     * @return the employee's firstName
     * * return the employee's firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the employee's lastName
     * * return the employee's lastName
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * @return the employee's user's phone
     * * return the employee's user's phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the employee's yearBirth
     * * return the employee's yearBirth
     */
    public int getYearBirth() {
        return yearBirth;
    }

    /**
     * @return the object identifier type Employee
     * return the object identifier type Employee
     */
    public boolean isManager() {
        return false;
    }

    /**
     * @return formatted string object properties Employee
     * return formatted string object properties Employee
     */
    @Override
    public String toString() {
        String fn = String.format("%-25s", firstName);
        String cn = Long.toString(id);
        cn = String.format("%-6s", cn);
        String ln = String.format("%-15s", lastName);
        String ph = String.format("%-13s", phone);
        return "[Номер_Id: " + cn + "|" + "Фамилия: " + fn + "|" + " Имя: " + ln + "|" + " Телефон: " + ph + "|" +
                " Год рождения: " + yearBirth + "]";
    }

    /**
     * The default comparator.
     */
    @Override
    public int compareTo(Employee employee) {
        return (int) (this.id - employee.id);
    }

    /**
     * Sorting according to firstName of records in a notebook.
     */
    public static Comparator<Employee> FamilyComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee r1, Employee r2) {
            return r1.getFirstName().compareTo(r2.getFirstName());
        }
    };

    /**
     * Sorting according to name of records in a notebook.
     */
    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee r1, Employee r2) {
            return r1.getLastName().compareTo(r2.getLastName());
        }
    };
    /**
     * Sorting according to yearBirth of records in a notebook.
     */
    public static Comparator<Employee> YearBirthComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee r1, Employee r2) {
            return (int) (r1.getYearBirth() - r2.getYearBirth());
        }
    };

}







