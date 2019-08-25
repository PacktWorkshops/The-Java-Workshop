public class Example01 {
     public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Processors: " + runtime.availableProcessors());
        System.out.println("Total memory: " + runtime.totalMemory());
        System.out.println("Free memory: " + runtime.freeMemory());
    }
}
