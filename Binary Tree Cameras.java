// -1->need camera
 // 0->don't need
 // 1->have camera

class Solution {
    int c=0;
    public int minCameraCover(TreeNode root) {
        if(trav(root)==-1)  this.c+=1;
        return this.c;
        
    }
    public int trav(TreeNode root){
        if(root!=null){
            int a = trav(root.left);
            int b = trav(root.right);
            if(a==-1 || b==-1){
                this.c+=1;
                return 1;
            }
            if(a==1 || b==1)    return 0;
            else return -1;
        }
        return 0;
    }
}
