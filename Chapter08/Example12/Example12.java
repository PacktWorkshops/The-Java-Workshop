import java.io.FileInputStream;
import java.io.IOException;

public class Example12 {
    public static void main(String[] args) throws IOException {
        FileInputStream inStream = null;

        try {
            inStream = new FileInputStream(
                     System.getProperty("user.home") + "/javaTemp/temp.txt");
            int c;
            while ((c = inStream.read()) != -1) {
                System.out.print(c);
            }
        } finally {
            if (inStream != null) {
                inStream.close();
            }
        }
    }
}
