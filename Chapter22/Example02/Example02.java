class MyOwnThread implements Runnable {
    String name = "";

    MyOwnThread(String _name) {
        name = _name;
    }

    public void run() {
        System.out.println("Thread " + name + " running");
    }
}

public class Example02 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyOwnThread("A"));
        Thread threadB = new Thread(new MyOwnThread("B"));

        threadA.start();
        threadB.start();
    }
}
