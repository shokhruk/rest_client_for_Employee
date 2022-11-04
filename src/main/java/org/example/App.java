package org.example;

import org.example.configuration.MyConfig;
import org.example.entity.Employees;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//        List<Employees> allEmployees = communication.showAllEmployees();
//        System.out.println(allEmployees);
//        Employees employee = communication.getEmployeeById(1);
//        System.out.println(employee);

        Employees employee1 = new Employees("Sveta", "Petrova", "HR", 1000);
        communication.saveEmployee(employee1);

    }
}