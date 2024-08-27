class Solution {
    int[][] L = {{0,1},{1,0},{-1,0},{0,-1}};
    int n;
    int[][] grid;
    Queue<int[]> Q;
    
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        Q = new LinkedList<>();

        for (int i = 0; i < n && Q.isEmpty(); i++)
            for (int j = 0; j < n && Q.isEmpty(); j++)
                if (grid[i][j] == 1) dfs(i,j);
        
        while (!Q.isEmpty()) {
            int[] p = Q.poll();
            for (int[] l : L) {
                int ni = p[0] + l[0], nj = p[1] + l[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                    if (grid[ni][nj] == 0) Q.add(new int[]{ni, nj, p[2] + 1});
                    if (grid[ni][nj] == 1) return p[2];
                    grid[ni][nj] = -1;
                }
            }
        }
        return -1;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = -1; Q.add(new int[]{i, j, 0});
        for (int[] l : L) dfs(i + l[0], j + l[1]);
    }
}
