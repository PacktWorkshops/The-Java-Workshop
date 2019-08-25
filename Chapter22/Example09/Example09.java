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
