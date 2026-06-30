package src.main.multithreading.revision;

public class Revision {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableThread());
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("whatever");
            }
        });

        t2.start();
    }
}


class RunnableThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
