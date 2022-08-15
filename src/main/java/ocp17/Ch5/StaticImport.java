package ocp17.Ch5;
import java.util.List;
// import java.util.Arrays;
import static java.util.Arrays; // DOES NOT COMPILE
static import java.util.Arrays.*; // DOES NOT COMPILE
import static java.util.Arrays.asList; // static import
import static java.util.Arrays.*;

public class StaticImport {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two"); // DOES NOT COMPILE
        List<String> list2 = asList("one", "two");
    }
}
