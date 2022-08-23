package hackerrank.weekprep1;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
/**
 * Given an array of  distinct integers, transform the array into a zig zag sequence 
 * by permuting the array elements. A sequence will be called a zig zag sequence 
 * if the first  elements in the sequence are in increasing order and the last  
 * elements are in decreasing order, where . You need to find the lexicographically 
 * smallest zig zag sequence of the given array.
 * 
 *
 */
public class ZigZagSequence1 {
    
    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
             int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
        kb.close();
   }
   
    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = n/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
    
        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}



