package ocp17.Ch5.access.inland;
import ocp17.Ch5.access.shore.Bird;

public class BirdWatcherFromAfar {
    public void watchBird() {
        Bird bird = new Bird();
        bird.floatInWater(); // DOES NOT COMPILE
        System.out.print(bird.text); // DOES NOT COMPILE
    }
}
