package ocp17.Ch1;

public class Chick {
    public Chick() {
        System.out.println("in constructor");
     }

    public void Chick() { } // NOT A CONSTRUCTOR but works
    public static void main(String args[]) {
        new Chick().Chick();
    }
}
