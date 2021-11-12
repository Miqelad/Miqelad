package stream;

import java.util.*;

//TODO: reduce, на выходе всегда получаем один элемент )
public class T4 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);
        int result=list.stream().reduce((accumulator,element)->
                accumulator*element).get();
        System.out.println(result);
        //5,4,3,2,1
        //accumulator = 5 - сразу присваивается первое значение, после умножение он становится уже 40
        //Он будет собирать все произведения, а элементу назначется уже слудующее значение
        //element =     8 - сразу присваивается второе значение

        //accumulator-  5  40  80  320  960
        //element -     8  2   4   3
        //на этом reduce заканчивает свою работу и возращается 960
        //TODO зачем нужен get , это опшионал класс,
        // объект типа опшионал делает(wrap) оборачивает собой объект(в данном случае Интеджер)
        //(960) ялвяется контейнерам для нашего значения
//////////////////////////////////////////////
//TODO: Пример обезопасности если нет значений
        List<Integer> list100 = new ArrayList<>();
        Optional<Integer> o=list100.stream().reduce((accumulator,element)->
                accumulator*element);
        //.isPresent присутствует ли значение, если да то выведи его
        if (o.isPresent()){
            System.out.println(o.get());
        }else {
            System.out.println("Not Present");
        }//TODO: такое конечно редко случается, но если значения не было бы, то вышло бы исключение, поэтому get удобен
//////////////////////////////////////////////
        int result2=list.stream().reduce(1,(accumulator,element)->
                accumulator*element);
        System.out.println(result2);
        //Если мы в reduce добавим значение вначале, то он становится первым значением
        //аккамулятора, а первое значение в данном случае листа, идет в элемент
        //accumulator - 1  5  40  80  320  960
        //element -     5   8  2   4   3
        //TODO: это делается для того, что мы уже записали какое-то значение и у нас не будет null значения и метод get не нужен
        //TODO: Пример найдем контантенацию всех стрингов листа
        List<String> list3 = new ArrayList<>();
        list3.add("Heelo");
        list3.add("Bye");
        String result3 = list3.stream().reduce((accumulator,element)-> accumulator + " "+element).get();
        System.out.println(result3);
    }
}
