package src.main.multithreading.basic;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Example 1
/*public class ProducerConsumer {
    
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        
        
    }
    
    private static void producer() throws InterruptedException {
        Random rand = new Random();
        
        while(true) {
            queue.put(rand.nextInt(100));
        }
    }
    
    private static void consumer() throws InterruptedException {
        Random rand = new Random();
        while(true) {
            Thread.sleep(100);
            if(rand.nextInt(10) == 0) {
                Integer value = queue.take();

                System.out.println("Taken value = " + value + " Queue size = " + queue.size());
            }
            
        }
    }
}*/

//Example 2

public class ProducerConsumer {
    
    public static void main(String[] args) throws InterruptedException {

        Processor1 processor = new Processor1();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class Processor1 {
    
    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock =  new Object();
    
    public  void producer() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (lock) {
                while(list.size() == LIMIT) {
                    lock.wait();
                }
                System.out.println("Adding");
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Random rand = new Random();
        
        while(true) {
            synchronized (lock) {
                while(list.isEmpty()) {
                    lock.wait();
                }
                System.out.print("List size is : " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }
            
            Thread.sleep(rand.nextInt(1000));
        }
    }
}
