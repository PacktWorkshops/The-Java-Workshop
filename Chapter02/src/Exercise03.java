public class Exercise03 {
    public static void main(String[] args) {
        int speed = 55;
        int maxSpeed = 60;

        // Nested if statements.
        if (speed <= maxSpeed) {
            System.out.println("Speed is less than or equal to the max. speed limit");

            if (speed < maxSpeed) {
                System.out.println("Speed is less than the max. speed limit");
            }
        }
    }
}
