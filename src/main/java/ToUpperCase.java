import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCase {
    // Write a method that converts all strings in a list to their upper case.
    List<String> upperCase(List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
