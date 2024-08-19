class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        Queue<int[]> Q = new LinkedList<>();
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int n = grid.length, m = grid[0].length;
        int freshOranges = 0;
        
        // Add all rotten oranges to the queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    Q.add(new int[]{i, j, 0});  // Include the time step (0 initially)
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // If there are no fresh oranges, return 0
        if (freshOranges == 0) return 0;
        
        int time = 0;
        
        // BFS to spread the rot to adjacent fresh oranges
        while (!Q.isEmpty()) {
            int[] current = Q.poll();
            int i = current[0], j = current[1], currentTime = current[2];
            
            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                    grid[x][y] = 2;  // Mark the orange as rotten
                    freshOranges--;  // Reduce the count of fresh oranges
                    Q.add(new int[]{x, y, currentTime + 1});
                    time = currentTime + 1;  // Update time with the last time step
                }
            }
        }
        
        // If there are still fresh oranges left, return -1
        return freshOranges == 0 ? time : -1;
    }
}
