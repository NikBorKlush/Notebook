package com.notebook.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NikBor on 12.05.2016.
 */

/**
 * The class provides console input and validation.
 */
public class ReadKeyboardConsole {
    /**
     * @return integer temp from 1 to b
     * return   integer temp from 1 to b
     */
    public static int readPointMenu(int b) throws IOException {
        int temp = 0;
        do {
            Scanner ins = new Scanner(System.in);
            if (ins.hasNextInt()) {
                temp = ins.nextInt();
            } else {
                System.out.println("Внимательно повторите ввод! ");
                continue;
            }
            if (temp < 1 || temp > b) {
                System.out.println("Внимательно повторите ввод! ");
                continue;
            }
            break;
        } while (true);
        return temp;
    }

    /**
     * @return String temp firstName; lastName; earBirth; depending on the criterion of numbers.
     * return  String temp firstName; lastName; earBirth; depending on the criterion of numbers.
     */
    public static String readCriterion(int a) throws IOException {
        BufferedReader ins1 = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        switch (a) {
            case 1: {
                System.out.print("Введите Фамилию:");
                temp = ins1.readLine().trim();
                break;

            }
            case 2: {
                System.out.print("Введите Имя: ");
                temp = ins1.readLine().trim();
                break;

            }
            case 3: {
                System.out.print("Введите год рождения: ");
                int yearMax = getYear();
                do {
                    try {
                        temp = ins1.readLine();
                        if (temp.length() != 4) {
                            System.out.println("Внимательно повторите ввод! ");
                            continue;
                        }
                        Integer j = Integer.valueOf(temp);
                        if (j < yearMax - 110 || j > yearMax) {
                            System.out.println("Внимательно повторите ввод! ");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        {
                            System.out.println("Внимательно повторите ввод! ");
                            continue;
                        }
                    }
                    break;
                } while (true);

            }
        }
        return temp;
    }

    /**
     * @return Lond id personal user's code dor delete.
     * return  Lond id personal user's code dor delete.
     */
    public static Long readIDForDelete() throws IOException {
        System.out.print("Введите Номер записи для её удаления:");
        String input = "";
        Scanner ins2 = new Scanner(System.in);
        do {
            input = ins2.nextLine().trim();
            if (checkingInputDigital(input)) break;
            else {
                System.out.println("Внимательно повторите ввод! ");
            }
        } while (true);
        return Long.valueOf(input);
    }

    /**
     * Template for control of input data console.
     */
    protected static boolean checkingInputDigital(String input) {
        Pattern p = Pattern.compile(("[\\d]+"));
        Matcher m = p.matcher(input);
        return m.matches();
    }

    /**
     * @return int Year -this year.
     * return  int Year -this year.
     */
    private static int getYear() {
        Calendar k = Calendar.getInstance();
        return k.get(Calendar.YEAR);
    }

}

