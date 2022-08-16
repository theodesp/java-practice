package ocp17.Ch6;

public class ConstructorCalls {

}

class Mammal {
    public Mammal(int age) {
    }
}

class Seal extends Mammal {
} // DOES NOT COMPILE

class Elephant extends Mammal {
    public Elephant() {
    } // DOES NOT COMPILE
}

class Seal extends Mammal {
    public Seal() {
        super(); // DOES NOT COMPILE there is no no-argument constructor in Mammal
    }
}