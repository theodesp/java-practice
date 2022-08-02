package ocp17.Ch3;

public class DeadCode {
    public static void main(String[] args) {
        int checkDate = 0;
        while (checkDate < 10) {
            checkDate++;
            if (checkDate > 100) {
                break;
                checkDate++; // DOES NOT COMPILE
            }
        }

        int hour = 2;
        switch (hour) {
            case 1:
                return;
                hour++; // DOES NOT COMPILE
            case 2:
        }
    }
}
