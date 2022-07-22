import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Athlete {
    public String name;

    public static void athlete() {
        String athleteName = "1";
        double athleteSpeed;
        int athleteAge;

        System.out.println(athleteName);
    }

    public static void main(String args[]) {
        athlete();

        int[] numbers = {1,2,3};
        System.out.println(Arrays.toString(numbers));
        int[] sNumbers = IntStream.range(0, 3).toArray();
        int[] a = IntStream.iterate(10, x -> x <= 100, x -> x + 10).toArray();
        var sb = new StringBuilder("Abc");
        var sbb = new StringBuffer("Abc");
    }
}
