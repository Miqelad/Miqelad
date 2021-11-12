package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotaion {
    public static void main(String[] args) {
        Parent p = new Child("Paata");
        p.showInfo();

    }
}
class Parent{
    String name;

    public Parent(String name) {
        this.name = name;
    }
    //Устаревший метод, считается устаревшим,
    //будет перечеркнут при вызове
    @Deprecated
    void showInfo(){
        System.out.println("It`s Parent class Name= "+ name);
    }
}
class Child extends Parent{
    public Child(String name) {
        super(name);
    }
    //Очень удобная Анотация, при переопределении,
    //При некорректном оверрайде, будет красным гореть
    @Override
    void showInfo(){
        System.out.println("It`s Child class. Name = " + name);

    }
    //создается как интерфейс, просто вначале пишется @
    //@Target ставится то создания нашей Аннотации
    //Можно указать много разных enum
    @Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
    //До какого эта программы будет видна анотация
    @Retention(RetentionPolicy.SOURCE)
    @interface Myannotation{}
}
