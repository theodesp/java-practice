package ocp17.Ch5.access.shore;

public class Bird {
    protected String text = "floating"; 
    protected void floatInWater() {
        System.out.print(text); // protected access is ok
    }
}
