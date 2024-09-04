class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key

        while(root!=null && root.data!=key){
            if(key<root.data){
                suc[0]=root;
                root=root.left;
            }
            else{
                pre[0]=root;
                root=root.right;
            }
        }
        
        if(root==null)  return;
        
        if(root.left!=null){
            pre[0]=root.left;
            while(pre[0].right!=null)
                pre[0]=pre[0].right;
        }
        
        if(root.right!=null){
            suc[0]=root.right;
            if(suc[0]!=null)
                while(suc[0].left!=null)
                    suc[0]=suc[0].left;
        }
        
    }
}
