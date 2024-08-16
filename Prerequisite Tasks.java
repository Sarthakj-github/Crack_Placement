class Solution {
    Map<Integer, ArrayList<Integer>> d;
    boolean[] vis;

    public boolean isPossible(int N, int P, int[][] prerequisites) {
        d = new HashMap<>();
        vis = new boolean[N];
        
        // Building the graph
        for (int[] p : prerequisites) {
            d.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }
        
        // Checking for cycles
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                if (!complete(i, new boolean[N])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean complete(int i, boolean[] visited) {
        visited[i] = true;
        if (d.containsKey(i)) {
            for (int j : d.get(i)) {
                if (!vis[j]) {
                    if (visited[j] || !complete(j, visited)) {
                        return false;
                    }
                }
            }
        }
        vis[i] = true;
        visited[i] = false;
        return true;
    }
}
