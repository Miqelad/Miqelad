package Multithreading1;
//TODO: Пример с DeadLock
public class Ex1 {
    public static final Object lock1=new Object();
    public static final Object lock2=new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread20.start();
        thread10.start();
    }

}
class Thread10 extends Thread{
    public  void run() {
        System.out.println("Thread10: Попытка захватить монитор объекта lock1");
        synchronized (Ex1.lock1){
            System.out.println("Thread10: Монитор lock1 ззахвачен");
            System.out.println("Thread10: Попытка захватить монитор объекта lock2");
            synchronized (Ex1.lock2){
                System.out.println("Thread10: Монитор lock1 и lock2 ззахвачен");
            }

        }

    }
}
class Thread20 extends Thread{
    public  void run() {
        System.out.println("Thread20: Попытка захватить монитор объекта lock2");
        synchronized (Ex1.lock2){
            System.out.println("Thread20: Монитор lock2 ззахвачен");
            System.out.println("Thread20: Попытка захватить монитор объекта lock1");
            synchronized (Ex1.lock1){
                System.out.println("Thread20: Монитор lock1 и lock2 ззахвачен");
            }

        }

    }
}
//TODO: Раз на раз не приходится, и программа может не завершится
//Thread 10: захватывает монитор lock1
//Thread 20: захватывает монитор lock2
//Thread 10: захватывает монитор lock2, а он уже захвачен другим потоком
//Thread 20: захватывает монитор lock1, а он уже захвачен другим потоком
//Получается два потока ждут друг друга до бесконечности
//Раз на раз не приходится, может успеют все выполнить
//Чтобы избежать в данной ситуации лока, нужна лочить одиннаково

