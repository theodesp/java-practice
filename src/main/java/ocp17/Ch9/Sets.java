package ocp17.Ch9;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        Set<Character> letters = Set.of('z', 'o', 'o'); 
        Set<Character> copy = Set.copyOf(letters);
        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66);
        boolean b2 = set.add(10);
        boolean b3 = set.add(66);
        boolean b4 = set.add(8);
        set.forEach(System.out::println);
    }

    void treeSet() {
        Set<Integer> set = new TreeSet<>();
        boolean b1 = set.add(66); // true
        boolean b2 = set.add(10); // true
        boolean b3 = set.add(66); // false
        boolean b4 = set.add(8); // true
        set.forEach(System.out::println);
    }
}
