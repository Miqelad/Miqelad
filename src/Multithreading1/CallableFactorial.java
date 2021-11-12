package Multithreading1;
//TODO: Переписали задачу, с помощью Callable
import java.util.concurrent.*;

/**
 * Интерфейс Callable со своим методом
 *
 * @FunctionalInterface public interface Callable<V> {
 * V call()throws Exception;
 * }
 */

/**
 * submit тоже выполняет задание, но помимо этого возвращает
 * результат таска, который хранится в объекте Future
 * .get() получаем значение из Future
 */
public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(5);
        //submit тоже выполняет задание, но помимо этого возвращает результат таска
        //результат этого таска хранится в объекте Future
        Future<Integer> future=executors.submit(factorial2);
        try {
            //получаем значение с помощью метода get
            System.out.println("We need result");
            factorialResult=future.get();
            System.out.println("We have result");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            //.getCause - причина почему было выброшено искл.
            System.out.println(e.getCause());;
        }
        finally {
            executors.shutdown();
        }
        System.out.println(factorialResult);


    }
}

class Factorial2 implements Callable<Integer> {
    int f;

    public Factorial2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if(f<=0){
            throw new Exception("Not corrected number");
        }
        int result=1;
        for(int i=1;i<=f;i++){
            result*=i;
            Thread.sleep(1000);
        }
        return result;
    }
}
