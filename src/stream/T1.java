package stream;
//TODO stream().map Разбор метода, который каждый элемент преобразует
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class T1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Byef");
        list.add("Wo");
        list.add("Why");
        //Допустим мы хотим поменять, вместо определенные элементов другие элементы
        //TODO: Старый способ
        /*for (int i= 0;i< list.size();i++){
            list.set(i, String.valueOf(list.get(i).length()));
        }
        System.out.println(list);//[5, 4, 2, 3]
        System.out.println("____________");*/
        //Методы с которыми мы работаем в стримах, перед этим мы преобразовываем в потоки
        //т.е. мы из коллекции получили стрим
        //map берет каждый элемент стрима, и сопоставляем ему элемент,который из него получается
        //после применения на нем тех действий, которые мы описываемс помощью лямбда
        //list.stream().map(element->element.length());
        //метод возвращает стрим, поэтому мы не можем его присвоить сущетсвующему или новому листу
        //Для того, чтобы присвоить его листу, мы вначале должны применить метод
        //collect(Collectors.toList())
        List<Integer> list2 = list.stream().map(element -> element.length())
                .collect(Collectors.toList());
        System.out.println(list2);//[5, 4, 2, 3]
        //TODO: Не меняет саму коллекцию, на которой был вызван
        //TODO: Пример работы с массивом
        int[] array = {1, 2, 3, 4, 5};
        //Получаем из массива стрим, если элемент нацело делится на 3, то делим
        int[] array2=Arrays.stream(array).map(element ->
        {if (element % 3 == 0) {
            element = element / 3;
            //toArray чтобы преобразовать поток в массив
        }return element;}).toArray();
        //Для красивого вывода используем метод
        System.out.println(Arrays.toString(array2));
        //TODO: Работа с Set
        Set<String> set =new TreeSet<>();
        set.add("Hello");
        set.add("Byef");
        set.add("Wo");
        set.add("Why");
        System.out.println(set);
        Set<Integer> set2=set.stream().map(e->e.length())
                .collect(Collectors.toSet());
        System.out.println(set2);
        //Люблй поток можно преобразовать в лист или другие элементы
        List<Integer> l2 = set.stream().map(e->e.length())
                .collect(Collectors.toList());
        System.out.println(l2);
    }

}
