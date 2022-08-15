package ocp17.Ch5;

public class MethodOverloading {
    public void fly(int numMiles) {
    }

    public void fly(short numFeet) {
    }

    public boolean fly() {
        return false;
    }

    void fly(int numMiles, short numFeet) {
    }

    public void fly(short numFeet, int numMiles) throws Exception {
    }
}

class Eagle {
    public void fly(int numMiles) {
    }

    public int fly(int numMiles) {
        return 1;
    } // DOES NOT COMPILE
}

class Hawk {
    public void fly(int numMiles) {
    }

    public static void fly(int numMiles) { // DOES NOT COMPILE
    }

    public void fly(int numKilometers) { // DOES NOT COMPILE
    }
}

class Pelican {
    public void fly(String s) {
        System.out.print("string");
    }

    public void fly(Object o) {
        System.out.print("object");
    }

    public static void main(String[] args) {
        var p = new Pelican();
        p.fly("test");
        System.out.print("-");
        p.fly(56);
    }
}

class Kiwi {
    public void fly(int numMiles) {
    }

    public void fly(Integer numMiles) {
    }
}

class Toucan {
    public void fly(int[] lengths) {
    }

    public void fly(int... lengths) {
    } // DOES NOT COMPILE

    public static void main(String[] args) {
        new Toucan().fly(new int[] { 1, 2, 3 }); // Allowed to call either fly() method
        new Toucan().fly(1, 2, 3); // Allowed to call only the fly() method using varargs
    }
}