package ocp17.Ch5.access.swan;
import ocp17.Ch5.access.duck.MotherDuck;
public class BadCygnet {
    public void makeNoise() {
        var duck = new MotherDuck();
        duck.quack(); // DOES NOT COMPILE
        System.out.print(duck.noise); // DOES NOT COMPILE
    }
}
