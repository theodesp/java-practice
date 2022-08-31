package ocp17.Ch8;

public class FunctionalInterfaces {

}

@FunctionalInterface
interface Sprint {
    public void sprint(int speed);
}

class Tiger implements Sprint {
    public void sprint(int speed) {
        System.out.println("Animal is sprinting fast! " + speed);
    }
}

@FunctionalInterface
interface Dance { // DOES NOT COMPILE
    void move();

    void rest();
}

interface Sleep {
    private void snore() {
    }

    default int getZzz() {
        return 1;
    }
}

interface Climb {
    void reach();

    default void fall() {
    }

    static int getBackUp() {
        return 100;
    }

    private static boolean checkHeight() {
        return true;
    }
}

@FunctionalInterface
interface Soar {
    abstract String toString(); // NOT a functional interface toString is a public method implemented in Object,
}

interface Invalid {
    abstract int toString(); // invalid 
}

interface Dive {
    String toString(); // does not count against the single abstract method test 

    public boolean equals(Object o); // does not count against the single abstract method test 

    public abstract int hashCode(); // does not count against the single abstract method test 

    public void dive(); // this method makes Dive a functional interface
}

interface Hibernate {
    String toString();

    public boolean equals(Hibernate o); // this method breaks Hibernate functional interface

    public abstract int hashCode();

    public void rest();
}

interface LearnToSpeak {
    void speak(String sound);
}

class DuckHelper {
    public static void teacher(String name, LearnToSpeak trainer) {
        // Exercise patience (omitted)
        trainer.speak(name);
    }
}

class Duckling {
    public static void makeSound(String sound) {
        LearnToSpeak learner = s -> System.out.println(s);
        LearnToSpeak learner2 = System.out::println;
        DuckHelper.teacher(sound, learner);

        Converter methodRef = Math::round;
        Converter lambda = x -> Math.round(x);

        System.out.println(methodRef.round(100.1)); // 100

        var str = "Zoo";
        StringStart methodRef2 = str::startsWith;
        StringStart lambda2 = s -> str.startsWith(s);
        System.out.println(methodRef2.beginningCheck("A")); // false

        var str3 = "";
        StringChecker methodRef3 = str3::isEmpty;
        StringChecker lambda3StringChecker = () -> str3.isEmpty();
        System.out.print(methodRef3.check()); // true

        StringChecker lambda3 = () -> str.startsWith("Zoo");
        StringChecker methodReference = str::startsWith; // DOES NOT COMPILE
        StringChecker methodReference2 = str::startsWith("Zoo"); // DOES NOT COMPILE
    }

    public static void main(String[] args) {
        StringParameterChecker methodRef = String::isEmpty;
        StringParameterChecker lambda = s -> s.isEmpty();
        System.out.println(methodRef.check("Zoo")); // false

        StringTwoParameterChecker methodRef2 = String::startsWith;
        StringTwoParameterChecker lambda2 = (s, p) -> s.startsWith(p);

        System.out.println(methodRef2.check("Zoo", "A")); // false
    }
}

interface Converter {
    long round(double num);
}

interface StringStart {
    boolean beginningCheck(String prefix);
}

interface StringChecker {
    boolean check();
}

interface StringParameterChecker {
    boolean check(String text);
}

interface StringTwoParameterChecker {
    boolean check(String text, String prefix);
}