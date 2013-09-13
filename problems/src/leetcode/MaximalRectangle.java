package problems.src.leetcode;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 * User: chengyangwu
 * Date: 9/9/13
 * Time: 10:43 PM
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null || matrix.length == 0) return 0;

        int[][] onesLeft = new int[matrix.length][matrix[0].length];
        int count = 0;
        // fill onesLeft
        for (int i = 0; i < matrix.length; i ++) {
            count = 0;
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == '1') onesLeft[i][j] = ++count;
                else {
                    onesLeft[i][j] = 0;
                    count = 0;
                }
            }
        }

        // calculate
        int max = 0, width = 0, height = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                width = onesLeft[i][j];
                height = 0;
                int k = 0;
                while (k <= i && onesLeft[i-k][j] != 0) {
                    width = Math.min(width, onesLeft[i-k][j]);
                    height = k + 1;
                    max = Math.max(max, width * height);
                    k++;
                }
            }
        }

        return max;
    }
}
