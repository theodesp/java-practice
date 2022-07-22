import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Ass1Q3 {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(); 
        IntStream.range(0,100).parallel().forEach(s -> data.add(s)); // We can remove the parallel call to make it work 
        System.out.println(data.size()); // will not print 100 all the time as the operation is not synchronized
    }
}
