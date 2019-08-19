import java.util.*;

public class Example20 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        Set setOfKeys;
        String key;

        properties.put("OS", "Ubuntu Linux");
        properties.put("version", "18.04");
        properties.put("language", "English (UK)");

        // iterate through the map
        setOfKeys = properties.keySet();
        Iterator iterator = setOfKeys.iterator();

        while(iterator.hasNext())
        {
            key = (String)iterator.next();
            System.out.println(key +
                    " = " + properties.getProperty(key));
        }
        System.out.println();

        // looking for URL that not in list
        String value = properties.getProperty("keyboard layout", "not found");

        System.out.println("keyboard layout = " + value);
     }
}
