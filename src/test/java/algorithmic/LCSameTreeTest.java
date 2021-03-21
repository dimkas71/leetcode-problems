package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("""
        Given the roots of two binary trees p and q, write a function
        to check if they are the same or not.
                
        Two binary trees are considered the same if they are structurally identical,
        and the nodes have the same value.
        Example 1:
        Input: p = [1,2,3], q = [1,2,3]
        Output: true
        Example 2:

        Input: p = [1,2], q = [1,null,2]
        Output: false
        Example 3:
                
        Input: p = [1,2,1], q = [1,1,2]
        Output: false
        """)
class LCSameTreeTest {

    @DisplayName("""
            Test trees without leaves
            """)
    @Test
    void testTreesWithoutLeaves() {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        TreeNode m = new TreeNode(2);

        Assertions.assertTrue(isSameTree(p, q));
        Assertions.assertFalse(isSameTree(p, m));

    }

    @DisplayName("""
            TreeNodes with null values should be the same
            """)
    @Test
    void testNullTreeNodes() {
        Assertions.assertTrue(isSameTree(null, null));
    }

    @DisplayName("""
            Treenodes 2 and null should be false
            """)
    @Test
    void testOneNodeIsNull() {
        Assertions.assertFalse(isSameTree(new TreeNode(2), null));
    }

    @DisplayName("""
        Example 1:
        Input: p = [1,2,3], q = [1,2,3]
        Output: true
            """)
    @Test
    void example1() {
        TreeNode p = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));
        TreeNode q = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));

        Assertions.assertTrue(isSameTree(p, q));
    }

    @DisplayName("""
        Example 2:

        Input: p = [1,2], q = [1,null,2]
        Output: false
            """)
    @Test
    void example2() {
        TreeNode p = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2, null, null));
        Assertions.assertFalse(isSameTree(p, q));
    }

    @DisplayName("""
        Example 3:
                
        Input: p = [1,2,1], q = [1,1,2]
        Output: false
            """)
    @Test
    void example3() {
        TreeNode p = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(1, null, null));
        TreeNode q = new TreeNode(1, new TreeNode(1, null, null), new TreeNode(2, null, null));

        Assertions.assertFalse(isSameTree(p, q));
    }

    @DisplayName("""
            Input
            [0,-5]
            [0,-8]
            Output
            true
            Expected
            false
            """)
    @Test
    void failedLeetCodeTest() {
        TreeNode p = new TreeNode(0, new TreeNode(-5, null, null), null);
        TreeNode q = new TreeNode(0, new TreeNode(-8, null, null), null);
        Assertions.assertFalse(isSameTree(p, q));

    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (q == null && p != null)) return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {this(0, null, null);}
    TreeNode(int val) {this(val, null, null);}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
