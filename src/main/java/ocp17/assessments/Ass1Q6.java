package ocp17.assessments;
import java.util.Locale;
import java.util.ResourceBundle;

public class Ass1Q6 {
    public static void main(String[] args) {
        Locale fr = new Locale("fr");
        Locale.setDefault(new Locale("en", "US")); // changes locale to en_US
        var b = ResourceBundle.getBundle("Penguin", fr); // tries to match Penguin_en.properties
        System.out.println(b.getString("name")); // gets from Penguin_en.properties
        System.out.println(b.getString("age")); // gets from Penguin.properties as value does not exist in Penguin_en.properties 
    }
}
