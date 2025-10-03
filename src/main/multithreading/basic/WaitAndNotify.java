package src.main.multithreading.basic;

import java.util.Random;
import java.util.Scanner;

public class WaitAndNotify {

    public static void main(String[] args) throws InterruptedException {

        Processor processor = new Processor(); 

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

class Processor {
    public  void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running .....");
            wait();
            System.out.println("Resumed ....");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
            
        synchronized (this) {
            System.out.println("Waiting for return key ..");
            scanner.nextLine();
            System.out.println("Return key pressed...");
            notify();
            Thread.sleep(5000);
            
        }
    }
}
