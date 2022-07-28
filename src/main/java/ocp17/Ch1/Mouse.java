package ocp17.Ch1;

public class Mouse {
    final static int MAX_LENGTH = 5; 
    int length;
    public void grow(int inches) {
        if (length < MAX_LENGTH) { // instance variable inits to 0
            int newSize = length + inches; 
            length = newSize;
        }
        // newSize goes out of scope
    }
}
