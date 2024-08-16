class Pair<u,v>{
    int first,second;
    Pair(int u,int v){
        first=u;
        second=v;
    }
}

class Solution {
    boolean[] vis;
    ArrayList<ArrayList<Integer>> Adj;

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[V];
        Adj = adj;
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfsCheckCycle(i)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean bfsCheckCycle(int start) {
        Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(start, -1));
        vis[start] = true;
        
        while (!Q.isEmpty()) {
            int node = Q.peek().first;
            int parent = Q.peek().second;
            Q.poll();

            for (int neighbor : Adj.get(node)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    Q.add(new Pair<>(neighbor, node));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
