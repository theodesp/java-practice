package ocp17.Ch6;

public class HiddenVariables {

}

class Carnivore {
    protected boolean hasFur = false;
}

class Meerkat extends Carnivore {
    protected boolean hasFur = true;

    public static void main(String[] args) {
        Meerkat m = new Meerkat();
        Carnivore c = m;
        System.out.println(m.hasFur); // true System.out.println(c.hasFur); // false
    }
}

class Bird {
    public final boolean hasFeathers() {
        return true;
    }

    public final static void flyAway() {
    }
}

class Penguin extends Bird {
    public final boolean hasFeathers() { // DOES NOT COMPILE
        return false;
    }

    public final static void flyAway() { // DOES NOT COMPILE

    }
}