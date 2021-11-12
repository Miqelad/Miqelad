package fcsty.lab3;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Exchanger;

public class t1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        new Thread(()->{
            int i = 0;
            while (true){
                try {
                    queue.put(i++);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" this queue putting"+queue);
            }


        }).start();
        new Thread(()->{
            int i=0;
            while (true){
                try {
                    i=queue.take().intValue();
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i+"take"+" this queue takeball "+queue);
            }

        }).start();
    }
}