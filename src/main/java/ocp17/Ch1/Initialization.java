package ocp17.Ch1;

public class Initialization {
    public static void main(String[] args) {
        final int y = 10;
        y += 10; // does not compile. It is final and cannot be re-assigned

        final int[] favoriteNumbers = new int[10];
        favoriteNumbers[0] = 10;
        favoriteNumbers = null; // DOES NOT COMPILE. It is final and cannot be re-assigned
    }

    public int notValid() { 
        int y = 10;
        int x;
        int reply = x + y; // DOES NOT COMPILE. x is local variable and is not initialized 
        return reply;
    }

    public void findAnswer(boolean check) { 
        int answer;
        int otherAnswer; 
        int onlyOneBranch; 
        if (check) {
            onlyOneBranch = 1; 
            answer = 1;
        } else {
            answer = 2;
        }
        System.out.println(answer); 
        System.out.println(onlyOneBranch); // DOES NOT COMPILE onlyOneBranch may not have been initialized
    }

    public void find(boolean check) {}
    public void checkAnswer() {
        boolean value;
        findAnswer(value); // DOES NOT COMPILE as it tries to use a variable that is not initialized
    }
}
