package ocp17.Ch8;

public class Calls {
    public static void main(String[] args) {
        StringTwoParameterChecker methodRef = String::startsWith;
        StringTwoParameterChecker lambda2 = (s, p) -> s.startsWith(p);

        System.out.println(methodRef.check("Zoo", "A")); // false
    }

    void constructors() {
        EmptyStringCreator methodRef = String::new;
        EmptyStringCreator lambda = () -> new String();
        var myString = methodRef.create();
        System.out.println(myString.equals("Snake")); // false
    }

    void copy() {
        StringCopier methodRef = String::new;
        StringCopier lambda = x -> new String(x);
        var myString = methodRef.copy("Zebra");
        System.out.println(myString.equals("Zebra")); // true
    }
}

interface StringTwoParameterChecker {
    boolean check(String text, String prefix);
}

interface EmptyStringCreator {
    String create();
}

interface StringCopier { String copy(String value);
}