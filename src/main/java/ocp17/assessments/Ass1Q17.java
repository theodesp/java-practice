
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;


public class Ass1Q17 {
    public static void main(String[] args) {
        Path path1 = Paths.get("./howdee.dat");
        try {
            System.out.println(Files.mismatch(path1, Paths.get("./birds.dat"))); // prints 1 as 
        } catch  (Exception e) {
            System.out.println(e);
        }
    }
}
