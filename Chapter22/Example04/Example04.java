class MyOwnThread implements Runnable {
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + "running");
        System.out.println("ID " + Thread.currentThread().getId());
        System.out.println("Priority " + Thread.currentThread().getPriority());
    }
}

public class Example04 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyOwnThread());
        threadA.setName("A");

        Thread threadB = new Thread(new MyOwnThread());
        threadB.setName("B");
        threadA.start();

        threadB.start();
    }
}
