package ocp17.Ch5.access.duck;

public class BadDuckling {
    public void makeNoise() {
        var duck = new FatherDuck();
        duck.quack(); // DOES NOT COMPILE
        System.out.print(duck.noise); // DOES NOT COMPILE
} 
