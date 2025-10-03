package src.main.multithreading.basic;

import java.util.logging.Logger;

public class MyThread{
    
    public static void main(String[] args) throws InterruptedException {
//        Runner runner1 = new Runner();
//        runner1.start();
//
//        Runner runner2 = new Runner();
//        runner2.start();
        
        Thread t1 = new Thread(new RunnerRunnable());
        t1.start();

        Thread t2 = new Thread(new RunnerRunnable());
        t2.start();
        
        Thread t3 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                for(int i= 0; i < 10 ; i++) {
                    System.out.println("hello " +i);

                    try{
                        Thread.sleep(100);
                    }
                    catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        t3.start();
        
    }
}


class Runner extends Thread{

    @Override
    public void run() {
        for(int i= 0; i < 10 ; i++) {
            System.out.println("hello " +i);

            try{
                Thread.sleep(100);
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}


class RunnerRunnable implements  Runnable {
    
    @Override
    public void run() {
        for(int i= 0; i < 10 ; i++) {
            System.out.println("hello " +i);

            try{
                Thread.sleep(100);
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
