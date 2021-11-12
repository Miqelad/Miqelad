package Multithreading1;
/**
 * Lock  и его методы
 * lock()-активируем наш код, может использзовать только 1 поток
 * unlock()- деактивация
 * tryLock()- попытайся залочить, если нет, то делай дальше, он не ждет в очереди, сразу пытается залочить
 * Вывод
 * Mobile call starts
 * False locking
 * Mobile call ends
 * Skype call starts
 * Skype call ends
 */
//TODO: отличие  сихнхронайзд лока, от данного, в том, что его закрывать не надо

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        //Используя Lambda
        Thread thread2 = new Thread(()->call.sCall());
        thread1.start();
        thread2.start();
        //Вариант вызова без имени потока
        new Thread(()->call.sCall3()).start();

    }
}

class Call {
    //Создаем объект интерфейса Lock
    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();//ставим замок
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Unlock надо всегда писать в finally, если выброситься исключение
            //наш лок, должен открываться в любом случае
            lock.unlock();
        }
    }

    void sCall() {
        if (lock.tryLock()){//если удалосьь залочить, то тру, нет false
        try {
            System.out.println("Skype call starts");
            Thread.sleep(3000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Unlock надо всегда писать в finally, если выброситься исключение
            //наш лок, должен открываться в любом случае
            lock.unlock();

        }
    }
    else {
            System.out.println("False locking");
        }}
    void sCall3() {
        lock.lock();
            try {
                System.out.println("Skype call starts");
                Thread.sleep(3000);
                System.out.println("Skype call ends");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Unlock надо всегда писать в finally, если выброситься исключение
                //наш лок, должен открываться в любом случае
                lock.unlock();

            }
        }
}

