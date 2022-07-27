package ocp17.Ch1;

public class Egg {
    public Egg() { 
        number = 5;
    }
    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number); // Prints 5 as the class block is defined later on
    }

    private int number = 3;
    { number = 4; }
}
