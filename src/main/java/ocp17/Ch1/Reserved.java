package ocp17.Ch1;

public class Reserved {
    public static void main(String[] args) {
        long okidentifier;
        float $OK2Identifier;
        boolean _alsoOK1d3ntifi3r; 
        char __SStillOkbutKnotsonice$;

        int 3DPointClass; // identifiers cannot begin with a number
        byte hollywood@vine;  // @ is not a letter, digit, $ or _
        String *$coffee;  // * is not a letter, digit, $ or _
        double public; // public is a reserved word
        short _; // a single underscore is not allowed
    }

    void sandFence() {
        String s1, s2; // multiple strings
        String s3 = "yes", s4 = "no";
        int i1, i2, i3 = 0; // only i3 is initialized
        int num, String value; // DOES NOT COMPILE multiple variables of different types in the same statement
        double d1, double d2; // does not compile for the same reason
    }
}
