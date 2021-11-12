package Multithreading1;
//Executor интерфейс, с помощью него мы работаем с ThreadPool
/**
 * .execute выполняет задачу свободным потоком
 * .shutdown() после того, как все задания выполняться, программа закончится
 *.awaitTermination(число, TimeUnit.формать времени) будет ждать, пока не закончится вся работа или время указанное в параметре
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnaableI());
            //метод execute(объект имплементирующий Runnable) передает задание
        }
        //Если мы не намерены больше давать задания, мы должны его тушить
        executorService.shutdown();
        //Всегда пишется после шатдауна.
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Main");
    }
}

class RunnaableI implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

