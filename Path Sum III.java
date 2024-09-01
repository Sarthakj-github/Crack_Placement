class Solution {
    private int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return ans;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root != null) {
            sumUp(root, 0, targetSum);
            traverse(root.left, targetSum);
            traverse(root.right, targetSum);
        }
    }

    private void sumUp(TreeNode root, int sum, int targetSum) {
        if (root != null) {
            sum = (sum+root.val)%(1000000007);
            if (sum == targetSum) ans++;
            sumUp(root.left, sum, targetSum);
            sumUp(root.right, sum, targetSum);
        }
    }
}
