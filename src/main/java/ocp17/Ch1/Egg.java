package ocp17.Ch1;

public class Egg {
    public Egg() { 
        number = 5;
    }
    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number); // Prints 5 as the class block is defined later on
        System.out.println(egg.getNumber()); // Prints 5
    }

    private int number = 3;
    { number = 4; } // tricky. This gets called after the constructor is used

    public int getNumber() { 
        return number; 
    }
}
