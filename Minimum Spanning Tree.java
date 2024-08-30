class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<int[]> Q = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int i=0;i<V;i++){
            for(int[] e:adj.get(i)){
                Q.add(new int[]{e[1],i,e[0]});
            }
        }
        
        int[] par = new int[V];
        Arrays.fill(par,-1);
        int[] rank = new int[V]; 
        
        int ans=0;
        while(!Q.isEmpty()){
            int[] q = Q.poll();
            if(union(q[1],q[2],par,rank))  ans+=q[0];  
        }
        return ans;
    }
    
    static int find(int x,int[] par){
        while(par[x]!=-1)
            x=par[x];
        return x;
    }
    
    static boolean union(int a,int b,int[] par,int[] rank){
        int ap = find(a,par);
        int bp = find(b,par);
        
        if(ap==bp)  return false;
        
        if(rank[ap]>=rank[bp])
            par[bp]=ap;
        else
            par[ap]=bp;
        if(rank[ap]==rank[bp]) rank[ap]++;
        
        return true;
    }
}
