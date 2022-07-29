package ocp17.Ch2;

public class Comparing {
    public static void main(String[] args) {
        boolean monkey = true == 3; // DOES NOT COMPILE cannot compare boolean with int
        boolean ape = false != "Grape"; // DOES NOT COMPILE cannot compare boolean with string
        boolean gorilla = 10.2 == "Koko"; // DOES NOT COMPILE cannot compare double with string

        System.out.print(null == null); // true

        int gibbonNumFeet = 2, wolfNumFeet = 4, ostrichNumFeet = 2; 
        System.out.println(gibbonNumFeet < wolfNumFeet); // true 
        System.out.println(gibbonNumFeet <= wolfNumFeet); // true 
        System.out.println(gibbonNumFeet >= ostrichNumFeet); // true 
        System.out.println(gibbonNumFeet > ostrichNumFeet); // false

        Integer zooTime = Integer.valueOf(9); 
        Number num = zooTime;
        Object obj = zooTime;

        System.out.print(null instanceof Object); // false
        Object noObjectHere = null;
        System.out.print(noObjectHere instanceof String); // false
        System.out.print(null instanceof null); // DOES NOT COMPILE
    }

    public void openZoo(Number time) {
        if (time instanceof Integer)
            System.out.print((Integer)time + " O'clock"); 
        else
            System.out.print(time); 
    }

    public void openZoo2(Number time) {
        if(time instanceof String) // DOES NOT COMPILE Number cannot possibly be cast to a string class
            System.out.print(time); 
    }

}
