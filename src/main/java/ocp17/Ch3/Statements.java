package ocp17.Ch3;

public class Statements {
    public static void main(String[] args) {
        int patrons = 0;
        {
            patrons++; 
        }
        int hourOfDay = 9;
        if(hourOfDay < 11)
        System.out.println("Good Morning");

        if(hourOfDay < 11) { System.out.println("Good Morning");
        }
        if(hourOfDay >= 11) {
        System.out.println("Good Afternoon"); }

        if(hourOfDay < 11) { 
            System.out.println("Good Morning");
        } else 
            System.out.println("Good Afternoon");
        
        if(hourOfDay < 11) { System.out.println("Good Morning");
        } else if(hourOfDay < 15) { System.out.println("Good Afternoon");
        } else {
            System.out.println("Good Evening");
        }
    }
}
