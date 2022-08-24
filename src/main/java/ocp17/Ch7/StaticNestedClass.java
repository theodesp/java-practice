package ocp17.Ch7;

public class StaticNestedClass {
    
}

class Park {
    static class Ride {
        private int price = 6;
        private static int delay = 10;
    }

    public static void main(String[] args) {
        var ride = new Ride();
        System.out.println(ride.price);
        System.out.println(Ride.delay);]
    }
}