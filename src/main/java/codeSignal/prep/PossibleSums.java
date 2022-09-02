package codeSignal.prep;

import java.util.HashSet;

public class PossibleSums {
    public static void main(String[] args) {
        var coins = new int[]{10, 50, 100};
        var quantity = new int[]{1,2,1};
        System.out.println(solution(coins, quantity));
    }

    static int solution(int[] coins, int[] quantity) {
        // keep the result of unique coin combinations
        var bag = new HashSet<Integer>();
        // start with 0 sum
        bag.add(0);
        // for each coin
        for (int i = 0; i < coins.length; i++) {
            // get the current coin
            var coin = coins[i];
            // temp sum consisting of sums of the current coin multiplied by their quantities
            var temp = new HashSet<Integer>();
            // for each previously computed sum in the bag
            for (var item: bag) {
                // add each quantity to the temp
                for (int j = 1; j <= quantity[i]; j++) {
                    temp.add(item+j*coin);
                }
            }
            // update the local
            bag.addAll(temp);
        }
        // return size of bag
        return bag.size() - 1;
    }
}
