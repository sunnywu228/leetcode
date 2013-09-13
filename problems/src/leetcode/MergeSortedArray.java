package problems.src.leetcode;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 * You may assume that A has enough space to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:38 PM
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = m + n - 1;
        m --;
        n --;

        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) A[i--] = A[m--];
            else A[i--] = B[n--];
        }

        if (m < 0) {
            while (n >= 0) {
                A[n] = B[n];
                n--;
            }
        }
    }
}
