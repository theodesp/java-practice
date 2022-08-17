package ocp17.Ch6;

public class HiddenStatic {

}

class Bear {
    public static void eat() {
        System.out.println("Bear is eating");
    }

    public static void sneeze() {
        System.out.println("Bear is sneezing");
    }

    public void hibernate() {
        System.out.println("Bear is hibernating");
    }

    public static void laugh() {
        System.out.println("Bear is laughing");
    }
}

class SunBear extends Bear {
    public void sneeze() { // DOES NOT COMPILE an instance method cannot override the static method
        System.out.println("Sun Bear sneezes quietly");
    }

    public static void hibernate() { // DOES NOT COMPILE static method cannot hide the instance method
        System.out.println("Sun Bear is going to sleep");
    }

    protected static void laugh() { // DOES NOT COMPILE Cannot reduce the visibility of the inherited method
        System.out.println("Sun Bear is laughing");
    }
}

class Panda extends Bear {
    public static void eat() { // hidden
        System.out.println("Panda is chewing");
    }

    public static void main(String[] args) {
        eat();
    }
}
