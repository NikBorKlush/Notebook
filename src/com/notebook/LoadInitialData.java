package com.notebook;

import com.notebook.entity.Employee;
import com.notebook.entity.Manager;
import com.notebook.service.RecordManager;

import java.io.IOException;
import java.util.List;

/**
 * @author NikBor on 01.06.2016.
 *         The class to initialize the database.
 *         Helper class for debugging code verification.
 */
public class LoadInitialData {

    public static void main(String args[]) throws IOException {
        RecordManager cm = new RecordManager();
        Employee r1 = new Manager("Клюшников", "Николай", "9370271571", 1962, "ОЭТИ");
        Employee r2 = new Employee("Клюшников", "Александр", "715741", 1968);
        Employee r3 = new Manager("Клюшников", "Виктор", "271571", 1969, "ЭВМ");
        Employee r4 = new Employee("Петров", "Николай", "269863", 1989);
        Employee r5 = new Manager("Петров", "Николай", "269864", 2000, "КИП");
        Employee r6 = new Employee("Петров", "Иван", "269865", 1970);
        Employee r7 = new Manager("Арбузов", "Николай", "269874", 1979, "ОТТ");
        Employee r8 = new Employee("Семенов", "Илья", "289863", 1972);

        cm.addRecord(r1);
        cm.addRecord(r2);
        cm.addRecord(r3);
        cm.addRecord(r4);
        cm.addRecord(r5);
        cm.addRecord(r6);
        cm.addRecord(r7);
        cm.addRecord(r8);
        List<Employee> res = cm.findRecords();
        for (Employee c : res) System.out.println(c);
        cm.saveRecords(cm.findRecords());
    }
}












