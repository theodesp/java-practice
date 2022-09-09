package ocp17.Ch9;

import java.util.*;

public class Lists {
    public static void main(String[] args) {
        var linked1 = new LinkedList<String>();
        var linked2 = new LinkedList<String>(linked1);

        var list1 = new ArrayList<String>();
        var list2 = new ArrayList<String>(list1);
        var list3 = new ArrayList<String>(10);

        var list = new ArrayList<>(); // compiles ArrayList<Object>
    }

    void listMethods() {
        List<String> list = new ArrayList<>();
        list.add("SD");
        list.add(0, "NY");
        list.set(1, "FL");
        System.out.println(list.get(0));
        list.remove("NY");
        list.remove(0);
        list.set(0, "?"); // IndexOutOfBoundsException

        var numbers = Arrays.asList(1, 2, 3);
        numbers.replaceAll(x -> x * 2);
        System.out.println(numbers); // [2, 4, 6]
    }

    void convert() {
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();
        String[] stringArray = list.toArray(new String[0]);
        list.clear();
        System.out.println(objectArray.length); // 2
        System.out.println(stringArray.length); // 2
    }
}
