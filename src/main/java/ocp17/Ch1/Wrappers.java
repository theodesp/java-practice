package ocp17.Ch1;

public class Wrappers {
    public static void main(String[] args) {
        var b = Boolean.valueOf(true); // convert primitive to Boxed types
        var bt = Byte.valueOf((byte) 1);

        int primitive = Integer.parseInt("123"); // Convert string to primitive 
        Integer wrapper = Integer.valueOf("123");

        Double apple = Double.valueOf("200.99"); 
        System.out.println(apple.byteValue()); // -56 
        System.out.println(apple.intValue()); // 200 
        System.out.println(apple.doubleValue()); // 200.99
    }
}
