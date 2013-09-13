package problems.src.leetcode;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:19 PM
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) return 0;

        int[] left = new int[A.length], right = new int[A.length];
        left[0] = 0;
        right[A.length - 1] = 0;
        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i - 1], A[i - 1]);
            right[A.length - 1 - i] = Math.max(right[A.length - i], A[A.length - i]);
        }

        int area = 0;
        for (int i = 0; i < A.length; i ++) {
            int height = Math.min(left[i], right[i]) - A[i];
            area += height > 0 ? height : 0;
        }
        return area;
    }

    public int trap_constant_space(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) return 0;

        int tallest = 0;
        for (int i = 0; i < A.length; i ++) {
            if (A[i] > A[tallest]) tallest = i;
        }

        int area = 0;
        int l = 0;
        for (int i = 0; i < tallest; i ++) {
            if (l > A[i]) area += l - A[i];
            else l = A[i];
        }
        int h = 0;
        for (int i = A.length - 1; i > tallest; i --) {
            if (h > A[i]) area += h - A[i];
            else h = A[i];
        }

        return area;
    }
}
