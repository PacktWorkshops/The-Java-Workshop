class MyOwnThread extends Thread {
    String name = "";

    MyOwnThread(String _name) {
        name = _name;
    }

    public void run() {
        System.out.println("Thread " + name + " running");
    }
}

public class Example01 {
    public static void main(String[] args) {
        MyOwnThread threadA = new MyOwnThread("A");
        MyOwnThread threadB = new MyOwnThread("B");

        threadA.start();
        threadB.start();
    }
}
