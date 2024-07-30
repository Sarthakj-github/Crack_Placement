class Solution {
    int[] vis;
    ArrayList<Integer> ans;
    ArrayList<ArrayList<Integer>> Adj;

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        vis = new int[V];
        Adj = adj;
        vis[0] = 1;
        dfs(0);
        return ans;
    }

    void dfs(int i) {
        ans.add(i);
        for (int j : Adj.get(i)) {
            if (vis[j] == 0) {
                vis[j] = 1;
                dfs(j);
            }
        }
    }
}
