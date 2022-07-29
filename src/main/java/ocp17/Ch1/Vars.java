package ocp17.Ch1;

public class Vars {
    var tricky = "Hello"; // DOES NOT COMPILE cannot use var as instance variable
    public void whatTypeAmI() {
        var name = "Hello"; // infers to string
        var size = 7;  // infers to int

        name = 1; // does not compile as name is of type string

        var silly
        = 1; // valid
    }

    public void doesThisCompile(boolean check) {
        var question; // Does this compile. Cannot use var on variable without initializer
        question = 1;
        question = Integer.valueOf(1); // returns Integer object

        int a, var b = 3; // DOES NOT COMPILE multiple type declaration on a single line
        var i=2, j=3; // DOES NOT COMPILE multiple type declaration is not allowed with var
        var n = null; // DOES NOT COMPILE compiler cannot infer the type of the var
    }

    public int addition(var a, var b) { // DOES NOT COMPILE var cannot be used as method parameter
        return a + b;
    }
    
}

class Var {  // Compiles
    public void var() { 
        var var = "var";
    }
    public void Var() {
        Var var = new Var(); 
    }
}