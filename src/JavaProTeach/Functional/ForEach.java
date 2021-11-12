package JavaProTeach.Functional;
//TODO: сокращение метода forEach
import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List <String> list = List.of("privet","poka");
        for(String s: list){
            System.out.println(s);
        }
        //Каждый элемент листа, String, переменная str, и должны ее вывести
        //будем делать для каждого элемента листа
        list.forEach(str-> System.out.println(str));
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(5);
        list2.add(4);
        list2.forEach(i-> System.out.println(i));


    }
}
