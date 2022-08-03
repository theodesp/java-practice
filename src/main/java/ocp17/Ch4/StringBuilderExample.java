package ocp17.Ch4;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder alpha = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++)
            alpha.append(current);
        System.out.println(alpha);

        StringBuilder sb = new StringBuilder("start");
        sb.append("+middle"); // sb = "start+middle"
        StringBuilder same = sb.append("+end"); // "start+middle+end"

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a); // abcdefg
        System.out.println("b=" + b); // abcdefg

        var animals = new StringBuilder("animals");
        animals.insert(7, "-"); // sb = animals- 
        animals.insert(0, "-"); // sb = -animals- 
        animals.insert(4, "-"); // sb = -ani-mals-
        System.out.println(animals);

        var sb = new StringBuilder("abcdef"); 
        sb.delete(1, 3); // sb = adef 
        sb.deleteCharAt(5); // exception

        var builder = new StringBuilder("pigeon dirty"); 
        builder.replace(3, 6, "sty"); 
        System.out.println(builder); // pigsty dirty

        var builder = new StringBuilder("pigeon dirty"); 
        builder.replace(3, 100, ""); // "pig"
        System.out.println(builder);

        var sb = new StringBuilder("ABC"); 
        sb.reverse(); 
        System.out.println(sb); "CBA"
    }

    public static void equality {
        var one = new StringBuilder();
        var two = new StringBuilder();
        var three = one.append("a"); 
        System.out.println(one == two); // false 
        System.out.println(one == three); // true

        var x = "Hello World";
        var z = " Hello World".trim(); 
        System.out.println(x.equals(z)); // true
        System.out.println(x == z); // false

        var name = "a";
        var builder = new StringBuilder("a"); 
        System.out.println(name == builder); // DOES NOT COMPILE

        var x = "Hello World";
        var y = "Hello World"; 
        System.out.println(x == y); // true

        var x = "Hello World";
        var y = new String("Hello World"); 
        System.out.println(x == y); // false

        var name = "Hello World";
        var name2 = new String("Hello World").intern(); 
        System.out.println(name == name2); // true
    }
}
