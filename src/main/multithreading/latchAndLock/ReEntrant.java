package src.main.multithreading.latchAndLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrant {

    public static void main(String[] args) throws InterruptedException {

        Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
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
                    runner.secondThread();
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
        
        runner.finished();
    }
}

class Runner {
    
    private  int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    
    private void increment() {
        for(int i = 0; i < 10000; i++) {
            count++;
        }
    }
    
    public void firstThread() throws  InterruptedException {
        lock.lock();

        System.out.println("Waiting...");
        condition.await();
        System.out.println("Woken up!");

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws  InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press return ");
        scanner.nextLine();
        System.out.println("Got return key ");
        condition.signal();
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finished() throws  InterruptedException {
        System.out.println("Count is: " + count);
    }
    
    
}
