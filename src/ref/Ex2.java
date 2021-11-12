package ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class emp = Class.forName("ref.Employee");
        //.newInstance -  устаревший метод создания примера(объекта)
        Object o = emp.newInstance();
        //Сейчас рекомендуется
        Constructor<Employee> constructor1 = emp.getConstructor();
        //из-за Дженериков сразу пишем, что объект Employee
        Employee obj = constructor1.newInstance();

        Constructor constructor2 = emp.getConstructor(int.class,String.class,String.class);
        //.newInstance в параметрах передаем значение конструктору
        Object obj2 = constructor2.newInstance(5,"Pa","IT");
        System.out.println(obj2);
        //TODO:**************************************
        //Метод
        Method method = emp.getMethod("setSalary", double.class);
        //.invoke запускает метод и передаем туда параметры
        //объект на который хотим вызвать данный метод, и второй параметр
        //в зависимости от параметров, указываем параметры
        method.invoke(obj2,800.88);
    }
}
