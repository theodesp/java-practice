import java.io.FileReader;
import java.io.IOException;


public class CheckedExceptions {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("src/main/java/Conversion.java");
            file = null;
            file.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
