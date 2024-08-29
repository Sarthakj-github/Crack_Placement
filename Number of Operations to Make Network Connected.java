class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < (n - 1)) return -1;

        // Create adjacency list
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Fill adjacency list
        for (int[] c : connections) {
            adj[c[0]].add(c[1]);
            adj[c[1]].add(c[0]);
        }

        boolean[] vis = new boolean[n];
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Queue<Integer> Q = new LinkedList<>();
                Q.add(i);
                vis[i] = true;
                while (!Q.isEmpty()) {
                    int q = Q.poll();
                    for (int a : adj[q]) {
                        if (!vis[a]) {
                            Q.add(a);
                            vis[a] = true;
                        }
                    }
                }
                c++;
            }
        }
        return c - 1;
    }
}
