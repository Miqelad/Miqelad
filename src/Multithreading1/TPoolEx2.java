package Multithreading1;
/**
 *  ________________________________________________________________________________
 * ScheduledExecutorService нужно использовать, когда хотим устанавливать
 * какие-то расписания запуска нашего
 * //метод scheduled выполнит наши таски, через определенное количество
 *         //времени
 *         scheduledExecutorService.schedule(new Runnable200()
 *                 ,3, TimeUnit.SECONDS);
 *
 ________________________________________________________________________________
/метод планирует периодическое выполнение задачи,через какое-тоо время
*         //period-это время между началом запуска n-го таска и n+1 таска.
*         //чтобы работал следующий таск, через секунду начала  предыдущего
        *scheduledExecutorService.scheduleAtFixedRate(new Runnable200()
        *,3,1,TimeUnit.SECONDS);
 * //Чтобы задачи продолжали приниматься и не зашатдаунились, нужно время поставить
 //sleep`a
 ________________________________________________________________________________
 //В этом шкедуале , тут время между концом и начало другого таска должна пройти
 //delay
 scheduledExecutorService.scheduleWithFixedDelay(new Runnable200()
 ,3,1,TimeUnit.SECONDS);
 ________________________________________________________________________________
 //Кешированный тредпул
 ExecutorService executorService = Executors.newCachedThreadPool();
 //Если треды свободны, они могут переиспользоваться
 //Но если все треды заняты, то создастя новый ТредПул;

 *         */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        //Cоздание
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
        //метод scheduled выполнит наши таски, через определенное количество
        //времени
        scheduledExecutorService.schedule(new Runnable200()
                ,3, TimeUnit.SECONDS);
        //метод планирует периодическое выполнение задачи, через какое-тоо время
        //period-это время между началом запуска n-го таска и n+1 таска.
        //чтобы работал следующий таск, через секунду начала  предыдущего
        scheduledExecutorService.scheduleAtFixedRate(new Runnable200()
                ,3,1,TimeUnit.SECONDS);
        //Чтобы задачи продолжали приниматься и не зашатдаунились, нужно время поставить
        //sleep`a
        //В этом шкедуале , тут время между концом и начало другого таска должна пройти
        //delay
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable200()
                ,3,1,TimeUnit.SECONDS);
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
        //Кешированный тредпул
        ExecutorService executorService = Executors.newCachedThreadPool();
        //Если треды свободны, они могут переиспользоваться
        //Но если все треды заняты, то создастя новый ТредПул;
    }


}
class Runnable200 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " End`s work");
    }
}
