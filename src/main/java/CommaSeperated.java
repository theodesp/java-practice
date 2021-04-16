import java.util.List;
import java.util.stream.Collectors;

public class CommaSeperated {
    // Write a method that returns a comma-separated string based on a given list of integers. Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
    // For example, if the input list is (3,44), the output should be 'o3,e44'.
    String getString(List<Integer> list) {
        return list.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(Collectors.joining(","));
    }
}
