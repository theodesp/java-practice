package ocp17.Ch8;

import java.util.*;

public class Lambdas {

}

record Animal(String species, boolean canHop, boolean canSwim) {
}

interface CheckTrait {
    boolean test(Animal a);
}

class CheckIfHopper implements CheckTrait {
    public boolean test(Animal a) {
        return a.canHop();
    }
}

class TraditionalSearch {
    public static void main(String[] args) {
        // list of animals
        var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));


        // pass class that does check
        print(animals, new CheckIfHopper());
        print(animals, a -> a.canHop());
        print(animals, a -> a.canSwim());
        print(animals, a -> !a.canSwim());

        var invalid = (Animal a) -> a.canHop(); // DOES NOT COMPILE There’s not enough context to determine the functional interface
        CheckTrait valid = (Animal a) -> a.canHop();
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            // General check
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
        System.out.println();
    }
}
