class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val && match(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean match(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) {
            return true;
        }
        if (root == null || sub == null || root.val != sub.val) {
            return false;
        }
        return match(root.left, sub.left) && match(root.right, sub.right);
    }
}
