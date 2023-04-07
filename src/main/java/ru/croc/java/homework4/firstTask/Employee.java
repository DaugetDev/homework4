package ru.croc.java.homework4.firstTask;
/** Сотрудник. */

public class Employee {
    /**
     * Уникальный идентификатор.
     */
    private final Integer id;
    /**
     * Имя.
     */
    private final String name;
    /**
     * Руководитель.
     */
    private final Employee manager;

    /**
     * Конструктор сотрудника
     * @param id Уникальный идентификатор.
     * @param name Имя.
     * @param manager Руководитель.
     */

    public Employee(Integer id, String name, Employee manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee getManager() {
        return manager;
    }
}
