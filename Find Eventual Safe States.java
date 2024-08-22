class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> reverseGraph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) reverseGraph.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                reverseGraph.get(j).add(i);
                indegree[i]++;
            }
        }
        
        for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : reverseGraph.get(node)) {
                if (--indegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0)   safeNodes.add(i);
        }
        
        return safeNodes;
    }
}
