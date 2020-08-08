package com.notebook.ui;

import com.notebook.entity.Employee;
import com.notebook.entity.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author NikBor on 09.06.2016.
 *         Factory to create an instance of Employee or Manager.
 *         Properties and type the instance user input from the console.
 *         These are checked on entry correctly.
 */

public class RecordsFactory {

    /**
     * @return object Employee or Manager.
     * return object Employee or Manager.
     */
    public static Employee readPersonData() throws IOException {
        String str[] = new String[7];
        BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
        str[0] = ReadKeyboardConsole.readCriterion(1);
        str[1] = ReadKeyboardConsole.readCriterion(2);
        str[3] = ReadKeyboardConsole.readCriterion(3);
        int str3 = Integer.parseInt(str[3]);
        System.out.print("Введите номер телефона: ");
        do {
            str[2] = ins.readLine().trim();
            if (ReadKeyboardConsole.checkingInputDigital(str[2]) && (str[2].length() < 13)) break;
            else {
                System.out.println("Внимательно повторите ввод! Только цифры! Не более 12   ");
            }
        } while (true);
        System.out.print("Введите грейд <1> для сотрудника Менеджера: ");
        System.out.print("Введите грейд <0> для сотрудника ");

        while (true) {
            str[4] = ins.readLine();
            if ("1".equals(str[4])) {
                System.out.print("Для руководителя введите название отдела отдел: ");
                str[5] = ins.readLine();
                break;
            } else if ("0".equals(str[4])) {
                str[5] = "--------";
                break;
            } else {
                System.out.println("Repeat input: 1 or 0" + "   Внимательно повторите ввод! ");
            }
        }

        System.out.println("========= Новая запись сформирована: =================================================================================================");
        System.out.println("Фамилия  Имя:  " + str[0] + "  " + str[1]);
        System.out.println("Год рождения:  " + str[3] + "  " + "Телефон " + str[2]);
        System.out.println("Грейд:  " + str[4] + "  " + "Отдел " + str[5]);
        System.out.println("Сохранить запись - введите <1> || Введите <2> для выхода без сохранения:");
        while (true) {
            str[6] = ins.readLine();
            if ("1".equals(str[6]) && "1".equals(str[4]))
                return new Manager(str[0], str[1], str[2], str3, str[5]);
            if ("1".equals(str[6]) && "0".equals(str[4])) return new Employee(str[0], str[1], str[2], str3);
            else if ("2".equals(str[6])) {
                return null;
            } else {
                System.out.println("Repeat input: 1 or 2" + "   Внимательно повторите ввод! ");
            }
        }
    }
}
