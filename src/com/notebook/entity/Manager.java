package com.notebook.entity;

/**
 * @author NikBor on 13.06.2016.
 *         The class provides a template to create the object: Manager.
 */
public class Manager extends Employee {

    private String department;

    /**
     * Constructor default.
     */
    public Manager() {
    }

    /**
     * Constructor.
     *
     * @param firstName  Manager's firstName.
     * @param lastName   Manager's lastName.
     * @param phone      Manager's number phone.
     * @param yearBirth  Manager's yearBirth.
     * @param department Manager's department.
     */
    public Manager(String firstName, String lastName, String phone, int yearBirth, String department) {
        super(firstName, lastName, phone, yearBirth);
        this.department = department;
    }

    /**
     * @return the object identifier type Manager
     * return the object identifier type  Manager
     */
    @Override
    public boolean isEmployee() {
        return false;
    }

    /**
     * @return the manager's  department
     * * return the manager's department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @return formatted string object properties Manager
     * return formatted string object properties  Manager
     */
    @Override
    public String toString() {
        String fn = String.format("%-25s", firstName);
        String cn = Long.toString(id);
        cn = String.format("%-6s", cn);
        String ln = String.format("%-15s", lastName);
        String ph = String.format("%-13s", phone);
        String dep = String.format("%-13s", department);
        return "[Номер_Id: " + cn + "|" + "Фамилия: " + fn + "|" + " Имя: " + ln + "|" + " Телефон: " + ph + "|" +
                " Год рождения: " + yearBirth + "|" + " Отдел: " + dep + "]";
    }
}






