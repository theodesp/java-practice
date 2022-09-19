package ocp17.Ch10;

import java.util.stream.*;
import java.util.*;
import java.util.function.*;;

public class Streams {
    public static void main(String[] args) {
        Stream<String> empty = Stream.empty(); // count = 0
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3

        var list = List.of("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        Stream<Integer> oddNumberUnder100 = Stream.iterate(1, n -> n < 100, n -> n + 2); // UnaryOperator to get next
                                                                                         // value);
    }

    void terminalOps() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); // 3

        Stream<String> ss = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = ss.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println); // ape

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent()); // false

        // a stream can have only one terminal operation
        // Once a terminal operation has been run, the stream cannot be used against

        Stream<String> sss = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        sss.findAny().ifPresent(System.out::println); // monkey (usually)
        infinite.findAny().ifPresent(System.out::println); // chimp

        var list = List.of("monkey", "2", "chimp");
        Stream<String> infinite2 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred)); // true
        System.out.println(list.stream().allMatch(pred)); // false
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite2.anyMatch(pred)); // true

        Stream<String> apes = Stream.of("Monkey", "Gorilla", "Bonobo");
        apes.forEach(System.out::print); // MonkeyGorillaBonobo

        Stream<Integer> one = Stream.of(1);
        for (Integer i : one) {
        } // DOES NOT COMPILE

        var array = new String[] { "w", "o", "l", "f" };
        var result = "";
        for (var item : array)
            result = result + item;
        System.out.println(result); // wolf

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (sp, c) -> sp + c);
        System.out.println(word); // wolf

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        String word2 = stream.reduce("", String::concat);
        System.out.println(word2); // wolf

        Stream<Integer> stream3 = Stream.of(3, 5, 6);
        System.out.println(stream3.reduce(1, (a, b) -> a * b)); // 90

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);
        empty.reduce(op).ifPresent(System.out::println);
        oneElement.reduce(op).ifPresent(System.out::println);
        threeElements.reduce(op).ifPresent(System.out::println); // 90

        Stream<String> stream4 = Stream.of("w", "o", "l", "f!");
        int length = stream4.reduce(0, (i, sp) -> i + sp.length(), (a, b) -> a + b);
        System.out.println(length); // 5

    }

    void collecting() {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word); // wolf

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream2.collect(TreeSet::new,
                TreeSet::add,
                TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]

        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set2 = stream3.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2); // [f, l, o, w]

        Stream<String> stream4 = Stream.of("w", "o", "l", "f");
        Set<String> set3 = stream4.collect(Collectors.toSet());
        System.out.println(set3); // [f, w, l, o]
    }

    void streamOps() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m"))
                .forEach(System.out::print); // monkey

        Stream<String> ss = Stream.of("duck", "duck", "duck", "goose");
        ss.distinct()
                .forEach(System.out::print); // duckgoose

        Stream<Integer> sp = Stream.iterate(1, n -> n + 1);
        sp.skip(5)
                .limit(2).forEach(System.out::print); // 67

        Stream<String> sm = Stream.of("monkey", "gorilla", "bonobo");
        sm.map(String::length)
                .forEach(System.out::print); // 676

        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(m -> m.stream()).forEach(System.out::println);

        var one1 = Stream.of("Bonobo");
        var two2 = Stream.of("Mama Gorilla", "Baby Gorilla");
        Stream.concat(one1, two2).forEach(System.out::println);

        Stream<String> st = Stream.of("brown-", "bear-");
        st.sorted()
                .forEach(System.out::print); // bear-brown-
    }
}
