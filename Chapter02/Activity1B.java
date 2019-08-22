public class Activity1B {
    public static void main(String[] args) {
        int smallDiscount = 0;
        int mediumDiscount = 10;     // Percent
        int largeDiscount = 15;

        int mediumThreshold = 5;     // Kg
        int largeThreshold = 50;

        int purchaseAmount = 50;

        if (purchaseAmount >= largeThreshold) {

            System.out.println("You get a discount of " + largeDiscount + "%");

        } else if (purchaseAmount >= mediumThreshold) {

            System.out.println("You get a discount of " + mediumDiscount + "%");
        } else {
            // Sorry
            System.out.println("You get a discount of " + smallDiscount + "%");
        }
    }
}
