class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V]; 
        int i=0;    ans.add(0); vis[0]=true;
        while(i<ans.size()){
            for(Integer a:adj.get(ans.get(i)))
                if(!vis[a]){
                    ans.add(a);
                    vis[a]=true;
                }
            i++;
        }
        return ans;
    }
}
