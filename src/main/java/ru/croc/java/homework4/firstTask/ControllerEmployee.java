package ru.croc.java.homework4.firstTask;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс реализующий работу со списком сотрудников
 */

public class ControllerEmployee {
    /**
     * Двумерный массив храняший информацию о компаниях и их сторудниках,
     * где первый элемент каждого из массивов начальник компании
     */
    private final List<List<Employee>> data = new ArrayList<>();

    /**
     *Список котрудников, который необходимо преобразовать
     */
    private final List <Employee> massEmployee;

    /**
     * Конструктор класса {@link ControllerEmployee}
     * @param massEmployee смешанный список сотрудников (тип Employee) разных
     * организаций(с заполненными полями)
     */

    public ControllerEmployee(List<Employee> massEmployee){
        this.massEmployee = massEmployee;
        divideEmployees();
    }

    /**
     * Метод, который делит список сотрудников по организациям.
     */

    private void divideEmployees(){
        if (Objects.isNull(massEmployee)){
            return;
        }
        int countManager = 0;
        for (var employee : massEmployee){
            if (employee.getManager() == null){
                countManager++;
                data.add(new ArrayList<>());
                data.get(countManager-1).add(employee);
            }
        }
        for (var employee : massEmployee){
            if (employee.getManager() != null){
                Employee tmpEmp = employee;
                while (tmpEmp.getManager().getManager() != null){
                    tmpEmp = tmpEmp.getManager();
                }
                for(var company : data){
                    if (company.contains(tmpEmp.getManager())){
                        company.add(employee);
                    }
                }
            }
        }
    }

    /**
     * Возвращает список сотрудников по главному менеджеру
      * @param mainManager главный менеджер организации
     * @return список сотрудников организации
     */

    public List<Employee> getEmployeesOfOrganization(Employee mainManager){
        if (Objects.isNull(mainManager)){
            return null;
        }
        if (mainManager.getManager() != null || data.size() == 0){
            return null;
        }
        for (var organization : data) {
            if (organization.contains(mainManager)){
                return organization;
            }
        }
        return null;
    }

    /**
     * Метод который сортирует руководителей по кол-ву подчиненныйх (от большего) и имени
     * @return отсортированный список руководителей, по количеству подчиненных и
     * имени
     */

    public List<Employee> getSortedManagers(){
        if (data.size() == 0){
            return null;
        }
        data.sort((o1, o2) -> (o1.size() != o2.size())
                ? -Integer.compare(o1.size(), o2.size())
                : o1.get(0).getName().compareTo(o2.get(0).getName()));
        List<Employee> report = new ArrayList<>();
        for (var elem : data){
            report.add(elem.get(0));
        }
        return report;
    }
}
