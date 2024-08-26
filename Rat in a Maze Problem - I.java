class Solution {
    ArrayList<String> ans;
    int[][] maze;
    int[][] L = {{1,0,4},{0,-1,12},{0,1,18},{-1,0,21}};
    int n;
    
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ans = new ArrayList();
        maze = mat;
        n = mat.length-1;
        if(mat[0][0]==1 && mat[n][n]==1){
            mat[0][0]=0;
            trav(0,0,"");
        }
        return ans;
    }
    
    void trav(int i,int j,String s){
        if(i==n && j==n){
            ans.add(s);
            return;
        }
        
        for(int[] l:L){
            i+=l[0];    j+=l[1];
            if(0<=i && 0<=j && i<=n && j<=n && maze[i][j]==1){
                maze[i][j]=0;
                trav(i,j,s+ (char)(64+l[2]));
                maze[i][j]=1;
            }
            i-=l[0];    j-=l[1];
        }
        
    }
}
