package problems.src.leetcode;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * User: chengyangwu
 * Date: 9/12/13
 * Time: 2:12 PM
 */
public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (A == null || A.length == 0) return res;
        res[0] = A.length;
        res[1] = -1;
        search(A, 0, A.length -1, target, res);
        if (res[0] == A.length && res[1] == -1) {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }

    public void search (int[] A, int l, int h, int target, int[] res) {
        if (l > h) return;
        int mid = (l + h)/2;
        if (A[mid] > target) search (A, l, mid - 1, target, res);
        else if (A[mid] < target) search (A, mid + 1, h, target, res);
        else {
            res[0] = Math.min(res[0], mid);
            res[1] = Math.max(res[1], mid);
            if (A[h] == target) res[1] = Math.max (res[1], h);
            else search (A, mid + 1, h, target, res);
            if (A[l] == target) res[0] = Math.min (res[0], l);
            else search (A, l, mid - 1, target, res);
        }
    }

    public int[] searchRange_iter(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (A == null || A.length == 0) return res;

        int l = 0, h = A.length - 1;
        while (l <= h) {
            int mid = (l+h)/2;
            if (A[mid] == target) {
                res[0] = mid;
                h = mid - 1;
            } else if (A[mid] > target) h = mid - 1;
            else l = mid + 1;
        }
        l = 0;
        h = A.length - 1;
        while (l <= h) {
            int mid = (l+h)/2;
            if (A[mid] == target) {
                res[1] = mid;
                l = mid + 1;
            } else if (A[mid] < target) l = mid + 1;
            else h = mid - 1;
        }

        return res;
    }
}
