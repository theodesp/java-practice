package ocp17.Ch9;

import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BoundedWildcards {
    public static void main(String[] args) {
        List<?> a = new ArrayList<String>();
        List<? extends Exception> b = new ArrayList<RuntimeException>();
        List<? super Exception> c = new ArrayList<Object>();

        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords); // DOES NOT COMPILE we cannot assign a List<String> to a List<Object>
        printList2(keywords); // works

        ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
        List<? extends Number> list2 = new ArrayList<Integer>(); // works
        List<? extends Bird> birds = new ArrayList<Bird>();
        birds.add(new Sparrow()); // DOES NOT COMPILE // The list becomes logically immutable and therefore cannot
                                  // be modified
        birds.add(new Bird()); // DOES NOT COMPILE

        List<? super IOException> exceptions = new ArrayList<Exception>();
        exceptions.add(new Exception()); // DOES NOT COMPILE  we could have a List<IOException>, and an Exception object wouldn’t fit in there.
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }

    public static void printList(List<Object> list) {
        for (Object x : list)
            System.out.println(x);
    }

    public static void printList2(List<?> list) {
        for (Object x : list)
            System.out.println(x);
    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

    static class Sparrow extends Bird {
    }

    static class Bird {
    }

    private void anyFlyer(List<Flyer> flyer) {
    }

    private void groupOfFlyers(List<? extends Flyer> flyer) {
    }

    public static void addSound(List<? super String> list) {
        list.add("quack");
    }
}

interface Flyer {
    void fly();
}

class HangGlider implements Flyer {
    public void fly() {
    }
}

class Goose implements Flyer {
    public void fly() {
    }
}