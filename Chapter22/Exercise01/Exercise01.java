import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.System.currentTimeMillis;

class ObjectCounter implements Runnable {
    public AtomicInteger counter = new AtomicInteger(0);

    public void pause(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ie) {
            System.out.println(getName() + ": Exception: " + ie.getMessage());
        }
    }

    public void increment() {
        counter.incrementAndGet();
        System.out.print(getName() + "+, ");
        pause(100);
    }

    public void decrement() {
        counter.decrementAndGet();
        System.out.print(getName() + "-, ");
        pause(100);
    }

    public int get() {
        return counter.get();
    }

    public String getName() {
        return Thread.currentThread().getName();
    }

    public void run() {
        while(true) {
            System.out.println("\n" + getName() + ": Counter: " + counter);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                System.out.println("\n" + getName() + ": Exception: " + ie.getMessage());
                return;
            }
        }
    }
}

class ObjectIncrement implements Runnable {
    ObjectCounter threadToCount;
    int objectFreq;
    int simulationSize;

    ObjectIncrement(ObjectCounter _threadToCount, int _objectFreq, int _simulationSize) {
        threadToCount = _threadToCount;
        objectFreq = _objectFreq;
        simulationSize = _simulationSize;
    }

    public void run() {
        String name = Thread.currentThread().getName();

        System.out.println(name + ": counting in thread");

        for (int i = 0; i < simulationSize; i++) {
            threadToCount.increment();

            try {
                Thread.sleep(objectFreq);
            } catch (InterruptedException ie) {
                System.out.println(name + ": Exception: " + ie.getMessage());
            }
        }
    }
}

class ObjectDecrement implements Runnable {
    ObjectCounter threadToDiscount;
    int objectFreq;
    int simulationSize;

    ObjectDecrement (ObjectCounter _threadToCount, int _objectFreq, int _simulationSize) {
        threadToDiscount = _threadToCount;
        objectFreq = _objectFreq;
        simulationSize = _simulationSize;
    }

    public void run() {
        String name = Thread.currentThread().getName();

        System.out.println(name + ": discounting in thread");

        // discount only if there is something in
        while (simulationSize > 0) {
            if (threadToDiscount.get() > 0) {
                threadToDiscount.decrement();

                try {
                    Thread.sleep(objectFreq);
                } catch (InterruptedException ie) {
                    System.out.println(name + ": Exception: " + ie.getMessage());
                }

                simulationSize--;
            }
        }
    }
}

public class Exercise01 {

    public static void main(String[] args) throws InterruptedException{
        int simulationSize = 100;
        ObjectCounter _threadA = new ObjectCounter();
        Thread threadA = new Thread(_threadA);
        threadA.setName("A");
        ObjectIncrement _threadB = new ObjectIncrement(_threadA, 5, simulationSize);
        Thread threadB = new Thread(_threadB);
        threadB.setName("B");
        ObjectDecrement _threadC = new ObjectDecrement(_threadA, 10, simulationSize);
        Thread threadC = new Thread(_threadC);
        threadC.setName("C");

        long startTime = currentTimeMillis();
        threadA.start();
        threadB.start();
        threadC.start();

        threadB.join();
        threadC.join();
        threadA.interrupt();
        long endTime = currentTimeMillis();

        System.out.println("exec time: " + (endTime - startTime));
    }
}
