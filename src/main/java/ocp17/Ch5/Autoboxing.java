package ocp17.Ch5;

public class Autoboxing {
    public static void main(String[] args) {
        int quack = 5;
        Integer quackquack = Integer.valueOf(quack); // Convert int to Integer
        int quackquackquack = quackquack.intValue(); // Convert Integer to int
        quackquack = quack; // Autoboxing
        int quackquackquack2 = quackquack; // Unboxing

        Long badGorilla = 8; // DOES NOT COMPILE

        Character elephant = null;
        char badElephant = elephant; // NullPointerException

        var g = new Autoboxing();
        g.rest(7); // DOES NOT COMPILE
    }

    public void rest(Long x) {
        System.out.print("long");
    }
}
