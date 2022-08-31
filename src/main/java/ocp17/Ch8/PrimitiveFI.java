package ocp17.Ch8;

import java.util.function.*;

public class PrimitiveFI {
    public static void main(String[] args) {
        Boolean();

        ToDoubleFunction df;
        ToIntFunction ti;
        ToLongFunction tl;

        BinaryOperator<Integer> bo = (Integer a, Integer b) -> {
            Integer a = 0;
            return 5;
        }; // DOES NOT COMPILE

    }

    static void Boolean() {
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;
        System.out.println(b1.getAsBoolean()); // true
        System.out.println(b2.getAsBoolean()); // false
    }
}

class Crow {
    private String color;

    public void caw(String name) {
        String volume = "loudly";
        Consumer<String> consumer = s -> System.out.println(name + " says "
                + volume + " that she is " + color); // DOES NOT COMPILE volume not effectively final

        volume = "softly";
    }
}
