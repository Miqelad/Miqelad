
package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO: Метод filter фильтрует данные из определенного набора
public class T2 {
    public static void main(String[] args) {
        Student st1 = new Student("Paata", 'm', 25, 3, 1.7);
        Student st2 = new Student("Vera", 'f', 24, 1, 5.7);
        Student st3 = new Student("Alisa", 'f', 2, 1, 10.5);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        //TODO: Для сортировки нужен компоратор, в параметр метода, через лямбду
        students=students.stream().sorted((x,y)->x.getName().
                compareTo(y.getName())).collect(Collectors.toList());

    }
}

//TODO:Стандартный набор класса стринг
class Student{
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }
}
