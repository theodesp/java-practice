package ocp17.Ch6;

public class AbstractClasses {

}

abstract class Canine {
    public abstract String getSound();

    public void bark() {
        System.out.println(getSound());
    }
}

public class ArcticFox extends Canine {
} // DOES NOT COMPILE

public class Direwolf extends Canine { // DOES NOT COMPILE
    public abstract rest();

    public String getSound() {
        return "Roof!";
    }
}

class Jackal extends Canine {
    public abstract String name; // DOES NOT COMPILE variables cannot be marked abstract

    public String getSound() {
        return "Laugh";
    }
}

class Wolf extends Canine {
    public String getSound() {
        return "Wooooooof!";
    }
}

class Fox extends Canine {
    public String getSound() {
        return "Squeak!"; }
}}

class Coyote extends Canine {
    public String getSound() {
        return "Roar!";
    }

}}

    class abstract Bear{ // DOES NOT COMPILE
    public int

    abstract howl(); // DOES NOT COMPILE
}

abstract class Turtle {
    public abstract long eat() // DOES NOT COMPILE missing semicolon

    public abstract void swim() {}; // DOES NOT COMPILE abstract has body

    public abstract int getAge() {return 10; } // DOES NOT COMPILE abstract has body

    public abstract void sleep; // DOES NOT COMPILE no abstract variables

    public void goInShell(); // DOES NOT COMPILE no body
}

abstract final class Tortoise { // DOES NOT COMPILE The class Tortoise can be either abstract or final, not both
    public abstract final void walk(); // DOES NOT COMPILE
}

abstract class Whale {
    private abstract void sing(); // DOES NOT COMPILE cannot use abstract private methods
}

abstract class Hippopotamus {
    abstract static void swim(); // DOES NOT COMPILE cannot use abstract static methods
}