package ocp17.Ch6;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Overrides {

}

class Marsupial {
    public double getAverageWeight() {
        return 50;
    }
}

class Kangaroo extends Marsupial {
    public double getAverageWeight() {
        return super.getAverageWeight() + 20;
    }

    public static void main(String[] args) {
        System.out.println(new Marsupial().getAverageWeight()); // 50.0
        System.out.println(new Kangaroo().getAverageWeight()); // 70.0 }
    }
}

class Camel {
    public int getNumberOfHumps() {
        return 1;
    }
}

class BactrianCamel extends Camel {
    private int getNumberOfHumps() { // DOES NOT COMPILE access modifier private is more restrictive than the one
                                     // defined in the parent version
        return 2;
    }
}

class Reptile {
    protected void sleep() throws IOException {
    }

    protected void hide() {
    }

    protected void exitShell() throws FileNotFoundException {
    }
}

class GalapagosTortoise extends Reptile {
    public void sleep() throws FileNotFoundException { // exception is narrower than the exception declared in the
                                                       // parent class
    }

    public void hide() throws FileNotFoundException {
    } // DOES NOT COMPILE checked exception not present in the parent declaration

    public void exitShell() throws IOException {
    }// DOES NOT COMPILE broader checked exception than FileNotFoundException
}

class Rhino {
    protected CharSequence getName() {
        return "rhino";
    }

    protected String getColor() {
        return "grey, black, or white";
    }
}

class JavanRhino extends Rhino {
    public String getName() { // compiles as String implements CharSequence
        return "javan rhino";
    }

    public CharSequence getColor() { // DOES NOT COMPILE CharSequence is not a subtype of String
        return "grey";
    }
}

class Beetle {
    private String getSize() {
        return "Undefined";
    }
}

class RhinocerosBeetle extends Beetle {
    private int getSize() { // different method signatur
        return 5;
    }
}