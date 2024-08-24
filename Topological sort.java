class Solution {
    // Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inord = new int[V]; // Array to keep track of in-degrees
        int[] result = new int[V]; // Array to store the topological order

        // Calculate in-degree (number of incoming edges) for each vertex
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                inord[j]++;
            }
        }

        Queue<Integer> Q = new LinkedList<>();

        // Add all vertices with 0 in-degree to the queue
        for (int i = 0; i < V; i++) {
            if (inord[i] == 0) {
                Q.add(i);
            }
        }

        int index = 0; // Index for result array

        // Perform BFS
        while (!Q.isEmpty()) {
            int a = Q.poll();
            result[index++] = a; // Add the vertex to the result array
            
            for (int p : adj.get(a)) {
                inord[p]--;
                if (inord[p] == 0) {
                    Q.add(p);
                }
            }
        }

        return result;
    }
}
