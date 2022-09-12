package ocp17.Ch9;

import java.util.*;

public class GenericExamples {
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<A>();

        List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
        List<? super B> list5 = new ArrayList<A>();
        List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
    }

    <T> T first(List<? extends T> list) {
        return list.get(0);
    }

    <T> <? extends T> second(List<? extends T> list) { // DOES NOT COMPILE   return type isn’t actually a type.
        return list.get(0);
    }

    <B extends A> B third(List<B> list) {
        return new B(); // DOES NOT COMPILE B hides class B
    }

    <X> void fifth(List<X super B> list) { // DOES NOT COMPILE }

}

class A {
}

class B extends A {
}

class C extends B {
}