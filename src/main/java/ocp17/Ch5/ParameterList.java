package ocp17.Ch5;

public class ParameterList {
    public class Sleep {
        void nap() {
        }
    }

    public void run1() {
    }

public void run2
    {
    } // DOES NOT COMPILE

    public void run3(int a) {
    }

public void run4(int a; int b) {} // DOES NOT COMPILE

    public void run5(int a, int b) {
    }
}

class Trip {
    public void visitZoo(String name, int waitTime) {
    }

    public void visitZoo(String attraction, int rainFall) {
    } // DOES NOT COMPILE those two methods have the same signature and cannot be declared within the same class
}
