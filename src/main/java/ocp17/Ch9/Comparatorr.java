package ocp17.Ch9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparatorr {

}

class Duck implements Comparable<Duck> {
    private String name;
    private int weight;
    // Assume getters/setters/constructors provided

    public String toString() {
        return name;
    }

    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
        Comparator<Duck> byWeight = new Comparator<Duck>() {
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };
        var ducks = new ArrayList<Duck>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]
        Collections.sort(ducks, byWeight);

        Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck> byWeight = Comparator.comparing(Duck::getWeight);

        var byWeight = new Comparator<Duck>() { // DOES NOT COMPILE
            public int compareTo(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };

        Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies) .thenComparingInt(Squirrel::getWeight);
        var c = Comparator.comparing(Squirrel::getSpecies).reversed();
    }
}

class Squirrel {
    private int weight;
    private String species;
    // Assume getters/setters/constructors provided
}

class MultiFieldComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        int result = s1.getSpecies().compareTo(s2.getSpecies());
        if (result != 0)
            return result;
        return s1.getWeight() - s2.getWeight();
    }
}