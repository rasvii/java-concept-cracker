package src.main.multithreading.basic;

public class AppThread implements Runnable{

    private int threadNumber = 0;
    
    public AppThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    
    
    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            System.out.println(i + " from thread " + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
