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
        stringIntent();
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

        var name = "animals"; 
        System.out.println(name.toUpperCase()); // ANIMALS 
        System.out.println("Abc123".toLowerCase()); // abc123


        System.out.println("abc".equals("ABC")); // false 
        System.out.println("ABC".equals("ABC")); // true 
        System.out.println("abc".equalsIgnoreCase("ABC")); // true

        System.out.println("abc".startsWith("a")); 
        System.out.println("abc".startsWith("A"));

        System.out.println("abc".endsWith("c"));
        System.out.println("abc".endsWith("a"));

        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false

        System.out.println("abcabc".replace('a', 'A')); // AbcAbc 
        System.out.println("abcabc".replace("a", "A")); // AbcAbc

        System.out.println("abc".strip()); 
        System.out.println("\t a b c\n".strip()); // a b c

        String text = " abc\t "; 
        System.out.println(text.trim().length()); // 3
        System.out.println(text.strip().length()); // 3
        System.out.println(text.stripLeading().length()); // 5 
        System.out.println(text.stripTrailing().length());// 4

        System.out.println(" ".isEmpty()); // false 
        System.out.println("".isEmpty()); // true 
        System.out.println(" ".isBlank()); // true 
        System.out.println("".isBlank()); // true

        var name = "Kate";
        var orderId = 5;

        // All print: Hello Kate, order 5 is ready
        System.out.println("Hello "+name+", order "+orderId+" is ready"); 
        System.out.println(String.format("Hello %s, order %d is ready", name, orderId));
        System.out.println("Hello %s, order %d is ready".formatted(name, orderId));

        /*
         * James:
         *   Score: 90.250000 out of 100
         * 
         */
        var name = "James";
        var score = 90.25;
        var total = 100;
        System.out.println("%s:%n Score: %f out of %d".formatted(name, score, total));

        var str = "Food: %d tons".formatted(2.0); // IllegalFormatConversionException
    }

    public static void stringIntent() {
        var block = """
            a
             b
            c""";
        var concat = " a\n" + " b\n" + " c";

        System.out.println(block.length()); // 6
        System.out.println(concat.length()); // 9
        System.out.println(block.indent(1).length()); // 10
        System.out.println(concat.indent(-1).length()); // 7
        System.out.println(concat.indent(-4).length()); // 6
        System.out.println(concat.stripIndent().length()); // 6 // Removes all leading incidental whitespace

        /**
         * block.indent(0)
            "a\n
             b\n
            c\n
            "
         */

         /**
         * block.indent(1)
            " a\n
               b\n
              c\n
            "
         */
    }

    public static void translateEscapes() {
        var str = "1\\t2";
        System.out.println(str); // 1\t2 
        System.out.println(str.translateEscapes()); // 1 2
    }
}
