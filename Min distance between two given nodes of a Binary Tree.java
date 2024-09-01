class GfG {
    private int ans;
    int findDist(Node root, int a, int b) {
        // Your code here
        ans = -1;
        trav(root, a, b);
        return ans;
    }

    private int[] trav(Node root, int a, int b) {
        if (root == null) return new int[]{0, 0}; // No nodes found
        
        int[] left = trav(root.left, a, b);
        int[] right = trav(root.right, a, b);
        
        int count = (root.data == a ? 1 : 0) + (root.data == b ? 1 : 0) + left[0] + right[0];
        
        if (count == 2 && ans == -1) {
            ans = left[1] + right[1]; // Update minimum distance
        }
        
        return new int[]{count, (count > 0 ? left[1] + right[1] + 1 : 0)};
    }
}
