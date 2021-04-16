public class PackageRice {
    // Provided that you have a given number of small rice bags (1 kilo each) and big rice bags (5 kilos each), write a method that returns
    // true if it is possible to make a package with goal kilos of rice.
    static Boolean packageRice(int big, int small, int goal) {
        while (big > 0 || small > 0) {
            if (big > 0 && goal - 5 == 0) {
                return true;
            }
            if (small > 0 && goal - 1 == 0) {
                return true;
            }
            if (big > 0) {
                big -= 1;
                goal -= 5;
            } else {
                small -= 1;
                goal -= 1;
            }
        }
        return goal == 0;
    }

    public static void main(String []args) {
        System.out.println(packageRice(2, 2, 12));
    }
}
