package ocp17.Ch7;

public class Enums {
    public static void main(String[] args) {
        for (var season : Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }

        if (Season.SUMMER == 2) {
        } // DOES NOT COMPILE

        Season s = Season.valueOf("SUMMER"); // SUMMER
        Season t = Season.valueOf("summer"); // IllegalArgumentException

        Season summer = Season.SUMMER;
        switch (summer) {
            case WINTER:
                System.out.print("Get out the sled!");
                break;
            case SUMMER:
                System.out.print("Time for the pool!");
                break;
            default:
                System.out.print("Is it summer yet?");
        }

        Season summer = Season.SUMMER;
        var message = switch (summer) {
            case Season.WINTER -> "Get out the sled!"; // DOES NOT COMPILE needs to be replaced with WINTER
            case 0 -> "Time for the pool!"; // DOES NOT COMPILE cannot convert int to Season
            default -> "Is it summer yet?";
        };
        System.out.print(message);
    }
}

public enum Season {
    WINTER, SPRING, SUMMER, FALL;
}

enum ExtendedSeason extends Season {} // DOES NOT COMPILE cannot extend enum

enum OnlyOne { 
    ONCE(true);
    private OnlyOne(boolean b) { 
        System.out.print("constructing,");
    } 
}

class PrintTheOne {
    public static void main(String[] args) {
        System.out.print("begin,");
        OnlyOne firstCall = OnlyOne.ONCE; // Prints constructing, 
        OnlyOne secondCall = OnlyOne.ONCE; // Doesn't print anything 
        System.out.print("end");
    } 
}

enum Season { 
    WINTER {
        public String getHours() { return "10am-3pm"; } 
    },
    SPRING {
        public String getHours() { return "9am-5pm"; }
    }, 
    SUMMER {
        public String getHours() { return "9am-7pm"; } },
    FALL {
        public String getHours() { return "9am-5pm"; }
    };
    public abstract String getHours(); 
}

interface Weather { int getAverageTemperature(); }


enum Season implements Weather {
    WINTER, SPRING, SUMMER, FALL;
    public int getAverageTemperature() { return 30; }
    }