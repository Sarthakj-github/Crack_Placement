class Solution {
    // Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // If the knight is already at the target position
        if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1])
            return 0;

        int[][] vis = new int[N + 1][N + 1];
        int[][] L = {{-1, 2}, {1, 2}, {-2, -1}, {-2, 1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}};

        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{KnightPos[0], KnightPos[1], 0});
        vis[KnightPos[0]][KnightPos[1]] = 1;

        while (!Q.isEmpty()) {
            int[] q = Q.poll();

            for (int[] l : L) {
                int nx = q[0] + l[0],ny = q[1] + l[1]steps = q[2] + 1;

                // Check if the new position is within bounds and not visited
                if (nx > 0 && ny > 0 && nx <= N && ny <= N && vis[nx][ny] == 0) {
                    // If the knight reaches the target position
                    if (nx == TargetPos[0] && ny == TargetPos[1])
                        return steps;

                    Q.add(new int[]{nx, ny, steps});
                    vis[nx][ny] = 1;
                }
            }
        }
        return -1;
    }
}
