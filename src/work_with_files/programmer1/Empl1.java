package work_with_files.programmer1;

import java.io.Serializable;

/**
 * Представим себе, что по определенным причинам мы не должны
 * отправлять информацию о заработной плате
 * transient временный
 */
public class Empl1 implements Serializable {
    //Нужно указывать вресию класса, чтобы другой программист не путался
    //с какой версией он будет работать.
    //Версии лучше писать самому, с 1--->
    static final long serialVersionUID = 2;
    String name;
    String departament;
    int age;
   // b479ph790
    transient double salary;

    @Override
    public String toString() {
        return "empl1{" +
                "name='" + name + '\'' +
                ", departament='" + departament + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Empl1(String name, String departament, int age, double salary) {
        this.name = name;
        this.departament = departament;
        this.age = age;
        this.salary = salary;
    }
}
