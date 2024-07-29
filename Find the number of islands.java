class Solution {
    int[][] directions = {{1,0},{0,1},{1,1},{-1,-1},{0,-1},{-1,0},{1,-1},{-1,1}};
    int m, n;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    cover(i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void cover(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            cover(newI, newJ);
        }
    }
}
