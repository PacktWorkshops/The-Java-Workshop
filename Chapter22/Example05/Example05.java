class MyOwnThread implements Runnable {
    public void run() {
        System.out.println(
            Thread.currentThread().getName() +
            ": Thread " +
            Thread.currentThread().getName() +
            " running");

        System.out.println(
            Thread.currentThread().getName() +
            ": ID " +
            Thread.currentThread().getId());

        System.out.println(
            Thread.currentThread().getName() +
            ": Priority " +
            Thread.currentThread().getPriority());
    }
}

public class Example05 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyOwnThread());
        threadA.setName("A");
        threadA.setPriority(Thread.MAX_PRIORITY);

        Thread threadB = new Thread(new MyOwnThread());
        threadB.setName("B");
        threadB.setPriority(Thread.MIN_PRIORITY);

        threadA.start();
        threadB.start();
    }
}
