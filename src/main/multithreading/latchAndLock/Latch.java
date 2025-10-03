package src.main.multithreading.latchAndLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Latch {
    public static void main(String[] args) {

        //lets 1 or more thread to wait till latch reaches 0;
        //Once it reaches 0, the waiting latches can proceed;
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for(int i = 0; i < 3; i++) {
            executor.submit(new Processor(countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("completed");

    }
}


class Processor implements Runnable {
    
    private CountDownLatch latch;
    
    public  Processor(CountDownLatch latch) {
        this.latch = latch;
    }
    
    @Override
    public void run() {
        System.out.println("started");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        latch.countDown();
    }
}