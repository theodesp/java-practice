package ocp17.Ch5;

public class Modifiers {
    static int a = 0;
    abstract int b; //DOES NOT COMPILE
    final int c = 2;
    native void d();
    strictfp void se() {} // strictfp is extraneous
    public modifier void bike5() {} // DOES NOT COMPILE
    public void final bike6() {} // DOES NOT COMPILE
    final public void bike7() {}
}
}
