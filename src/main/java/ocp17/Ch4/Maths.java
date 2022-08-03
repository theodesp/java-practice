package ocp17.Ch4;

public class Maths {
    public static void main(String[] args) {
        int first = Math.max(3, 7); // 7 
        int second = Math.min(7, -9); // -9
        long low = Math.round(123.45); // 123 
        long high = Math.round(123.50); // 124 
        int fromFloat = Math.round(123.45f); // 123

        double c = Math.ceil(3.14); // 4.0 
        double f = Math.floor(3.14); // 3.0

        double squared = Math.pow(5, 2); // 25.0
        double num = Math.random();
    }
}
