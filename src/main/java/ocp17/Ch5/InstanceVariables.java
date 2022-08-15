package ocp17.Ch5;

public class InstanceVariables {
    final int age = 10;
    final int fishEaten;
    final String name;
    {
        fishEaten = 10;
    }

    public InstanceVariables() {
        name = "Robert";
    }
}

class VisitAttractions {
    public void walk1(int... steps) {}
    public void walk2(int start, int... steps) {}
    public void walk3(int... steps, int start) {} // DOES NOT COMPILE varargs parameter in a position that is not the last one. 
    public void walk4(int... start, int... steps) {} // DOES NOT COMPILE varargs parameter in a position that is not the last one. 
    }
