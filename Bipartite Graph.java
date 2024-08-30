class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] vis = new int[V];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<V;i++){
            if(vis[i]!=-1) continue;
            
            vis[i]=0;
            Queue<Integer> Q = new LinkedList();
            Q.add(i);

            while(!Q.isEmpty()){
                int q = Q.poll();
                for(int a:adj.get(q)){
                    if(vis[a]==vis[q])  return false;
                    if(vis[a]==-1){
                        Q.add(a);
                        vis[a]=vis[q]^1;
                    }
                }
            }
        }
        return true;
    }
}
