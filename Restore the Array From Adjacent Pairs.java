class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = adjacentPairs.length;

        // Build adjacency list
        for (int[] pair : adjacentPairs) {
            adj.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int[] result = new int[n + 1];
        // Find the starting element (it has only one adjacent pair)
        for (int key : adj.keySet()) {
            if (adj.get(key).size() == 1) {
                result[0] = key;
                result[1] = adj.get(key).get(0);
                break;
            }
        }

        // Fill the rest of the array
        for (int i = 2; i <= n; i++) {
            int next = adj.get(result[i - 1]).get(0) == result[i - 2] ? adj.get(result[i - 1]).get(1) : adj.get(result[i - 1]).get(0);
            result[i] = next;
        }

        return result;
    }
}
