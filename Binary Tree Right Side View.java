class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root==null)  return ans;
        Queue<Pair<TreeNode,Integer>> Q = new LinkedList();
        Q.add(new Pair<>(root,0));

        Pair<TreeNode,Integer> p;
        TreeNode t;
        int c;

        while(!Q.isEmpty()){
            p = Q.poll();
            t = p.getKey();
            c = p.getValue();

            if(ans.size()==c) ans.add(t.val);
            
            if(t.right!=null)   Q.add(new Pair<>(t.right,c+1));
            if(t.left!=null)   Q.add(new Pair<>(t.left,c+1));
        }

        return ans;
    }
}
