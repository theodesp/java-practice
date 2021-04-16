public class FizzBuzz {
    // Write a method that returns 'Fizz'
    // for multiples of three and 'Buzz' for the multiples of five.
    String fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }
        if (i % 3 == 0) {
            return "Fizz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }
}
