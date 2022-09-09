package ocp17.Ch9;
import java.util.*;
public class Sorting {

}

class SortRabbits {
    static record Rabbit(int id) {
    }

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(3));
        rabbits.add(new Rabbit(1));
        Collections.sort(rabbits); // DOES NOT COMPILE

        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);
        System.out.println(rabbits); // [Rabbit[id=1], Rabbit[id=3]]
        Collections.reverse(rabbits);
        System.out.println(rabbits); // [Rabbit[id=3], Rabbit[id=1]]

        List<Integer> list = Arrays.asList(6,9,1,8);
        Collections.sort(list); // [1, 6, 8, 9]
        System.out.println(Collections.binarySearch(list, 6)); // 1
    }
}

class UseTreeSet {
    static class Rabbit{ int id; }
    public static void main(String[] args) {
        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddles"));

        Set<Rabbit> rabbits = new TreeSet<>();
        rabbits.add(new Rabbit()); // ClassCastException

        Set<Rabbit> rabbits = new TreeSet<>((r1, r2) -> r1.id - r2.id);
        rabbits.add(new Rabbit());

        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies);
        bunnies.sort((b1, b2) -> b1.compareTo(b2));
        System.out.println(bunnies);
    }
}