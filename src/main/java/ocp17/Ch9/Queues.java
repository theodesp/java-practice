package ocp17.Ch9;

import java.util.*;
import java.util.function.*;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.peek());

        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        Map.of("key1", "value1", "key2", "value2");
        Map.ofEntries(
                Map.entry("key1", "value1"), Map.entry("key2", "value2"));

        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key : map.keySet())
            System.out.print(key + ","); // koala,giraffe,lion,

        Map<String, String> map = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key : map.keySet())
            System.out.print(key + ","); // giraffe,koala,lion,

        System.out.println(map.contains("lion")); // DOES NOT COMPILE
        System.out.println(map.containsKey("lion")); // true
        System.out.println(map.containsValue("lion")); // false
        System.out.println(map.size()); // 3
        map.clear();
        System.out.println(map.size()); // 0
        System.out.println(map.isEmpty()); // true

        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'a');
        map.put(2, 'b');
        map.put(3, 'c');
        map.forEach((k, v) -> System.out.println(v));
        map.values().forEach(System.out::println);
        map.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        Map<Character, String> map = new HashMap<>();
        map.put('x', "spot");
        System.out.println("X marks the " + map.get('x'));
        System.out.println("X marks the " + map.getOrDefault('x', ""));
        System.out.println("Y marks the " + map.get('y'));
        System.out.println("Y marks the " + map.getOrDefault('y', ""));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 4);
        Integer original = map.replace(2, 10); // 4
        System.out.println(map); // {1=2, 2=10}
        map.replaceAll((k, v) -> k + v);
        System.out.println(map); // {1=3, 2=12}

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);
        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");
        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
    }

    void merging() {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);
        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny); // Bus Tour
        System.out.println(tom); // Skyride

        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Sam", null);
        favorites.merge("Tom", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);
        System.out.println(favorites); // {Tom=Skyride, Sam=Skyride}

        BiFunction<String, String, String> mapper = (v1, v2) -> null;
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Bus Tour");
        favorites.merge("Jenny", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);
        System.out.println(favorites); // {Tom=Bus Tour, Sam=Skyride}

    }
}
