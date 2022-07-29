package ocp17.Ch1;

public class Primitives {
    public static void main(String[] args) {
        boolean b = true;
        byte bt = 12; // -128:127
        short s  = 12; // -32768:32767
        int i = 100; // -2147483648:2147483647
        long lo = 100l; // -2^63:2^63 – 1
        float f = 12.0f;
        float f = 12.0; // Does not compile as double does not fit within float
        double d = 12.0;
        char c = 'a'; // 0:65535
        int out = 3123456789 // Does not compile as 3123456789 is out of range for int

        int million1 = 1000000; 
        int million2 = 1_000_000;

        double notAtStart = _1000.00; // Does not compile as it starts with _
        double notAtEnd = 1000.00_; // Does not compile as it ends with _
        double notByDecimal = 1000_.00; // Does not compile as it has _ before a decimal point 
        double annoyingButLegal = 1_00_0.0_0; //Compiles
        double reallyUgly = 1__________2; // Compiles

    }
}
