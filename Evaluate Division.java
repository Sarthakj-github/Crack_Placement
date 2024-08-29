class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, ArrayList<Pair<String, Double>>> graph = new HashMap<>();

        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];
            
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, value));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, 1.0 / value));
        }

        double[] ans = new double[queries.size()];
        Arrays.fill(ans, -1.0);
        
        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
                continue;
            }

            Queue<Pair<String, Double>> Q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Q.add(new Pair<>(start, 1.0));
            visited.add(start);

            while (!Q.isEmpty()) {
                Pair<String, Double> p = Q.poll();
                String current = p.getKey();
                double currentProduct = p.getValue();

                if (current.equals(end)) {
                    ans[i] = currentProduct;
                    break;
                }

                for (Pair<String, Double> neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor.getKey())) {
                        visited.add(neighbor.getKey());
                        Q.add(new Pair<>(neighbor.getKey(), currentProduct * neighbor.getValue()));
                    }
                }
            }
        }
        
        return ans;
    }
}
