package ocp17.Ch5;

public class PassingData {
    public static void main(String[] args) {
        int num = 4;
        newNumber(num);
        System.out.print(num); // 4

        String name = "Webby";
        speak(name);
        System.out.print(name); // Webby

        var names = new StringBuilder("Webby");
        speak(names);
        System.out.print(names); // WebbyGeorgette
    }

    public static void newNumber(int num) {
        num = 8;
    }

    public static void speak(String name) {
        name = "Georgette"; 
    }

    public static void speak(StringBuilder s) {
        s.append("Georgette");
    }
}
