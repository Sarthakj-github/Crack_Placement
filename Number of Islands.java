class Solution {
    boolean[][] vis;
    char[][] map;
    int m,n;
    int[][] L = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        map = grid;
        int c=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]=='1' && !vis[i][j]){
                    cover(i,j);
                    c++;
                }
        return c;

        
    }
    void cover(int i,int j){
        vis[i][j]=true;
        int a,b;
        for(int[] l:L){
            a=i+l[0];   b=j+l[1];
            if(0<=a && a<m && 0<=b && b<n && map[a][b]=='1' && !vis[a][b])  cover(a,b);
        }
    }
}
