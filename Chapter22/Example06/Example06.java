class MyOwnThread implements Runnable {
    public void run() {
        String name = Thread.currentThread().getName();

        System.out.println(name + ": Thread " + name + " running");

        for (int i = 0; i < 3; i++)
            System.out.println(name + ": count: " + i);
    }
}

public class Example06 {
    public static void main(String[] args) throws InterruptedException{
        Thread threadA = new Thread(new MyOwnThread());
        threadA.setName("A");

        Thread threadB = new Thread(new MyOwnThread());
        threadB.setName("B");

        threadA.start();
        //threadA.join();

        threadB.start();
        //threadB.join();

        System.out.println("this is the end");
    }
}
