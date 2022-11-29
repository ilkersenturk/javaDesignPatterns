package Playground;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {

    public void run(){

        for(int i=10; i>0; i--){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Tick Tok -" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public MyThread(){
        this.start();
    }

    public static void main(String[] args) {
        System.out.println("Main method is started ...");
        Thread firstThread =new MyThread();
        firstThread.setName("firstThread");
        Thread secondThread =new MyThread();
        secondThread.setName("secondThread");
        System.out.println("main method is ended");

    }
}
