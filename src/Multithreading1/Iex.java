package Multithreading1;

/**
 * Прерывание потока, раньше стопали:
 * thread.stop - старый метод, уже не используют
 * thread.interrupt(); - так пытается прерывать поток
 * Один поток из другого потока мы не можем прервать, можем прроверить
 * хочет ли его прервать, он посылает сигнал, хотят ли его прервать.
 * Мы сами определяем что делать,
 * if (isInterrupted()){//Проверка действия, при желании прервать
 *                 System.out.println("Thread stoping");
 *                 return;
 *             }
 *             Во время sleep или join если поток прерывается
 *             мы должны на это реагировать, поэтому и InterruptedException
 *             исключение в сигнатуры или тру катч обрабатываем
 */
public class Iex {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");
        IThread thread = new IThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        thread.join();
        System.out.println("Main ends");


    }
}
class IThread extends Thread{
    double sqrtSum=0;
    //находим сумму корней всех чисел
    public void run(){
        for (int i=0;i<1000000000;i++){
            if (isInterrupted()){//Проверка действия, при желании прервать
                System.out.println("Thread stoping");
                return;
            }
            sqrtSum+=Math.sqrt(i);
        }
        System.out.println(sqrtSum);

    }
}
