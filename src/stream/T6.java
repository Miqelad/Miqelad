package stream;
//TODO:
import java.util.stream.Stream;

public class T6 {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 2, 1, 5, 6, 7);
        stream1.distinct().peek(System.out::println).count();
        //C помощью пика мы посмотреть какие элементы остались
        //и коунт вывел количество строк ИНТ
       }
    }

