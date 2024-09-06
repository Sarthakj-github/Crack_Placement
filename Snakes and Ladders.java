class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int dest = n * n - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n];
        queue.add(new int[]{0, 0}); // {position, moves}
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int pos = curr[0], moves = curr[1];
            
            if (pos == dest) return moves;

            for (int i = 1; i <= 6; i++) {
                int nextPos = pos + i;
                if (nextPos > dest) break;
                
                int[] coords = getBoardCoords(nextPos, n);
                int x = coords[0], y = coords[1];
                
                if (board[x][y] != -1) {
                    nextPos = board[x][y]-1;
                }
                
                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos, moves + 1});
                }
            }
        }
        return -1;
    }
    
    private int[] getBoardCoords(int pos, int n) {
        int row = n - 1 - pos / n;
        int col = ((n-row-1) % 2 == 0) ? pos % n : n - 1 - pos % n;
        return new int[]{row, col};
    }
}
