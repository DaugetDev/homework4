package ru.croc.java.homework4.firstTaskTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.croc.java.homework4.firstTask.ControllerEmployee;
import ru.croc.java.homework4.firstTask.Employee;


import java.util.Arrays;



public class FirstsTaskTest {

    @Test
    public void testIncorrectData(){
        ControllerEmployee testController = new ControllerEmployee(null);
        Assertions.assertNull(testController.getEmployeesOfOrganization(null));
        Assertions.assertNull(testController.getSortedManagers());
    }

    @Test
    public void testDivisionIntoOrganization(){
        Employee manager1 = new Employee(1, "Maxim", null);
        Employee manager2 = new Employee(2, "Alesha", null);
        Employee manager3 = new Employee(3, "Borya", null);
        Employee testEmployee = new Employee(9, "name 6", manager3);
        ControllerEmployee testController = new ControllerEmployee(
                Arrays.asList(new Employee(4, "name 1", manager1),
                        new Employee(5, "name 2", manager1),
                        new Employee(6, "name 3", manager1),
                        new Employee(7, "name 4", manager2),
                        new Employee(8, "name 5", manager1),
                        testEmployee,
                        manager1,
                        manager2,
                        manager3));
        Assertions.assertEquals(Arrays.asList(manager3, testEmployee),
                testController.getEmployeesOfOrganization(manager3));

    }

    @Test
    public void testSorting(){
        Employee manager1 = new Employee(10, "Maxim", null);
        Employee manager2 = new Employee(20, "Alesha", null);
        Employee manager3 = new Employee(30, "Borya", null);
        ControllerEmployee testController = new ControllerEmployee(
                Arrays.asList(new Employee(40, "name 10", manager1),
                        new Employee(50, "name 20", manager1),
                        new Employee(60, "name 30", manager1),
                        new Employee(70, "name 40", manager2),
                        new Employee(80, "name 50", manager1),
                        new Employee(90, "name 60", manager3),
                        manager1,
                        manager2,
                        manager3));
        Assertions.assertEquals(Arrays.asList(manager1, manager2, manager3),
                testController.getSortedManagers());
    }

}
