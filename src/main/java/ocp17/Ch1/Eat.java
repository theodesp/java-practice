package ocp17.Ch1;

public class Eat {
    public static void main(String[] args) {

    }

    public void eat(int piecesOfCheese) {
        int bitesOfCheese = 1; // two variables within scope
    }

    public void eatIfHungry(boolean hungry) {
        if (hungry) {
            int bitesOfCheese = 1;
        } // bitesOfCheese goes out of scope here
        System.out.println(bitesOfCheese); // DOES NOT COMPILE. bitesOfCheese out of scope
    }

    public void eatIfHungry2(boolean hungry) {
        if (hungry) {
            int bitesOfCheese = 1;
            {
                var teenyBit = true;
                System.out.println(bitesOfCheese);
            } // teenyBit goes out of scope here
        }
        System.out.println(teenyBit); // DOES NOT COMPILE teenyBit out of scope
    }

    public void eatMore(boolean hungry, int amountOfFood) { 
        int roomInBelly = 5;
        if (hungry) {
            var timeToEat = true; // unused
            while (amountOfFood > 0) {
                int amountEaten = 2;
                roomInBelly = roomInBelly - amountEaten; 
                amountOfFood = amountOfFood - amountEaten;
            } 
        } // timeToEat goes out of scope here
        System.out.println(amountOfFood);
        System.out.println(timeToEat); // DOES NOT COMPILE timeToEat is out of scope
    }
}
