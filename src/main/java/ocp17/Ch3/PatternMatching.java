package ocp17.Ch3;

public class PatternMatching {
    public static void main(String[] args) {

        Integer value = 123;
        if(value instanceof Integer) {}
        if(value instanceof Integer data) {} // DOES NOT COMPILE. The data pattern variable type Integer needs to be be a strict subtype of Integer

    }

    void compareIntegers(Number number) { 
        if(number instanceof Integer data) { // Instead of  Integer data = (Integer)number;
            System.out.print(data.compareTo(5)); 
        }

        if(number instanceof final Integer data) { 
            data = 10; // DOES NOT COMPILE
        }
    }

    void printIntegersGreaterThan5(Number number) {
        if(number instanceof Integer data && data.compareTo(5)>0)
            System.out.print(data); 
    }

    void printIntegersOrNumbersGreaterThan5(Number number) { 
        if(number instanceof Integer data || data.compareTo(5)>0) // DOES NOT COMPILE. The compiler cannot guarantee that data is an instance of Integer using the (||) operator
            System.out.print(data); }

            
    void printOnlyIntegers(Number number) { 
        if (!(number instanceof Integer data))
            return;
        System.out.print(data.intValue()); // Data must inherit Integer so it works!
    }
}
