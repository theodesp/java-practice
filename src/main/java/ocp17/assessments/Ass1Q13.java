import java.util.*;

public class Ass1Q13 {
    public static void main(String[] args) {
        //Set<? extends RuntimeException> mySet3 = new HashSet<? extends RuntimeException>(); // Error: Cannot instantiate the type HashSet<? extends RuntimeException>
        // Set<? extends RuntimeException> mySet = new HashSet<Exception>(); // Error: Exception cannot convert to RuntimeException
        Set<? extends RuntimeException> mySet = new TreeSet<RuntimeException>(); // works
        Set<? extends RuntimeException> mySet2 = new TreeSet<NullPointerException>(); // works
    }
}