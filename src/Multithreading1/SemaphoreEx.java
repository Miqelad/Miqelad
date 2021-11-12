package Multithreading1;

import java.util.concurrent.Semaphore;

/**
 * Задачу будет решать в прошлом)
 * У нас 2 телефонные будки, к ним подошли 5 желающих позвонить
 * каждой будкой может пользовать 1 человек
 */
public class SemaphoreEx {
    public static void main(String[] args) {
        //Создаем симофор, в параметре очки, скольким потокам можно залезть
        Semaphore callBox = new Semaphore(2);
        new Person("Paata",callBox);
        new Person("Vera",callBox);
        new Person("Alisa",callBox);
        new Person("Pasha",callBox);
        new Person("Alla",callBox);
        new Person("Maxim",callBox);




    }
}

class Person extends Thread {
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.callBox = callBox;
        this.name = name;
        this.start();
    }

    public void run() {
        try {
            System.out.println(name + " waiting");
            //.acquire(); в попытке получить разрешение у Семафора
            //если получаем, то мы блокируемся и -1 очко симофору
            callBox.acquire();
            System.out.println(name + " used phone");
            sleep(2000);
            System.out.println(name+ " canceled call");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            //говорит, что мы освобождаем симофор, и добавляем +1 очко доступности
            callBox.release();

        }
    }
}
