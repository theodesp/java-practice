package ocp17.Ch9;

import java.util.*;
import java.util.Collection.*;

public class Collectionss {
    public static void main(String[] args) {
        Map<Long, List<Integer>> mapLists = new HashMap<Long, List<Integer>>();
        List<> list = new ArrayList<Integer>(); // DOES NOT COMPILE
    }

    void adding() {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow"));

        Collection<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow")); // true
        System.out.println(set.add("Sparrow")); // false
    }

    void remove() {
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.remove("cardinal")); // false
        System.out.println(birds.remove("hawk")); // true
    }

    void counting() {
        Collection<String> birds = new ArrayList<>();
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());
        birds.add("hawk");
        birds.add("hawk");
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());
    }

    void clear() {
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk");
        birds.add("hawk");
        System.out.println(birds.isEmpty());
        System.out.println(birds.size());
        birds.clear(); // []
        System.out.println(birds.isEmpty()); // true
        System.out.println(birds.size()); // 0
    }

    void check() {
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        System.out.println(birds.contains("hawk")); // true
        System.out.println(birds.contains("robin")); // false
    }

    void removing() {
        Collection<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list); // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list); // [Magician]
    }

    void iterating() {
        Collection<String> cats = List.of("Annie", "Ripley");
        cats.forEach(System.out::println);
        cats.forEach(c -> System.out.println(c));
    }

    void equality() {
        var list1 = List.of(1, 2);
        var list2 = List.of(2, 1);
        var set1 = Set.of(1, 2);
        var set2 = Set.of(2, 1);
        System.out.println(list1.equals(list2)); // false
        System.out.println(set1.equals(set2)); // true
        System.out.println(list1.equals(set1)); // false
    }

    void factoryMethods() {
        Arrays.asList(1,2,3); //Returns fixed size list backed by an array
        List.of(1,2,3); //Returns immutable list
        List.copyOf(List.of(1,2,3)); // Returns immutable list with copy of original collection’s values
    }
}

class InvalidUse {
    void use(List<> data) {
    }
}