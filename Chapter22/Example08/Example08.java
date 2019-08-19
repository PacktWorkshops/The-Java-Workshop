class MyOwnThread implements Runnable {
    public void run() {
        String name = Thread.currentThread().getName();
        int sleepTime = 10000;

        System.out.println(name + ": Sleep for: " + sleepTime);

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ie) {
            System.out.println(name + ": Exception: " + ie.getMessage());
        }

        System.out.println(name + ": Thread " + name + " running");

        for (int i = 0; i < 3; i++)
            System.out.println(name + ": count: " + i);
    }
}

class MyInterruptThread implements Runnable {
    Thread threadToInterrupt;
    int timeout;

    MyInterruptThread (Thread _threadToInterrupt, int _timeout) {
        threadToInterrupt = _threadToInterrupt;
        timeout = _timeout;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        String nameToInterrupt = threadToInterrupt.getName();
        System.out.println(
                name +
                ": I am thread: " +
                name +
                " stopping thread: " +
                nameToInterrupt
        );

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ie) {
            System.out.println(name + ": Exception: " + ie.getMessage());
        }

        // stop the other thread
        threadToInterrupt.interrupt();
    }
}

public class Example08 {
    public static void main(String[] args) throws InterruptedException{
        Thread threadA = new Thread(new MyOwnThread());
        threadA.setName("A");

        Thread threadB = new Thread(new MyInterruptThread(threadA, 1000));
        threadB.setName("B");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("this is the end");
    }
}
