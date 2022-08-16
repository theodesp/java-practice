package ocp17.Ch6;

public class Constructors {
    public Constructors() {
        System.out.print("hop");
    }
}

class Bunny {
    public bunny() {} // DOES NOT COMPILE

    public void Bunny() {
    }
}

class Bonobo {
    public Bonobo(var food) { // DOES NOT COMPILE var is not allowed here
    }
}

class Turtle {
    private String name;

    public Turtle() {
        name = "John Doe";
    }

    public Turtle(int age) {
    }

    public Turtle(long age) {
    }

    public Turtle(String newName, String... favoriteFoods) {
        name = newName;
    }
}

class Hamster {
    private String color;
    private int weight;

    public Hamster(int weight, String color) { // First constructor
        this.weight = weight;
        this.color = color;
    }

    public Hamster(int weight) { // Second constructor
        
        this.weight = weight;
        this()// DOES NOT COMPILE constructor call must be the first call in this constructor call
        // this(weight, "brown") better
        color = "brown";
    }
}

class Gopher {
    public Gopher(int dugHoles) {
        this(5); // DOES NOT COMPILE recursive call to itself
    }
}

class Animal {
    private int age;

    public Animal(int age) {
        super(); // Refers to constructor in java.lang.Object
        this.age = age;
    }
}

class Zebra extends Animal {
    public Zebra(int age) {
        super(age); // Refers to constructor in Animal
    }

    public Zebra() {
        this(4); // Refers to constructor in Zebra with int argument
    }
}

class Zoo {
    public Zoo() {
        System.out.println("Zoo created");
        super(); // DOES NOT COMPILE
    }
}