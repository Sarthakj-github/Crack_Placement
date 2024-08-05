class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = (low <= root.val && root.val <= high)?root.val:0;
        if (root.left != null && low < root.val) sum += rangeSumBST(root.left, low, high);
        if (root.right != null && root.val < high) sum += rangeSumBST(root.right, low, high);
        return sum;
    }
}
