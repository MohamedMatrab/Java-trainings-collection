package Threads;

public class MyMain {
    public static void main(String[] args) throws InterruptedException{

        System.out.println("Hello");

        MyRunnable myRunnable=new MyRunnable();
        MyRunnable myRunnable1=new MyRunnable();

        Thread thread2=new Thread(myRunnable1);
        Thread thread1=new Thread(myRunnable);

        thread1.setDaemon(true);
        thread2.setDaemon(true);

        thread1.start();
//        thread1.join();
        thread2.start();


        System.out.println(1/0);

    }
}