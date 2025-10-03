package src.main.multithreading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphore {

    public static void main(String[] args) throws InterruptedException {
//        Semaphore sem = new Semaphore(0);
//        
//        sem.release();
//        sem.acquire();
//
//        System.out.println("Available permits = " + sem.availablePermits());

        ExecutorService executorService = Executors.newCachedThreadPool();
        
        for(int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }
        
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}


