public class Activity1 {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Error. Usage is:");
            System.err.println("Activity1 systolic diastolic");
            System.exit(-1);
        }

        int systolic = Integer.parseInt(args[0]);
        int diastolic = Integer.parseInt(args[1]);

        System.out.print(systolic + "/" + diastolic + " is ");
        if ((systolic <= 90) || (diastolic <= 60)) {
            System.out.println("low blood pressure.");
        } else if ((systolic >= 140) || (diastolic >= 90)) {
            System.out.println("high blood pressure.");
        } else if ((systolic >= 120) || (diastolic >= 80)) {
            System.out.println("pre-high blood pressure.");
        } else {
            System.out.println("ideal blood pressure.");
        }
    }
}
