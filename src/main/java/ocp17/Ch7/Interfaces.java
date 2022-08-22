package ocp17.Ch7;

public class Interfaces {

}

abstract interface WalksOnTwoLegs {
}

class Biped {
    public static void main(String[] args) {
        var e = new WalksOnTwoLegs(); // DOES NOT COMPILE
    }
}

final interface WalksOnEightLegs {
} // DOES NOT COMPILE

interface Climb {
    Number getSpeed(int age);
}

class FieldMouse implements Climb {
    public Float getSpeed(int age) {
        return 11f;
    };
}

interface Nocturnal {
}

interface HasBigEyes extends Nocturnal {
}

public interface CanFly {
    public void flap();
}

interface HasBigEyes2 extends Nocturnal, CanFly {
}

interface HasTail {
    public int getTailLength();
}

interface HasWhiskers {
    public int getNumberOfWhiskers();
}

abstract class HarborSeal implements HasTail, HasWhiskers {
}

class CommonSeal extends HarborSeal {
} // DOES NOT COMPILE

interface CanRun {
}

class Cheetah extends CanRun {
} // DOES NOT COMPILE

class Hyena {
}

interface HasFur extends Hyena {
} // DOES NOT COMPILE

interface Herbivore {
    public void eatPlants();
}

interface Omnivore {
    public int eatPlants();
}

class Tiger implements Herbivore, Omnivore {
} // DOES NOT COMPILE

interface Soar {
    int MAX_HEIGHT = 10;
    final static boolean UNDERWATER = true;

    void fly(int speed);

    abstract void takeoff();

    public abstract double dive();
}

interface Dance {
    private int count = 4; // DOES NOT COMPILE private variables not allowed

    protected void step(); // DOES NOT COMPILE protected not allowed
}

interface Poodle {
    void play();
}

public class Georgette implements Poodle {
    void play() {
    } // DOES NOT COMPILE - play() is public in Poodle. Cannot reduce the visibility
      // of the inherited method
}

interface IsColdBlooded {
    boolean hasScales();

    default double getTemperature() {
        return 10.0;
    }
}

class Snake implements IsColdBlooded {
    public boolean hasScales() { // Required override
        return true;
    }

    public double getTemperature() { // Optional override
        return 12;
    }
}

interface Carnivore {
    public default void eatMeat(); // DOES NOT COMPILE need to provide body

    public int getRequiredFoodAmount() { // DOES NOT COMPILE needs default keyword
    return 13; }
}

interface Walk {
    public default int getSpeed() {
        return 5;
    }
}

interface Run {
    public default int getSpeed() {
        return 10;
    }
}
class Cat implements Walk, Run {
    public int getWalkSpeed() { return Walk.super.getSpeed();
    }}
} // DOES NOT COMPILE