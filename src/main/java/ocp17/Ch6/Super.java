package ocp17.Ch6;

public class Super extends Reptile {
    protected int speed = 20;

    public int getSpeed() {
        // return super.speed; // Causes the program to now print 10
        return speed;
    }

    public static void main(String[] data) {
        var croc = new Super();
        System.out.println(croc.getSpeed()); // 20
    }
}

class Reptile {
    protected int speed = 10;
}

class Insect {
    protected int numberOfLegs = 4;
    String label = "buggy";
}

public class Beetle extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;

    public void printData() {
        System.out.println(this.label);
        System.out.println(super.label);
        System.out.println(this.age);
        System.out.println(super.age); // DOES NOT COMPILE there is no age in Insect
        System.out.println(numberOfLegs);
    }
}