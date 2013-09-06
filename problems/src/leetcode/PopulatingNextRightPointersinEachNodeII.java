package problems.src.leetcode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *      1
 *     /  \
 *    2    3
 *   / \    \
 *  4   5    7
 * After calling your function, the tree should look like:
 *      1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \    \
 *  4-> 5 -> 7 -> NULL
 *
 * User: chengyangwu
 * Date: 8/29/13
 * Time: 5:31 PM
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;

        TreeLinkNode cur = root;
        cur.next = null;
        while (cur != null) {
            TreeLinkNode node = cur;
            TreeLinkNode tmp = null;
            while (node != null) {
                if (node.left != null && node.right != null) {
                    node.left.next = node.right;
                    if (tmp != null) tmp.next = node.left;
                    tmp = node.right;
                } else if (node.left != null) {
                    if (tmp != null) tmp.next = node.left;
                    tmp = node.left;
                } else if (node.right != null) {
                    if (tmp != null) tmp.next = node.right;
                    tmp = node.right;
                }

                node = node.next;
            }
            if (tmp != null) tmp.next = null;
            node = cur;
            while (node != null) {
                cur = (node.left != null) ? node.left : node.right;
                if (cur != null) break;
                node = node.next;
            }

        }
    }

    public void connect_method2 (TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;

        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode nextHead = null;
            TreeLinkNode pre = null;

            for (; cur != null; cur = cur.next) {
                if (nextHead == null) nextHead = (cur.left != null) ? cur.left : cur.right;
                if (cur.left != null) {
                    if (pre != null) pre.next = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) pre.next = cur.right;
                    pre = cur.right;
                }
            }
            cur = nextHead;
        }
    }
}
