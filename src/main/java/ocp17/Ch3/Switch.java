package ocp17.Ch3;

public class Switch {
    public static void main(String[] args) {
        int animal = 1;
        switch(animal) {
            case 1,2: System.out.print("Lion"); // Works as of Java 14
            case 3: System.out.print("Tiger");
        }

        switch(animal) {
            case 1: case 2: System.out.print("Lion"); 
            case 3: System.out.print("Tiger");
        }

        int month = 5;
        switch month { // DOES NOT COMPILE 
            case 1: System.out.print("January");
        }
        switch(month) // DOES NOT COMPILE
            case 1: System.out.print("January");

        switch(month) {
            case 1: 2: System.out.print("January"); // DOES NOT COMPILE
        }

        switch(month) {} // Works
    }

    public void printSeason(int month) { 
        switch(month) { // prints everything
        case 1, 2, 3:  System.out.print("Winter");
        case 4, 5, 6: System.out.print("Spring");
        default: System.out.print("Unknown");
        case 7, 8, 9: System.out.print("Summer");
        case 10, 11, 12: System.out.print("Fall");
        }
    }

    final int getCookies() { return 4; } 
    void feedAnimals() {
        final int bananas = 1;
        int apples = 2;
        int numberOfAnimals = 3;
        final int cookies = getCookies(); 
        switch(numberOfAnimals) {
            case bananas:
            case apples: // DOES NOT COMPILE. apples not final 
            case getCookies(): // DOES NOT COMPILE. We dont allow functions 
            case cookies : // DOES NOT COMPILE/. Not compile time final  
            case 3 * 5 :
        }
    }

    public void printDayOfWeek(int day) { 
        var result = switch(day) {
            case 0 -> "Sunday"; 
            case 1 -> "Monday"; 
            case 2 -> "Tuesday"; 
            case 3 -> "Wednesday"; 
            case 4 -> "Thursday"; 
            case 5 -> "Friday"; 
            case 6 -> "Saturday";
            default -> "Invalid value"; 
        };
        System.out.print(result);

        var result2 = switch(bear) { 
            case 30 -> "Grizzly" // DOES NOT COMPILE. Missing semicolon
            default -> "Panda" // DOES NOT COMPILE. Missing semicolon
        } // DOES NOT COMPILE. Missing semicolon

        int measurement = 10;
        int size = switch(measurement) {
            case 5 -> 1;
            case 10 -> (short)2;
            default -> 5;
            case 20 -> "3"; // DOES NOT COMPILE. String type cannot be assigned to the int variable
            case 40 -> 4L; // DOES NOT COMPILE Long type cannot be assigned to the int variable
            case 50 -> null; // DOES NOT COMPILE null type cannot be assigned to the int variable
        };

        int fish = 5;
        int length = 12;
        var name = switch(fish) {
            case 1 -> "Goldfish";
            case 2 -> {yield "Trout";}  // yield statement is used to avoid ambiguity with return statement
            case 3 -> {
                if(length > 10) yield "Blobfish";
                else yield "Green"; 
            }
            case 4 -> {} // DOES NOT COMPILE
            case 5 -> {yield "Trout";}; // DOES NOT COMPILE (extra semicolon)
            default -> "Swordfish"; 
        };

        String type = switch(canis) { // DOES NOT COMPILE. Missing default case
            case 1 -> "dog";
            case 2 -> "wolf";
            case 3 -> "coyote";
        };
    }
}
