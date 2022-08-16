package ocp17.Ch6;

public class Subclasses {

}

class BigCat {
    protected double size;
}

class Jaguar extends BigCat {
    public Jaguar() {
        size = 10.2;
    }

    public void printDetails() {
        System.out.print(size);
    }
}

class Spider {
    public void printDetails() {
    System.out.println(size); // DOES NOT COMPILE }
}

class Mammal {}

public final class Rhinoceros extends Mammal {}

public class Clara extends Rhinoceros {} // DOES NOT COMPILE

public class Zoo extends java.lang.Object { } // every class extends java.lang.Object
