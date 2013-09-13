package problems.src.leetcode;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:18 PM
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = A.length - 1;
        while (i >= 0) {
            if (A[i] != i + 1 && A[i] - 1 < A.length && A[i] - 1 >= 0 && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else i--;
        }
        for (i = 0; i < A.length; i ++)
            if (A[i] != i + 1) return i + 1;

        return A.length + 1;
    }
}
