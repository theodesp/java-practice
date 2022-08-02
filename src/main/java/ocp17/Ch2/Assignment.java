package ocp17.Ch2;

public class Assignment {
    public static void main(String[] args) {
        long wolf = 5;
        long coyote = (wolf=3); 
        System.out.println(wolf); // 3 
        System.out.println(coyote); // 3

        boolean healthy = false; 
        if(healthy = true)
            System.out.print("Good!"); // prints Good!
        
    }
}
