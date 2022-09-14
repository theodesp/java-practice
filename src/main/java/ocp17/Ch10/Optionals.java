package ocp17.Ch10;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average()); // Optional.empty

        Optional<Double> opt = average(90, 100);
        if (opt.isPresent())
            System.out.println(opt.get()); // 95.0
        //Optional o = (value == null) ? Optional.empty() : Optional.of(value);

        Optional<Double> opt2 = average(90, 100);
        opt2.ifPresent(System.out::println);
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElseGet(() -> Math.random()));
        System.out.println(opt.orElseThrow());
        System.out.println(opt.orElseThrow(() -> new IllegalStateException()));
        System.out.println(opt.orElseGet(() -> new IllegalStateException())); // DOES NOT COMPILE
    }

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)
            return Optional.empty();
        int sum = 0;
        for (int score : scores)
            sum += score;
        return Optional.of((double) sum / scores.length);
    }
}
