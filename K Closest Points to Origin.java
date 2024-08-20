class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a max-heap (PriorityQueue with custom comparator) to store the closest points
        PriorityQueue<Pair<Integer, Integer>> Q = new PriorityQueue<>(
            (a, b) -> b.getKey() - a.getKey()
        );
        
        int n = points.length;
        int distance;

        for (int i = 0; i < n; i++) {
            // Calculate the squared distance (to avoid floating-point operations)
            distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            
            // If the heap has fewer than k elements, add the current point
            if (Q.size() < k) {
                Q.add(new Pair<>(distance, i));
            } 
            // If the current point is closer than the farthest point in the heap, replace the farthest
            else if (distance < Q.peek().getKey()) {
                Q.poll();
                Q.add(new Pair<>(distance, i));
            }
        }

        // Extract the k closest points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[Q.poll().getValue()];
        }

        return result;
    }
}
