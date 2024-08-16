class Solution {
    Map<Integer, List<Integer>> d;
    int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        d = new HashMap<>();
        this.informTime = informTime;

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                d.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }
        }
        return bfs(headID);
    }

    int bfs(int root) {
        Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
        Q.add(new Pair<>(root, 0));

        int maxTime = 0;
        while (!Q.isEmpty()) {
            Pair<Integer, Integer> p = Q.poll();
            int currentNode = p.getKey();
            int currentTime = p.getValue();

            if (d.containsKey(currentNode)) {
                for (int i : d.get(currentNode)) {
                    Q.add(new Pair<>(i, informTime[currentNode] + currentTime));
                }
            }
            maxTime = Math.max(maxTime, currentTime);
        }
        return maxTime;
    }
}
