package src.main.multithreading.latchAndLock;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {

        Runner1 runner = new Runner1();

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

class Runner1 {
    
    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    
    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        while(true) {
            boolean gotFirst = false;
            boolean gotSecond = false;
            try{
                gotFirst = firstLock.tryLock();
                gotSecond = secondLock.tryLock();
            }
            finally {
                if(gotFirst && gotSecond) {
                    return;
                }
                
                if(gotFirst) firstLock.unlock();
                if(gotSecond) secondLock.unlock();
            }
            
            Thread.sleep(500);
        }
    }

    public void firstThread() throws  InterruptedException {
        Random random = new Random();

        for(int i = 0; i < 10000; i++) {
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws  InterruptedException {

        Random random = new Random();

        for(int i = 0; i < 10000; i++) {
            acquireLocks(lock2, lock1);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() throws  InterruptedException {
        System.out.println("Account 1 balance = " + acc1.getBalance());
        System.out.println("Account 2 balance = " + acc2.getBalance());
        System.out.println("Total balance = " + (acc1.getBalance() + acc2.getBalance()));
    }

}

class Account {
    private int balance = 10000;
    
    public void deposit(int amount) {
        balance += amount;
    }
    
    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
    
    public static void transfer(Account account1, Account account2, int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }
}
