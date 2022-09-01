package erickson;

public class BottlesOfBeer {
    public static void main(String[] args) {
        solution(10);
    }

    static void solution(int n) {
        for (int i = n; i > 0; i--) {
            System.out.printf("%d bottles of beer on the wall, %d bottles of beer,", i, i);
            System.out.printf("Take one down, pass it around, %d bottles of beer on the wall.\n", i-1);
        }

        System.out.println("No bottles of beer on the wall, no bottles of beer");
    }
}
