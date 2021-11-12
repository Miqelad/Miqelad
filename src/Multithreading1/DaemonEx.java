package Multithreading1;
//TODO: isDaemon- проверка setDaemon - делает его демоном

/**
 * Main threads starts
 * Main threads ends
 * User is Daemon:false
 * Daemon is Daemon:true
 * 1 2 3 4 5 6 7 8 9 A
 * 10 11 12 13 14 15 16 17 18 B
 *
 * Process finished with exit code 0
 * Закончился, как юзер потоки закончили свою работу*/
public class DaemonEx {
    public static void main(String[] args) {
        System.out.println("Main threads starts");
        UserThread  thread = new UserThread();
        thread.setName("User");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);//обозначаем что он демон
        daemonThread.setName("Daemon");
        daemonThread.start();
        thread.start();

        System.out.println("Main threads ends");
    }
}
class UserThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName()+
                " is Daemon:" + isDaemon());//является ли данный поток Деомоном
        for (char i = 'A';i<='B';i++){
            try {
                sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DaemonThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName()+
                " is Daemon:" + isDaemon());//является ли данный поток Деомоном
        for (int i = 1;i<=1000;i++){
            try {
                sleep(100);
                System.out.print(i+" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
