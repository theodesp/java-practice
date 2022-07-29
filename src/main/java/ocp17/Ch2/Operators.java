package ocp17.Ch2;

public class Operators {
    public static void main(String[] args) {
        int cookies = 4;
        double reward = 3 + 2 * --cookies; // 3 + 2 * 3 = 9.0
        System.out.print("Zoo animal receives: "+reward+" reward points");

        int height=1, length = 2;
        var perimeter = 2 * height + 2 * length; // equivalent to var perimeter = ((2 * height) + (2 * length));

        boolean isAnimalAsleep = false; 
        System.out.print(isAnimalAsleep); // false 
        isAnimalAsleep = !isAnimalAsleep; 
        System.out.print(isAnimalAsleep); // true

        int value = 3; // Stored as 0011
        int complement = ~value;  // Stored as 1100
        System.out.println(value); // 3
        System.out.println(complement); // -4

        System.out.println(-1*value - 1); // -4 
        System.out.println(-1*complement - 1); // 3

        double zooTemperature = 1.21; 
        System.out.println(zooTemperature); // 1.21 
        zooTemperature = -zooTemperature; 
        System.out.println(zooTemperature); // -1.21 
        zooTemperature = -(-zooTemperature); 
        System.out.println(zooTemperature); // -1.21

        int pelican = !5; // DOES NOT COMPILE 
        boolean penguin = -true; // DOES NOT COMPILE 
        boolean peacock = !0; // DOES NOT COMPILE
        boolean parrot = 0&0; // DOES NOT COMPILE return value is int
        boolean crow = ~1&~1; // DOES NOT COMPILE return value is int

        int parkAttendance = 0; 
        System.out.println(parkAttendance); // 0 
        System.out.println(++parkAttendance); // 1

        System.out.println(parkAttendance); // 1 
        System.out.println(parkAttendance--); // 1 
        System.out.println(parkAttendance); // 0

        int price = 2 * 5 + 3 * 4 - 8; // evaluates from left to right
        long pigeon = 1 + ((3 * 5) / 3; // DOES NOT COMPILE missing right parenthesis
        int blueJay = (9 + 2) + 3) / (2 * 4; // DOES NOT COMPILE missing left and right parenthesis
        short robin = 3 + [(4 * 2) + 4]; // DOES NOT COMPILE We do not allow brackets

        System.out.println(9 / 3);  // 3
        System.out.println(9 % 3); // 0
        System.out.println(10 / 3); // 3
        System.out.println(10 % 3); // 1
        System.out.println(11 / 3); // 3
        System.out.println(11 % 3); // 2

        System.out.println(-11 % 3); // -3

    }
}
