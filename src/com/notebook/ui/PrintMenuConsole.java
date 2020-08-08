package com.notebook.ui;

import com.notebook.entity.Employee;

import java.util.List;

/**
 * @author NikBor on 30.05.2016.
 *         The class provides the output to the console menu pages program and print records.
 */
public class PrintMenuConsole {
    public static void printMenuMain() {
        System.out.println("======================================================================================================================================================");
        System.out.println("============ Блокнот сотрудников == Главное меню  === Notebook of workmans == Main page ==============================================================");
        System.out.println("1. Новая запись в блокнот (New record in a notebook )");
        System.out.println("2. Просмотр записей в блокноте (Viewing of records in a notebook)");
        System.out.println("3. Редактирование и поиск записей в блокноте (Editing and search of records in a notebooke)");
        System.out.println("4. Закрыть блокнот (To close a notebook)");
        System.out.println("======================================================================================================================================================");
        System.out.println("Введите номер действия (1-4) и нажмите <Enter>");
    }

    public static void printMenu11() {
        System.out.println("====================================================================================================================");
        System.out.println("============ Новая запись в блокнот ==============( (New record in a notebook.)  ===================================");
        System.out.println("1. Новая запись в блокнот. (New record in a notebook. )");
        System.out.println("2. Возврат в основное меню. (Return to the main menu.)");
        System.out.println("Введите номер действия (1-2) и нажмите <Enter>");
    }

    public static void printMenu21() {
        System.out.println("============ Просмотр записей в блокноте ===========(Viewing of records in a notebook) ==============================");
        System.out.println("1. Просмотр записей в блокноте (Viewing of records in a notebook.) )");
        System.out.println("2. Сотрудники (Workmans. )");
        System.out.println("3. Менеджеры  (Managers.)");
        System.out.println("4. Возврат в основное меню. (Return to the main menu.)");
        System.out.println("Введите номер действия (1-4) и нажмите <Enter>");
    }


    public static void printMenu31() {
        System.out.println("============ Редактирование и поиск записей в блокноте ============== (Editing and search of records in f notebooke)");
        System.out.println("1. Поиск сотрудников в блокноте по Фамилии(Search of workmans in a notebook )");
        System.out.println("2. Поиск сотрудников в блокноте по Имени(Search of workmans in a notebook )");
        System.out.println("3. Поиск сотрудников в блокноте по Году рождения(Search of workmans in a notebook )");
        System.out.println("4. Удаление записи по ID номеру сотрудника (Delete of record according to number of the workman)");
        System.out.println("5. Сортировка  и просмотр записей в блокноте по Фамилии (Sorting  according to surname of records in a notebook )");
        System.out.println("6. Сортировка и просмотр записей в блокноте по Имени(Sorting according to name of records in a notebook )");
        System.out.println("7. Сортировка и просмотр записей в блокноте Году рождения(Sorting according to year birth  of records in a notebook )");
        System.out.println("8. Возврат в основное меню. (Return to the main menu.)");
        System.out.println("Введите номер действия (1-8) и нажмите <Enter>");
    }

    public static void printMenu41() {
        System.out.println("============ Закрыть блокнот (To close a notebook) ========================================================== ");
        System.out.println("1. Закрыть блокнот С сохранением внесенных изменений.  (To close a notebook with preservation of changes.)");
        System.out.println("2. Закрыть блокнот БЕЗ сохранения внесенных изменеий.  (To close a notebook withOUT preservation of changes)");
        System.out.println("Введите номер действия (1-2) и нажмите <Enter>");
    }

    public static void printRecordsConsole(List<Employee> employees) {
        for (Employee v : employees) {
            System.out.println(v);
        }
    }

    public static void printFormat1() {
        System.out.println("=== Просмотр всех записей ============================================================================================================================");
    }

    public static void printFormat2() {
        System.out.println("=== Сотрудники =======================================================================================================================================");
    }

    public static void printFormat3() {
        System.out.println("=== Менеджеры =========================================================================================================================================");
    }

    public static void printFormat4() {
        System.out.println("=== Сортировка по Фамилии ============================================================================================================================");
    }

    public static void printFormat5() {
        System.out.println("=== Сортировка по Имени  ============================================================================================================================");
    }

    public static void printFormat6() {
        System.out.println("=== Сортировка по году рождения ============================================================================================================================");
    }

}


