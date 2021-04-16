import java.util.List;
import java.util.stream.Collectors;

public class FilterStringsWithA {
    // Given a list of strings, write a method that returns a list of all strings that start
    // with the letter 'a' (lower case) and have exactly 3 letters.
    List<String> search(List<String> list) {
        return list.stream()
                .filter(s -> s.startsWith("a"))
                .filter(s -> (s.length() == 3))
                .collect(Collectors.toList());
    }
}
