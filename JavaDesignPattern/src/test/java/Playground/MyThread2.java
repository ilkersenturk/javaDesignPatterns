package Playground;

public class MyThread2 implements Runnable {

    /*
    https://www.youtube.com/watch?v=eKWjfZ-TUdo

     */
    private static Integer id =0;

    @Override
    public  void run() {

        setId();

        for(int i =10; i>0; i--){

            System.out.println("Thread id :" +id + " Tic Tock " +  i);

        }
    }

    public synchronized void setId(){

        this.id++;
    }



    public static void main(String[] args) throws InterruptedException {

       Thread thread1 = new Thread(new MyThread2());
       thread1.start();
       Thread.sleep(2000);
       Thread thread2 = new Thread(new MyThread2());
       thread2.start();
       Thread thread3 = new Thread(new MyThread2());
       thread3.start();
    }
}