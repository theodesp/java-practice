package ocp17.Ch6;

public class Finals {

}

class MouseHouse {
    private final int volume;
    private final String name;

    public MouseHouse() {
        this.name = "Empty House";
        volume = 10; // Instance initializer assignment
    }
}

class DollHouse {
    private final int volume;
    private final String type;
    {
        this.volume = 10;
    }

    public DollHouse(String type) {
        this.type = type;
    }

    public DollHouse() { // DOES NOT COMPILE
        this.volume = 2; // DOES NOT COMPILE
    }
}