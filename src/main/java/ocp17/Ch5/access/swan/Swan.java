package ocp17.Ch5.access.swan;

import ocp17.Ch5.access.shore.Bird;

public class Swan extends Bird {
    public void swim() {
        floatInWater(); // protected access is ok

        System.out.print(text); // protected access is ok
    }
    public void helpOtherSwanSwim() {
        Swan other = new Swan(); // subclass access to superclass
        other.floatInWater();
        System.out.print(other.text); // subclass access to superclass
    }

    public void helpOtherBirdSwim() {
        Bird other = new Bird();
        other.floatInWater(); // DOES NOT COMPILE
        System.out.print(other.text); // DOES NOT COMPILE
    }
}
