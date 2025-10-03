package src.main.multithreading.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ListMulti {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.main();
    }
}

class Worker {
    
    private Random random = new Random();
    
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void main() {
        long start = System.currentTimeMillis();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken = " + (end - start));
        System.out.println("ListOne size = " + list1.size());
        System.out.println("ListOne size = " + list2.size());

    }
    
    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(100));
        }
    }
    
    public void process() {
        for(int i = 0; i < 1000; i++){
            stageOne();
            stageTwo();
        }
    }
}