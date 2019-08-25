class MyOwnThread implements Runnable {
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + "running");
    }
}

public class Example03 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyOwnThread());
        threadA.setName("A");

        Thread threadB = new Thread(new MyOwnThread());
        threadB.setName("B");

        threadA.start();
        threadB.start();
    }
}
