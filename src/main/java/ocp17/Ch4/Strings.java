package ocp17.Ch4;

public class Strings {
    public static void main(String[] args) {
        String name = "Fluffy";
        String name2 = new String("Fluffy");
        String name3 = """
            Fluffy""";
        System.out.println(1 + 2 + "c"); // 3c
        System.out.println("c" + 1 + 2); // c12
        System.out.println("c" + null); // cnull

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four); // 64

        var s = "1";
        s += "2";
        s += 3;
        System.out.println(s); // 123
    }

    private class MyString extends String {} // DOES NOT COMPILE. String is final

    public void stringMethods() {
        var aname = "animals"; 
        System.out.println(aname.length()); // 7

        var name = "animals"; 
        System.out.println(name.charAt(0)); // a 
        System.out.println(name.charAt(6)); // s 
        System.out.println(name.charAt(7)); // exception. Index out of bounds

        var name2 = "animals"; 
        System.out.println(name2.indexOf('a')); // 0
        System.out.println(name2.indexOf("al")); // 4
        System.out.println(name2.indexOf('a', 4)); // 4
        System.out.println(name2.indexOf("al", 5)); // -1

        var name3 = "animals"; 
        System.out.println(name3.substring(3)); // mals
        System.out.println(name3.substring(name3.indexOf('m'))); // mals
        System.out.println(name3.substring(3, 4)); // m
        System.out.println(name3.substring(3, 7)); // mals

        System.out.println(name3.substring(3, 3)); // empty string 
        System.out.println(name3.substring(3, 2)); // exception 
        System.out.println(name3.substring(3, 8)); // exception

    }
}
