package ocp17.Ch2;

public class Logical {
    public static void main(String[] args) {
        boolean eyesClosed = true; 
        boolean breathingSlowly = true;
        boolean resting = eyesClosed | breathingSlowly; 
        boolean asleep = eyesClosed & breathingSlowly; 
        boolean awake = eyesClosed ^ breathingSlowly; 
        System.out.println(resting); // true 
        System.out.println(asleep); // true 
        System.out.println(awake); // false

        int hour = 10;
        boolean zooOpen = true || (hour < 4); 
        System.out.println(zooOpen); // true

        int rabbit = 6;
        boolean bunny = (rabbit >= 6) || (++rabbit <= 7); // side-effect on the right hand side of the || 
        System.out.println(rabbit);

        int owl = 5;
        int food = owl < 2 ? 3 : 4; 
        System.out.println(food); // 4

        int stripes = 7;
        System.out.print((stripes > 5) ? 21 : "Zebra");
        int animal = (stripes < 9) ? 3 : "Horse"; // DOES NOT COMPILE. return value is not an int
    }
}
