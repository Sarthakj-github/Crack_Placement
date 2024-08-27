class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj_mat = new int[n][n];

        // Initialize adjacency matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj_mat[i], Integer.MAX_VALUE);
            adj_mat[i][i] = 0; // Distance from a node to itself is 0
        }

        // Fill the adjacency matrix with given edges
        for (int[] e : edges) {
            adj_mat[e[0]][e[1]] = adj_mat[e[1]][e[0]] = e[2];
        }

        // Apply Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj_mat[i][k] != Integer.MAX_VALUE && adj_mat[k][j] != Integer.MAX_VALUE) {
                        adj_mat[i][j] = Math.min(adj_mat[i][j], adj_mat[i][k] + adj_mat[k][j]);
                    }
                }
            }
        }
        
        int ans = 0, minReachableCities = n;

        // Find the city with the smallest number of reachable cities within the distance threshold
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (adj_mat[i][j] <= distanceThreshold) reachableCities++;
            }
            if (reachableCities <= minReachableCities) {
                ans = i;
                minReachableCities = reachableCities;
            }
        }
        
        return ans;
    }
}
