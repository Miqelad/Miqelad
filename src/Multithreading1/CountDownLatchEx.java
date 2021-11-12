package Multithreading1;

import java.util.concurrent.CountDownLatch;

/**
 * Представим распродажу в черную пятницу
 * Люди стоят одни из первых, в ожидание открытия магазина
 * Но не можем приступить к покупкам, пока не будут выполнены условия
 * Работники должны прийти на работу
 * Свет должен быть включен и убрано
 * Магазин должен открыться
 */
public class CountDownLatchEx {
    static CountDownLatch countDownLatch =new CountDownLatch(3);
    //как будто сотрудникам нужно 2 секунды, чтобы прийти
    private static void marketStaffPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff come to work");
        //countDown() - уменьшить значение счетчика
        countDownLatch.countDown();
        //getCount() - значение счетчика
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }
    //Приготовление к открытию магазина
    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let`s Open Market");
        //countDown() - уменьшить значение счетчика
        countDownLatch.countDown();
        //getCount() - значение счетчика
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }
    //открытие магазина
    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened");
        //countDown() - уменьшить значение счетчика
        countDownLatch.countDown();
        //getCount() - значение счетчика
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        new Friend("Paata",countDownLatch);
        new Friend("Vera",countDownLatch);
        new Friend("Alisa",countDownLatch);
        new Friend("Pasha",countDownLatch);
        new Friend("Alla",countDownLatch);
        new Friend("Maxim",countDownLatch);
        marketStaffPlace();
        everythingIsReady();
        openMarket();

    }
}
class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;
    public Friend(String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
        //чтобы поток автоматически запускался
        this.start();
    }
    public void run(){
        System.out.println(name + " waiting");

        try {//Если счетик >0 наш поток будет заблокирован,
            //пока счетчик не станет равен нулю
            countDownLatch.await();
            System.out.println(name + " started bought");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
