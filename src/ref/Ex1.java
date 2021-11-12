package ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException
            , NoSuchFieldException
            , NoSuchMethodException {
        //первый вариант создания
        Class employeeClass = Class.forName("ref.Employee");
//        //второй вариант создания
//        Class employeeclass = Employee.class;
//        //третий вариант создания
//        Employee emp = new Employee();
//        Class employeeclass3 = emp.getClass();
        //.getField меод дает поле по названию, Field вернет
        Field someField=employeeClass.getField("id");
        //.getType() Даст нам типо поля
        System.out.println("Type of field " + someField.getType());
        //TODO:(********************)
        //.getFields() вернет все поля класса в массив
       Field[] fields= employeeClass.getFields();
       for (Field s: fields){
           //s.getName() имя поля
           System.out.println(s.getName() + " = " + s.getType());
           //но здесь нет полей который private
       }
        //TODO:(********************)
       //TODO: Как получить все поля даже прайвет
        Field[] fields1 = employeeClass.getDeclaredFields();
        for (Field s: fields1){
            //s.getName() имя поля
            System.out.println(s.getName() + " = " + s.getType());

        }
        //TODO: Методы
        //TODO:(********************)
        //.getMethod вернет метод по классу Метод
        Method method=employeeClass.getMethod("increaseSalary");
        //method.getReturnType() ретерн тип,
        //method.getParameterTypes() вернет массив параметров
        System.out.println("Return type= "+ method.getReturnType()+
                " parametersTypes= "
                + Arrays.toString(method.getParameterTypes()));
        //.getMethod(название метода, и параметры которые есть)
        //TODO:(********************)
        Method method1=employeeClass.getMethod("setSalary", double.class);
        //method.getReturnType() ретерн тип,
        //method.getParameterTypes() вернет массив параметров
        System.out.println("Return type= "+ method1.getReturnType()+
                " parametersTypes= "
                + Arrays.toString(method1.getParameterTypes()));
        //TODO:(********************)
        //Выведем все методы, по аналогии Филда
        //Даже те методы, которые унаследованы от родителей
        //но не вернул прайват методы
        Method[] methods=employeeClass.getMethods();
        for (Method method2:methods){
            System.out.println("Name of method: "+ method2.getName()+
                    " Return Type: " + method2.getReturnType()+
                    " Parameters "+method2.getParameterTypes());
        }
        //TODO:(********************)
        //Вернуть все методы даже прайвет
        Method[] methods1=employeeClass.getDeclaredMethods();
        for (Method method2:methods1){
            System.out.println("Name of method: "+ method2.getName()+
                    " Return Type: " + method2.getReturnType()+
                    " Parameters "+method2.getParameterTypes());
        }
        //TODO:(********************)
        //Вернуть с определенной модифаером
        Method[] methods2=employeeClass.getDeclaredMethods();
        for (Method method2:methods1){
            //TODO: Есть такой класс MOdifier
            //isPublic проверяет,.getModifires - модификатор
            if(Modifier.isPublic(method2.getModifiers()))
            System.out.println("Name of method: "+ method2.getName()+
                    " Return Type: " + method2.getReturnType()+
                    " Parameters "+method2.getParameterTypes());
        }
        //TODO:(********************)
        //TODO: Конструкторы
        //.getConstructor() - получаем конструктор класс
       Constructor constructor= employeeClass.getConstructor();
        //названия говорят сами за себя
        System.out.println("Constrictor has " + constructor.getParameterCount() +
                " Parametr types "
                        + Arrays.toString(constructor.getParameterTypes()));
        //TODO:(********************)
        //Конструктор с такими то параметрами
        Constructor constructor1= employeeClass.getConstructor(int.class,String.class,String.class);
        //названия говорят сами за себя
        System.out.println("Constrictor has " + constructor1.getParameterCount() +
                " Parametr types "
                + Arrays.toString(constructor1.getParameterTypes()));
        //TODO:(********************)
        //Конструкторы все .getConstructors()
        Constructor[] constructor2= employeeClass.getConstructors();
        //названия говорят сами за себя
        for(Constructor constructor3: constructor2){
            System.out.println(constructor3.getName());
        }


    }
}
