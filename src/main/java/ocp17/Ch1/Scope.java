package ocp17.Ch1;

public class Scope {
    public static void main(String[] args) {
        String one, two;
        one = new String("a");
        two = new String("b"); 
        one = two; // string "a" eligible for garbage collection
        String three = one; 
        one = null; // reference to "b" eligible for garbage collection

        // two points to "b"
        System.out.println(two);
        // three points to "b"
        System.out.println(three);
    }
}
