class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        Arrays.fill(par,-1);
        int[] rank = new int[n+1];

        int[] ans = new int[n];
        for(int[] e:edges){
            if(union(e[0],e[1],par,rank))   ans=e; 
        }

        return ans;
    }

    int find(int x,int[] par){
        while(par[x]!=-1)
            x=par[x];
        return x;
    }

    boolean union(int a,int b,int[] par,int[] rank){
        int ap = find(a,par);
        int bp = find(b,par);

        if(ap==bp)  return true;

        if(rank[ap]!=rank[bp]){
            if(rank[ap]>rank[bp])   par[bp]=ap;
            else    par[ap]=bp;
        }

        else{
            rank[ap]++; par[bp]=ap;
        }
        
        return false;
    }
}
