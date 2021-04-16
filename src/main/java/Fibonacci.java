public class Fibonacci {
    /*
     * Write a method that returns the nth element of the Fibonacci Sequence
     * The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,...
     */
    static int fibonacci(Integer n) {
        int a = 0, b = 1;
        while (n >= 1) {
            int t = b;
            b = a + b;
            a = t;
            n -= 1;
        }
        return a;
    }

    public static void main(String []args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
    }
}
