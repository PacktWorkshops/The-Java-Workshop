/**
 * <H1>WordTool</H1>
 * A class to perform calculations about text.
 *
 * @author Joe Smith
 * @version 0.1
 * @since 20190305
 */
public class WordTool {

    WordTool() {};

    /**
     * <h2>wordCount</h2>
     * returns the amount of words in a text, takes a string as parameter
     *
     * @param s
     * @return int
     */
    public int wordCount ( String s ) {
        int count = 0;  // variable to count words

        // if the entry is empty or is null, count is zero
        // therefore we evaluate it only otherwise
        if ( !(s == null || s.isEmpty()) ) {
            // use the split method from the String class to
            // separate the words having the whitespace as separator
            String[] w = s.split("\\s+");
            count = w.length;
        }

        return count;
    }

    /**
     * <h2>symbolCount</h2>
     * returns the amount of symbols in a string with or without counting spaces
     *
     * @param s
     * @param withSpaces
     * @return int
     */
    public int symbolCount ( String s, boolean withSpaces ) {
        int count = 0;  // variable to count symbols

        // if the entry is empty or is null, count is zero
        // therefore we evaluate it only otherwise
        if ( !(s == null || s.isEmpty()) ) {
            if (withSpaces) {
                // with whitespaces return the full length
                count = s.length();
            } else {
                // without whitespaces, eliminate whitespaces
                // and get the length on the fly
                count = s.replace(" ", "").length();
            }
        }

        return count;
    }

    /**
     * <h2>getFrequency</h2>
     * returns the amount of occurrences of a symbol in a strint
     *
     * @param s
     * @param c
     * @return int
     */
    public int getFrequency ( String s, char c ) {
        int count = 0;

        // if the entry is empty or is null, count is zero
        // therefore we evaluate it only otherwise
        if ( !(s == null || s.isEmpty()) ) {
            count = s.length() - s.replace(Character.toString(c), "").length();
        }

        return count;
    }

    /**
     * <h2>main</h2>
     * uses an example string to demonstrate how the class works
     *
     * @param args
     */
    public static void main(String[] args) {
        WordTool wt = new WordTool();
	    String text = "The river carried the memories from her childhood.";
	    char search = 'e';

	    System.out.println( "Analysing the text: \n" + text );
        System.out.println( "Total words: " + wt.wordCount(text) );
        System.out.println( "Total symbols (w. spaces): " + wt.symbolCount(text, true) );
        System.out.println( "Total symbols (wo. spaces): " + wt.symbolCount(text, false) );
        System.out.println( "Total amount of " + search + ": " + wt.getFrequency(text, search) );
    }
}
