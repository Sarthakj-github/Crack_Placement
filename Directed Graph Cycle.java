class Solution {
    ArrayList<ArrayList<Integer>> Adj;
    boolean[] vis;

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Adj = adj;
        vis = new boolean[V];
        
        boolean[] pathVis = new boolean[V]; // Tracks nodes in the current DFS path
        
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfsCheckCycle(i, pathVis)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsCheckCycle(int node, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (int neighbor : Adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfsCheckCycle(neighbor, pathVis)) {
                    return true;
                }
            } else if (pathVis[neighbor]) {
                return true;
            }
        }

        pathVis[node] = false; // Unmark the node in the current DFS path
        return false;
    }
}
