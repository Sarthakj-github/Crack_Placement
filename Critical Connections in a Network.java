class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ans = new ArrayList<>();
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (List<Integer> l : connections) {
            int a = l.get(0), b = l.get(1);
            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(0, adj, new int[n], -1,1);
        return ans;
    }

    int dfs(int i, ArrayList<Integer>[] adj, int[] vis, int par,int d) {
        vis[i] = d;
        int minVisit = vis[i];

        for (int j : adj[i]) {
            if (vis[j] == 0) {
                int dfsResult = dfs(j, adj, vis, i,d+1);
                if (dfsResult < minVisit) {
                    minVisit = dfsResult;
                }
            } else if (j != par) {
                minVisit = Math.min(minVisit, vis[j]);
            }
        }

        if (par != -1 && minVisit == vis[i]) {
            ans.add(Arrays.asList(par, i));
        }

        vis[i] = minVisit;
        return minVisit;
    }
}
