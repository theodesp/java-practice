package ocp17.Ch5;

public class Methods {
    public static void main(String[] args) {
        
    }

    public void skip1() {}
    default void skip2() {} // DOES NOT COMPILE. Default is not allowed 
    void public skip3() {} // DOES NOT COMPILE. The access modifier is specified after the return type 
    void skip4() {}

    public void jog1() {} 
    public void 2jog() {} // DOES NOT COMPILE
    public _() {} // DOES NOT COMPILE
    public void() {} // DOES NOT COMPILE
}
