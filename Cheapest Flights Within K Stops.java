class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] adj = new int[n][n];
        for (int[] f : flights) {
            adj[f[0]][f[1]] = f[2];
        }

        int[] vis = new int[n];
        Arrays.fill(vis,Integer.MAX_VALUE);
        
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{src, k + 1, 0});
        vis[src]=0;

        int M = Integer.MAX_VALUE;
        while (!Q.isEmpty()) {
            int[] q = Q.poll();
            int city = q[0], stops = q[1], cost = q[2];

            if (city == dst) {
                M = Math.min(M, cost);
            } else if (stops > 0) {
                for (int i = 0; i < n; i++) {
                    int p = cost + adj[city][i];
                    if (adj[city][i] > 0 && p < M && vis[i]>p) {
                        vis[i]=p;
                        Q.add(new int[]{i, stops - 1, cost + adj[city][i]});
                    }
                }
            }
        }

        return M == Integer.MAX_VALUE ? -1 : M;
    }
}
