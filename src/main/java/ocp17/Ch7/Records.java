package ocp17.Ch7;

public class Records {
    public static void main(String[] args) {
        var mommy = new Crane(4, "Cammy");
        System.out.println(mommy.numberEggs()); // 4
        System.out.println(mommy.name()); // Cammy

        var mommy1 = new Crane("Cammy", 4); // DOES NOT COMPILE
        var mommy2 = new Crane("Cammy"); // DOES NOT COMPILE

        var father = new Crane(0, "Craig");
        System.out.println(father); // Crane[numberEggs=0, name=Craig]

        var copy = new Crane(0, "Craig");
        System.out.println(copy); // Crane[numberEggs=0, name=Craig]
        System.out.println(father.equals(copy)); // true
        System.out.println(father.hashCode() + ", " + copy.hashCode()); // 1007, 1007

        var cousin = new Crane(3, "Jenny");
        var friend = new Crane(cousin.numberEggs(), "Janeice");
    }
}

record Crane(int numberEggs, String name) {
}

record BlueCrane() extends Crane {} // DOES NOT COMPILE you can’t extend or inherit a record

interface Bird {}
record Crane(int numberEggs, String name) implements Bird {}

record Crane(int numberEggs, String name) {
    public Crane(int numberEggs, String name) {
        if (numberEggs < 0) 
            throw new IllegalArgumentException(); 
        this.numberEggs = numberEggs;
        this.name = name;
    }
}

record Crane2(int numberEggs, String name) {
    public Crane2(int numberEggs, String name) {} // DOES NOT COMPILE since each field is final, the constructor must set every field
}


record Crane3(int numberEggs, String name) {
    public Crane { // Compact Constructor
        if (numberEggs < 0) throw new IllegalArgumentException();
        name = name.toUpperCase();
    }
}

record Crane4(int numberEggs, String name) { 
    public Crane {
        this.numberEggs = 10; // DOES NOT COMPILE compact constructors cannot modify the fields of the record 
    } 
}

record Crane5(int numberEggs, String name) { 
    public Crane5(String firstName, String lastName) {
        this(0, firstName + " " + lastName);
        numberEggs = 10; // NO EFFECT (applies to parameter, not instance field)
        this.numberEggs = 20; // DOES NOT COMPILE
    }
}

record Crane6(int numberEggs, String name) { 
    @Override public int numberEggs() { return 10; } 
    @Override public String toString() { return name; }
}

record Crane7(int numberEggs, String name) { 
    private static int type = 10;
    public int size; // DOES NOT COMPILE  cannot add instance fields
    private boolean friendly; // DOES NOT COMPILE cannot add instance fields
}
