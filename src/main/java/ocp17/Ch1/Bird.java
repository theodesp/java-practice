package ocp17.Ch1;

public class Bird {
    { System.out.println("A"); } // called first
    public static void main(String[] args) {
        { System.out.println("Feathers"); }
        new Bird(); // prints Snowy
        new Bird(); // prints Snowy
        Chick chick = new Chick(); 
        System.out.println(chick.name);
    }
    { System.out.println("Snowy"); } // called second
    {} // empty blocks
    { System.out.println("Mountain"); } // called last

}

class Chick {
    String name = "Fluffy";
    { System.out.println("setting field"); } 
    public Chick() {
        name = "Tiny";
        System.out.println("setting constructor"); 
    }
}
