package Multithreading1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//TODO: Посчитаем количество чисел, с помощью Future
public class SumNumbers {
    private static  long value = 1_000_000_000L;
    private  static long sum=0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        //Создадим лист Future
        List<Future<Long>> futureList = new ArrayList<>();
        //Для разделения значения, на 10 потоков, чтобы понять кому что
        long valueDiv=value/10;
        for (int i=0;i<10;i++){
            //начием считать с 1
            long from = valueDiv*i+1;
            //до 100млн
            long to = valueDiv*(i+1);
            //Создаем сам таск, с параметрами, которые будут итеррироваться
            PartialSum task = new PartialSum(from,to);
            //Получаем Future, с помощью .submit();
            Future<Long> futurePartSum=executorService.submit(task);
            //после получения, добавляет в лист Future
            futureList.add(futurePartSum);
        }
        //Не забываем закрыть
        executorService.shutdown();
        //Получим и сложим все результаты в переменную sum
        for(Future<Long> result: futureList){
            sum+=result.get();
        }
        System.out.println("Total sum = " + sum);



    }
}
//Будет находить сумму чисел от какогото числа, до какогото
class PartialSum implements Callable<Long>{
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }


    @Override
    public Long call() throws Exception {
        for (long i = from; i<=to;i++){
            localSum+=i;
        }
        System.out.println("Sum from: " + from+" to: " +
                to+" localSum: " + localSum);

        return localSum;
    }
}
