import java.util.*;

public class Activity02 {

    public static void main(String[] args) {
        List <Double> numbers = new ArrayList <Double> ();

        // random creates a number between 0 and 1
        // round removes the decimal
        // finally we cast it to long
        long numNodes = (long) Math.round(Math.random() * 10000);

        System.out.println("Total amount of numbers: " + numNodes);

        // create random numbers between 0 and 100
        for (int i = 0; i < numNodes; i++) {
            numbers.add(Math.random() * 100);
        }

        // create an iterator to look through the data
        Iterator iterator = numbers.iterator();

        Double average = 0.0;
        while(iterator.hasNext()) {
            average += (Double) iterator.next() / numNodes;
        }

        // print out the average
        System.out.println("Average: " + average);
    }
}
