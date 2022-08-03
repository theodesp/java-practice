package ocp17.Ch4;

public class ArraysExample {
    public static void main(String[] args) {
        int[] moreNumbers = new int[] {42, 55, 99};
        int[] numbers = {42, 55, 99};
        int[] numAnimals; 
        int [] numAnimals2; 
        int []numAnimals3; 
        int numAnimals4[]; 
        int numAnimals5 [];
        int[] ids, types;
        int ids[], types;

        String[] bugs = { "cricket", "beetle", "ladybug" }; 
        String[] alias = bugs;
        System.out.println(bugs.equals(alias)); // true 
        System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0

        String[] strings = { "stringValue" };
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
        againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
        objects[0] = new StringBuilder(); // Careful!

        String[] mammals = {"monkey", "chimp", "donkey"};
        System.out.println(mammals.length); // 3
        System.out.println(mammals.length()); // DOES NOT COMPILE
    }
    
}
