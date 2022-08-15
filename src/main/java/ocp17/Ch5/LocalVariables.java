package ocp17.Ch5;

public class LocalVariables {
    int hunger = 4;

    public int feedZooAnimals() {
        int snack = 10; // Local variable
        if (snack > 4) {
            long dinnerTime = snack++;
            hunger--;
        }
        return snack;
    }

    public void zooAnimalCheckup(boolean isWeekend) {
        final int rest;
        if (isWeekend)
            rest = 5;
        else
            rest = 20;
        System.out.print(rest);
        final var giraffe = new LocalVariables();
        final int[] friends = new int[5];
        rest = 10; // DOES NOT COMPILE rest i final
        giraffe = new LocalVariables(); // DOES NOT COMPILE giraffe is final
        friends = null; // DOES NOT COMPILE friends is final
    }

    public void zooAnimalCheckup(boolean isWeekend) {
        final int rest;
        if (isWeekend)
            rest = 5;
        System.out.print(rest); // DOES NOT COMPILE The rest variable might not have been assigned a value
    }
}
