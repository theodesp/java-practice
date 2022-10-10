package codeSignal.prep;
import java.util.*;
import java.util.stream.Collectors;
/*
 * Given an array of integers, write a function that determines whether the 
 * array contains any duplicates. Your function should return true 
 * if any element appears at least twice in the array, 
 * and it should return false if every element is distinct.

Example

For a = [1, 2, 3, 1], the output should be
solution(a) = true.

There are two 1s in the given array.

For a = [3, 1], the output should be
solution(a) = false.

The given array contains no duplicates.
 */
public class ContainesDuplicates {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 1}));
        System.out.println(solution(new int[]{3, 1}));
    }
    static boolean solution(int[] a) {
        return Arrays.stream(a).boxed().collect(Collectors.toSet()).size() != a.length;
    }
}
