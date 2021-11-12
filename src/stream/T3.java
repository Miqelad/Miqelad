package stream;
//TODO: Данные референсы не касаются именно стримов, их можно использовать в любых лямбда выражениях
import java.util.Arrays;

public class T3 {
    public static void main(String[] args) {
        int[] array = {1,3,4,2};
        Arrays.stream(array).forEach(e-> System.out.println(e));
        //TODO:Как сократить еще написание, метод рефернс называется
        //Джава умна, что мы должн вставить каждый элемент стрима
        Arrays.stream(array).forEach(System.out::println);
        //сам элемент не трогается
        System.out.println(Arrays.toString(array));
        //Каждый элемент потока, помести в method в качестве параметра, который находится в классе Unil
        //Метод референс, это ссылка на метод
        Arrays.stream(array).forEach(Unils::method);
//        Element =6
//        Element =8
//        Element =9
//        Element =7

    }
}
class Unils{
    public static void method(int a){
        a+=5;
        System.out.println("Element =" + a);
    }
}
