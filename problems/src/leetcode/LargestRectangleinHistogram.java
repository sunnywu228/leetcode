package problems.src.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:44 PM
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> is = new Stack<Integer> ();
        int[] h = Arrays.copyOf(height, height.length + 1);
        h[height.length] = 0;
        int i = 0;
        int max = 0;
        while (i < h.length) {
            if (is.isEmpty() || h[is.peek()] < h[i]) is.push(i ++);
            else {
                int tmp = is.pop();
                max = Math.max(max, h[tmp] * (is.isEmpty() ? i : i - is.peek() - 1));
            }
        }

        return max;
    }
}
