package ocp17.Ch6;

public class Initializing {
    static { System.out.print("A"); }
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