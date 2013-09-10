package problems.src.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * User: chengyangwu
 * Date: 9/8/13
 * Time: 6:08 PM
 */
public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 1) return 1;
        int num = 0;
        for (int i = 1; i <= n; i ++) {
            if (i == 1 || i == n) num += numTrees(n - 1);
            else num += numTrees(i - 1) * numTrees(n - i);
        }
        return num;
    }

    public int numTrees_iter(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n + 1];

        num[0] = 1;
        if (n > 0) num[1] = 1;

        for (int i = 2; i < n + 1; i ++) {
            for (int j = 0; j < i; j ++) {
                num[i] += num[j] * num[i - j - 1];
            }
        }

        return num[n];
    }
}
