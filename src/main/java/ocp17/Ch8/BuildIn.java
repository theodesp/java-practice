package ocp17.Ch8;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * 
 */

@FunctionalInterface
interface Supplier<T> {
    T get();
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
    // omitted default method
}

@FunctionalInterface
interface BiConsumer<T, U> {
    void accept(T t, U u);
    // omitted default method
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
    // omitted default and static methods
}

@FunctionalInterface
interface BiPredicate<T, U> {
    boolean test(T t, U u);
    // omitted default methods
}

@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
    // omitted default and static methods
}

@FunctionalInterface
interface BiFunction<T, U, R> {
    R apply(T t, U u);
    // omitted default method
}

@FunctionalInterface
interface UnaryOperator<T> extends Function<T, T> {
    // omitted static method
}

@FunctionalInterface
interface BinaryOperator<T> extends BiFunction<T, T, T> {
    // omitted static methods
}

public class BuildIn {
    public static void main(String[] args) {
        supplier();
        consumer();
        predicate();
        function();
        operator();
    }

    static void supplier() {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println(d1); // 2022-02-20
        System.out.println(d2); // 2022-02-20

        Supplier<StringBuilder> sb1 = StringBuilder::new;
        Supplier<StringBuilder> sb2 = () -> new StringBuilder();

        System.out.println(sb1.get()); // Empty string
        System.out.println(sb2.get()); // Empty string
    }

    static void consumer() {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie"); // Annie
        c2.accept("Annie"); // Annie

        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);
        System.out.println(map); // {chicken=7, chick=1}
    }

    static void predicate() {
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test("")); // true
        System.out.println(p2.test("")); // true

        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(b1.test("chicken", "chick")); // true
        System.out.println(b2.test("chicken", "chick")); //
                                                         // true
    }

    static void function() {
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5

        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick
    }

    static void operator() {
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp")); // CHIRP
        System.out.println(u2.apply("chirp")); // CHIRP

        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(b1.apply("baby ", "chick")); // baby chick 
        System.out.println(b2.apply("baby ", "chick")); //
                                                        // baby chick
    }
}
