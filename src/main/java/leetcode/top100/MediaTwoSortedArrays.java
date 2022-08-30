package leetcode.top100;

import java.util.Arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MediaTwoSortedArrays {
    public static void main(String[] args) {
        // System.out.println(findMedianSortedArrays(new int[]{1,2,3}, new int[]{}));
        // System.out.println(findMedianSortedArrays(new int[]{}, new int[]{}));
        // System.out.println(findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{}));
        // System.out.println(findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{5,6,7}));
        System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{-2,-1}));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if (nums1.length == 0 && nums2.length == 0) {
        //     return 0;
        // }
        // if (nums1.length == 0) {
        //     return medianOfArray(nums2);
        // }
        // if (nums2.length == 0) {
        //     return medianOfArray(nums1);
        // }
        // if (nums1[nums1.length-1] < nums2[0]) {
        //     var merged = new int[nums1.length + nums2.length];
        //     System.arraycopy(nums1, 0, merged, 0, nums1.length);  
        //     System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);  
        //     return medianOfArray(merged);
        // }
        // if (nums2[nums2.length-1] < nums1[0]) {
        //     var merged = new int[nums1.length + nums2.length];
        //     System.arraycopy(nums2, 0, merged, 0, nums2.length);  
        //     System.arraycopy(nums1, 0, merged, nums2.length, nums1.length);  
        //     return medianOfArray(merged);
        // }
        // var m1 = medianOfArray(nums1);
        // var m2 = medianOfArray(nums2);
        // if (m1 == m2) {
        //     return m2;
        // }
        // // if (nums1.length < nums2.length) {
        // //     for (var v: nums1) {
        // //         var index = Arrays.binarySearch(nums2, v);
        // //     }
        // //     return medianOfArray(nums2);
        // // } else {
        // //     for (var v: nums2) {
        // //         var index = Arrays.binarySearch(nums1, v);
        // //     }
        // //     return medianOfArray(nums1);
        // // }
    
        // return 0;
        return findMedian(nums1, nums2, 0, 0, nums1.length-1, nums2.length-1);
    }
    // a function for finding median of array
    static double median(int[] a, int start, int end) {
        int n = end - start + 1;
        
        // checking if length is even or odd
        if (n % 2 == 0) {
            return (double)(a[start + (n / 2)]
                    + a[start + (n / 2 - 1)])
                    / 2;
        } else {
            return (double)a[start + n / 2];
        }
    }
    
    // // a recursive function that returns the median of the array
    // static double findMedian(int[] a1, int[] a2, int start_a1,
    //         int start_a2, int end_a1, int end_a2) {
    //     // base case
    //     if (end_a1 - start_a1 == 1) {
    //         return (double)(Math.max(a1[start_a1],
    //                 a2[start_a2])
    //                 + Math.min(a1[end_a1], a2[end_a2]))
    //                 / 2;
    //     }
    //     // median of the first array
    //     double m1 = median(a1, start_a1, end_a1);
    //     // median of the second array
    //     double m2 = median(a2, start_a2, end_a2);

    //     if (m1 == m2) {
    //         return m1;
    //     }
        
    //     // if the median of the first array is smaller then recursively call the function
    //     else if (m1 < m2) {
    //         return findMedian(
    //                 a1, a2, (end_a1 + start_a1 + 1) / 2,
    //                 start_a2, end_a1,
    //                 (end_a2 + start_a2 + 1) / 2);
    //     }

    //     else {
    //         return findMedian(
    //                 a1, a2, start_a1,
    //                 (end_a2 + start_a2 + 1) / 2,
    //                 (end_a1 + start_a1 + 1) / 2, end_a2);
    //     }
    // }

    static float MO2(int a, int b) {
        return (float) ((a + b) / 2.0);
    }
 
    static float MO3(int a, int b, int c) {
        return a + b + c - Math.max(a, Math.max(b, c)) -
          Math.min(a, Math.min(b, c));
    }
    static float MO4(int a, int b, int c, int d) {
        int Max = Math.max(a, Math.max(b, Math.max(c, d)));
        int Min = Math.min(a, Math.min(b, Math.min(c, d)));
        return (float) ((a + b + c + d - Max - Min) / 2.0);
    }
    static float medianSingle(int arr[], int n) {
        if (n == 0)
            return -1;
        if (n % 2 == 0)
            return (float) ((double) (arr[n / 2] +
                                      arr[n / 2 - 1]) / 2);
        return arr[n / 2];
    }
    static float findMedianUtil(int A[], int N, int B[], int M) {
        if (N == 0)
            return medianSingle(B, M);
 
        if (N == 1) {
            if (M == 1)
                return MO2(A[0], B[0]);
 
            if (M % 2 == 1)
                return MO2(B[M / 2], (int) MO3(A[0],
                            B[M / 2 - 1], B[M / 2 + 1]));
 
            return MO3(B[M / 2], B[M / 2 - 1], A[0]);
        }
        else if (N == 2) {
            if (M == 2)
                return MO4(A[0], A[1], B[0], B[1]);
 
            
            if (M % 2 == 1)
                return MO3(B[M / 2], Math.max(A[0], B[M / 2 - 1]),
                           Math.min(A[1], B[M / 2 + 1]));
 
            
            return MO4(B[M / 2], B[M / 2 - 1],
                       Math.max(A[0], B[M / 2 - 2]),
                       Math.min(A[1], B[M / 2 + 1]));
        }
 
        int idxA = (N - 1) / 2;
        int idxB = (M - 1) / 2;
        if (A[idxA] <= B[idxB])
            return findMedianUtil(Arrays.copyOfRange(A, idxA, A.length),
                                  N / 2 + 1, B, M - idxA);
 
       
        return findMedianUtil(A, N / 2 + 1,
               Arrays.copyOfRange(B, idxB, B.length), M - idxA);
    }
    static float findMedian(int A[], int N, int B[], int M)
    {
        if (N > M)
            return findMedianUtil(B, M, A, N);
 
        return findMedianUtil(A, N, B, M);
    }
}
