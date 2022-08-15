package ocp17.Ch5;

public class StaticData {
    String name;
    static String nameOfTallestPenguin;

    public static void main(String[] unused) {
        var p1 = new StaticData();
        p1.name = "Lilly";
        p1.nameOfTallestPenguin = "Lilly";
        var p2 = new StaticData();
        p2.name = "Willy";
        p2.nameOfTallestPenguin = "Willy";
        System.out.println(p1.name);
        System.out.println(p1.nameOfTallestPenguin);
        System.out.println(p2.name);
        System.out.println(p2.nameOfTallestPenguin);
    }
}

class Snake {
    public static long hiss = 2;
    public int total;
    public static int count;

    public static void main(String[] args) {
        Snake s = new Snake();
        System.out.println(s.hiss); // s is a Snake outputs 2
        s = null;
        System.out.println(s.hiss); // s is still a Snake outputs 2
        third(); // DOES NOT COMPILE
    }

    public void third() {
        System.out.print(hiss);
    }

    public static double average = total / count; // DOES NOT COMPILE
}

class ZooPen {
    private static final int NUM_BUCKETS = 45;
    private static final String[] treats = new String[10];

    public static void main(String[] args) {
        NUM_BUCKETS = 5; // DOES NOT COMPILE finas variable
        treats[0] = "popcorn"; // compiles
    }
}

class Panda {
    final static String name = "Ronda";
    static final int bamboo;
    static final double height; // DOES NOT COMPILE height might not have been initialized
    static { bamboo = 5;}
    }
