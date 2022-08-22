package ocp17.Ch7;

public class StaticInterface {

}

interface Hop {
    static int getJumpHeight() {
        return 8;
    }
}

class Skip {
    public int skip() {
        return Hop.getJumpHeight();
    }
}

class Bunny implements Hop {
    public void printDetails() {
        System.out.println(getJumpHeight()); // DOES NOT COMPILE
        System.out.println(Hop.getJumpHeight()); // works
    }
}

interface Schedule {
    default void wakeUp() {
        checkTime(7);
    }

    private void haveBreakfast() { // private method must include a body
        checkTime(9);
    }

    static void workOut() {
        checkTime(18);
    }

    private static void checkTime(int hour) {
        if (hour > 17) {
            System.out.println("You're late!");
        } else {
            System.out.println("You have " + (17 - hour) + " hours left "
                    + "to make the appointment");
        }
    }
}

interface ZooRenovation {
    public String projectName();

    abstract String status();

    default void printStatus() {
        System.out.print("The " + projectName() + " project " + status());
    }
}

interface ZooTrainTour {
    abstract int getTrainName();

    private static void ride() {
    }

    default void playHorn() {
        getTrainName();
        ride();
    }

    public static void slowDown() {
        playHorn();
    }

    static void speedUp() {
        ride();
    }
}