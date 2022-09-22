package crackingCodeInterview.recursion;

public class Fib {
    static int fibonacci(int i) {
        if (i == 0) {return 0;}
        if (i == 1) {return 1;}
        return fibonacci(i - 1) + fibonacci(i-2);
    }

    static int fibonacci2(int n) {
        return fibonacciMemo(n, new int[n+1]);
    }

    static int fibonacciMemo(int i, int[] memo) {
        if (i==0 || i==1) return i;

        if (memo[i] == 0) {
            memo[i] = fibonacciMemo(i-1, memo) + fibonacciMemo(i-2, memo);
        }

        return memo[i];
    }
}
