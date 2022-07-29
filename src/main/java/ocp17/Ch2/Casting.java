package ocp17.Ch2;

public class Casting {
    public static void main(String[] args) {
        int fur = (int)5;
        int hair = (short) 2;
        String type = (String) "Bird";
        short tail = (short)(4 + 10);
        long feathers = 10(long); // DOES NOT COMPILE type is on the wrong side of the value
        long feathers2 = long * 10; // DOES NOT COMPILE
        long feathers2 = 10 * 1l; // Compiles

        float egg = 2.0 / 9; // DOES NOT COMPILE expression type is double
        int tadpole = (int)5 * 2L; // DOES NOT COMPILE expression type is long
        short frog = 3 - 2.0; // DOES NOT COMPILE expression type is double
        short frog = 3 - 2; // Compiles even if expression type is int and fits within a short

        int fish = (int)1.0;
        short bird = (short)1921222; // Stored as 20678 
        int mammal = (int)9f;

        long reptile = (long)192301398193810323; // DOES NOT COMPILE value is still an int before is cast to long

        short mouse = 10;
        short hamster = 3;
        short capybara = mouse * hamster; // DOES NOT COMPILE. Resulting type is

        int camel = 2, giraffe = 3;
        camel = camel * giraffe; // Simple assignment operator 
        camel *= giraffe; // Compound assignment operator

        long goat = 10; 
        int sheep = 5; 
        sheep *= goat; // compiles as the compound operator will first cast sheep to a long, apply the multiplication of two long values, and then cast the result to an int
    }
}
