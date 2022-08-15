package ocp17.Ch5.access.goose;
import ocp17.Ch5.access.shore.Bird;

public class Gosling extends Bird {
    public void swim() {
        floatInWater(); // protected access is ok
        System.out.print(text); // protected access is ok
    }

    public static void main(String[] args) {
        new Gosling().swim(); 
    }
    
}
