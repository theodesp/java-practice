package ocp17.Ch1;

public class Reference {
    public static void main(String[] args) {
        String reference = "hello";
        int len = reference.length();
        int bad = len.length(); // Does not compile. Int does not have length() method. Primitives do not have methods

        int value = null; // Does not compile. You cannot assign null to primitives only objects
        String name = null;
    }
}
