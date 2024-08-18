class Solution {
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        paths(root, String.valueOf(root.val));
        return ans;
    }

    void paths(TreeNode root, String S) {
        if (root.left == null && root.right == null) {
            ans.add(S);
        } else {
            if (root.left != null) {
                paths(root.left, S + "->" + root.left.val);
            }
            if (root.right != null) {
                paths(root.right, S + "->" + root.right.val);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
