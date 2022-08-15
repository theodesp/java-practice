package ocp17.Ch5.access.duck;

public class MotherDuck {
    String noise = "quack";

    void quack() {
        System.out.print(noise); // package access is ok
    }
}
