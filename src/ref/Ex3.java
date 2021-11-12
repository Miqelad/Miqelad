package ref;
/**
 * Доступ к приватному
 */

import java.lang.reflect.Field;

public class Ex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10,"Paata","IT");
        Class employeClass= employee.getClass();
        Field field = employeClass.getDeclaredField("salary");
        //Нужен кастинг, ведь возвращает он Object
        //.setAccessible(true) даем достук к филду даже если он прайвет
        field.setAccessible(true);
        double salaryValue = (Double) field.get(employee);
        System.out.println(salaryValue);
        //.set принимает объект и значение на которое меняем
        field.set(employee,1400);
        System.out.println(employee);

    }
}
