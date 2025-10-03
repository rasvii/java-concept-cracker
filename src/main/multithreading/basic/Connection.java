package src.main.multithreading.basic;

import java.util.concurrent.Semaphore;

class Connection {
    private static final Connection instance = new Connection();
    
    private Semaphore sem = new Semaphore(10, true);

    private int connections = 0;

    private Connection(){
    }

    public static Connection getInstance() {
        return instance;
    }
    
    private void doConnect() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections = " + connections);
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }
    }

    public void connect() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        try {
            doConnect();
        }
        finally {
            sem.release();
        }
    }
}
