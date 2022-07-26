package ocp17.Ch1;

/**
 * javac Zoo.java
 * java Zoo --> "Hello World"
 */
public class Zoo {
    /** Any of these are allowed
         * String[] args 
         * String options[] 
         * String... friends
         * String ...friends
         */
    public static void main(String ...args) {
    // public final static void main(final String[] args) {} // Also allowed
        
        System.out.println("Hello World");
        System.out.println(args[0]);
        System.out.println(args[1]); // Throws java.lang.ArrayIndexOutOfBoundsException if passed less params
    }
}
