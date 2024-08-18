class Solution {
    int[] arr;
    public TreeNode sortedArrayToBST(int[] nums) {
        arr = nums;
        return make_bst(0,nums.length-1);
    }

    TreeNode make_bst(int l,int r){
        if(l>r) return null;
        int m = (l+r)/2;
        TreeNode node = new TreeNode(arr[m]);
        node.left = make_bst(l,m-1);
        node.right = make_bst(m+1,r);
        return node;
    }
}
