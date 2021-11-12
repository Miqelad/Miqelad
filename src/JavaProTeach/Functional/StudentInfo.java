package JavaProTeach.Functional;
/*TODO: Function<T,R>
  T-Входной параметр, можно сказать параметр
  R-return type выходной параметр
  */

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class StudentInfo {
    void testStudents(ArrayList<Student> al, Predicate <Student> sc) {
        for (Student s : al) {
            if (sc.test(s)) {
                System.out.println(s);

            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Student st1 = new Student("Paata", 'm', 25, 3, 1.7);
        Student st2 = new Student("Vera", 'f', 24, 1, 5.7);
        Student st3 = new Student("Alisa", 'f', 2, 1, 10.5);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        System.out.println(students);
        StudentInfo info = new StudentInfo();
        Collections.sort(students,(o1,o2)->o1.name.compareTo(o2.name));
        System.out.println("List "+ students);
        System.out.println();
        //Так пишется Function
        Function<Student,Double> f = student -> 3.14;
        // в параметр добавляем Arraylist, и лямбде пише функционал ретурн тайпа метода apply
        double res = avgOfSomething(students, student -> student.avgGrade );
        //поссмотрим средний курс на котором учатся все студенты
        //делаем кастинг, ведь курс это инт
        double avgCourse = avgOfSomething(students,student -> (double)student.course);
        System.out.println(res);
    }
    public static double avgOfSomething(List<Student> list,Function<Student,Double> f){
        double result=0;
        for (Student s:list){
            //Мы знаем, что у Function есть метод apply, который у нас принимает Student
            //а возвращает Double, который мы здесь естетсвенно не прописываем,будем прописывать, когда вызовем с помощью лямда выраженыя
            result+=f.apply(s);
        }
        //Чтобы найти среднее арифметическое, мы должны поделить на количество студентов
        result=result/list.size();
        return result;
    }
}

