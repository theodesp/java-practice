public class Ass1Q5 {
    public static void addToInt(int x, int amountToAdd) {
        x = x + amountToAdd; 
    }
    public static void main(String[] args) { 
        var a = 15;
        var b = 10; 
        Ass1Q5.addToInt(a, b); // a = 15, b = 10 as the function pass a by value
        System.out.println(a); // prints 15
    } 
}
