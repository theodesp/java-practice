import java.util.List;

public class NthOddElement {
    /*
     * Write a method that returns the nth odd element of a list.
     * If the index of the element exceeds the list size then return -1.
     */
    int getElement(List<Integer> list, int n) {
        var index = 2 * (n-1);
        if (index > list.size() - 1) {
            return -1;
        }
        return list.get(index);
    }
}
