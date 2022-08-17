package ocp17.Ch6;

public class Initializing {
    static {
        System.out.print("A");
    }
}

class Hippo extends Initializing {
    public static void main(String[] grass) {
        System.out.print("C");
        new Hippo();
        new Hippo();
        new Hippo();
    }

    static {
        System.out.print("B");
    }
}

class ZooTickets {
    private String name = "BestZoo";
    {
        System.out.print(name + "-");
    }
    private static int COUNT = 0;
    static {
        System.out.print(COUNT + "-");
    }
    static {
        COUNT += 10;
        System.out.print(COUNT + "-");
    }

    public ZooTickets() {
        System.out.print("z-");
    }

    public static void main(String... patrons) {
        new ZooTickets(); // 0-10-BestZoo-z-
    }
}

class GiraffeFamily {
    static {
        System.out.print("A");
    }
    {
        System.out.print("B");
    }

    public GiraffeFamily(String name) {
        this(1);
        System.out.print("C");
    }

    public GiraffeFamily() {
        System.out.print("D");
    }

    public GiraffeFamily(int stripes) {
        System.out.print("E");
    }
}

class Okapi extends GiraffeFamily {
    static {
        System.out.print("F");
    }

    public Okapi(int stripes) {
        super("sugar");
        System.out.print("G");
    }
    { System.out.print("H"); }
    public static void main(String[] grass) {
        new Okapi(1); // A F B E C H G

        System.out.println();
        new Okapi(2); // B E C H G
    }

}