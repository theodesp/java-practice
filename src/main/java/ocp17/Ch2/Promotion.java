package ocp17.Ch2;

public class Promotion {
    public static void main(String[] args) {
        int x = 1; 
        long y = 33; 
        var z = x * y; // z is long

        double xx = 39.21; 
        float yy = 2.1; // does not compile
        var zz = x + yy;

        short xxx = 10; 
        short yyy = 3; 
        var zzz = xxx * yyy; // zzz is int
    }

    public void test1(){
        short w = 14;
        float x = 13; 
        double y = 30;
        var z = w * x / y; // 14 * 13.0f / 30.0 ==> 182.0f / 30.0 => 
    }
}
