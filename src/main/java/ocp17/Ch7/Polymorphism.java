package ocp17.Ch7;

public class Polymorphism {

}

class Primate {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {
    public abstract boolean isTailStriped();
}

class Lemur extends Primate implements HasTail {
    public boolean isTailStriped() {
        return false;
    }

    public int age = 10;

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);
        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());
        Primate primate = lemur;
        System.out.println(primate.hasHair());

        HasTail hasTail2 = new Lemur();
        System.out.println(hasTail2.age); // DOES NOT COMPILE

        Primate primate2 = new Lemur();
        System.out.println(primate2.isTailStriped()); // DOES NOT COMPILE

        Lemur lemur4 = new Lemur();
        Primate primate3 = lemur4; // Implicit Cast to supertype
        Lemur lemur2 = (Lemur) primate; // Explicit Cast to subtype
        Lemur lemur3 = primate3; // DOES NOT COMPILE (missing cast)
    }
}

class Bird {
}

class Fish {
    public static void main(String[] args) {
        Fish fish = new Fish();
        Bird bird = (Bird) fish; // DOES NOT COMPILE
    }
}

interface Canine {
}

interface Dog {
}

class Wolf implements Canine {
}

class BadCasts {
    public static void main(String[] args) {
        Wolf wolfy = new Wolf();
        Dog badWolf = (Dog) wolfy; // Throws ClassCastException at runtime
    }

}

class Penguin {

    public int getHeight() {
        return 3;
    }

    public void printInfo() {
        System.out.print(this.getHeight());
    }
}

class EmperorPenguin extends Penguin {
    public int getHeight() {
        return 8;
    }

    public void printInfo() {
        System.out.print(super.getHeight());
    }

    public static void main(String[] fish) {
        new EmperorPenguin().printInfo();
    }
}

class Marsupial {
    protected int age = 2;

    public static boolean isBiped() {
        return false;
    }
}

class Kangaroo extends Marsupial {
    protected int age = 6;

    public static boolean isBiped() {
        return true;
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        Marsupial moey = joey;
        System.out.println(joey.isBiped());
        System.out.println(moey.isBiped());
        System.out.println(joey.age);
        System.out.println(moey.age);
    }
}