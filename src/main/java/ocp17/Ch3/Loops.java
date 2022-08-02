package ocp17.Ch3;

public class Loops {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int counter = 0;
        while (counter < 10) {
            double price = counter * 10;
            System.out.println(price);
            counter++;
        }

        int lizard = 0;
        do {
            lizard++;
        } while (false);
        System.out.println(lizard); // 1

        for (int i = 0; i < 10; i++)
            System.out.println("Value is: " + i);
        System.out.println(i); // DOES NOT COMPILE. i not in scope

        for (var counter = 5; counter > 0; counter--) {
            System.out.print(counter + " ");
        }

        int x = 0;
        for (int x = 4; x < 5; x++) // DOES NOT COMPILE. x is re-declared
            System.out.print(x + " ");
        for(long y = 0, int z = 4; x < 5; x++) // DOES NOT COMPILE. An initialization block must all be of the same type
            System.out.print(y + " ");

        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
        for(int[] mySimpleArray : myComplexArray) { 
            for(int i=0; i<mySimpleArray.length; i++) { 
                System.out.print(mySimpleArray[i]+"\t");
            }
            System.out.println(); 
        }
    }

    int roomInBelly = 5;

    public void eatCheese(int bitesOfCheese) {
        while (bitesOfCheese > 0 && roomInBelly > 0) {
            bitesOfCheese--;
            roomInBelly--;
        }
        System.out.println(bitesOfCheese + " pieces of cheese left");
    }

    public void printNames(String[] names) {
        for (var name : names)
            System.out.println(name);
    }
}
