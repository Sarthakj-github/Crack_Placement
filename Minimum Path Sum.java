class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!(i==0 && j==0))
                    grid[i][j] += Math.min((j!=0?grid[i][j-1]:Integer.MAX_VALUE),(i!=0?grid[i-1][j]:Integer.MAX_VALUE));
            }
        }
        return grid[m-1][n-1];
    }
}
