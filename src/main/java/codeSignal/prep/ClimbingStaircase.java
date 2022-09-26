package codeSignal.prep;

import java.util.*;
/*
 * You need to climb a staircase that has n steps, and you decide to get some extra exercise by 
 * jumping up the steps. You can cover at most k steps in a single jump. 
 * Return all the possible sequences of jumps that you could take to climb the staircase, sorted.
 * For n = 4 and k = 2, the output should be

solution(n, k) =
[[1, 1, 1, 1],
 [1, 1, 2],
 [1, 2, 1],
 [2, 1, 1],
 [2, 2]]
There are 4 steps in the staircase, and you can jump up 2 or fewer steps at a time. 
There are 5 potential sequences in which you jump up the stairs either 2 or 1 at a time.
 */
public class ClimbingStaircase {

    public static void main(String[] args) {
        for (var arr: solution(4,2)) {
            System.out.println(Arrays.toString(arr));
        }
    }
        static int[][] solution(int n, int k) {
            ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
            makeList(n, k, answer, new ArrayList<Integer>());
            int[][] res = answer.stream().map(u->u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
            return res;
        }

        void makeList(int n, int k, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> steps){
            if(n == 0){
                ArrayList<Integer> tmp = new ArrayList<Integer>(steps);
                answer.add(tmp);
            }
            else{
                for(int i = 1; i < k+1; i++){
                    if(i <= n){
                        steps.add(i);
                        makeList(n-i, k, answer, steps);
                        steps.remove(steps.size()-1);
                    }
                }
            }
        }
}
