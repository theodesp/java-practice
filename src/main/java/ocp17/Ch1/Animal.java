package ocp17.Ch1;

public class Animal { // At most one of the top- level types in the file is allowed to be public 
    String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int numberVisitors(int month) {
        // return 10L; // type mismatch cannot convert long to int
        return 10; // return statement must exist and return the correct value type
    }
    
}

class Animal2 {} // Allowed as long as it is not public
public class Animal3 // Not allowed. Only one public class per file
