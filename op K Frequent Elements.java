class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> H = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        Map<Integer, Integer> d = new HashMap<>();

        for (int i : nums) {
            d.put(i, d.getOrDefault(i, 0) + 1);
        }

        for (int key : d.keySet()) {
            if (H.size() < k)
                H.add(new Pair<>(d.get(key), key));
            else if (H.peek().getKey() < d.get(key)) {
                H.poll();
                H.add(new Pair<>(d.get(key), key));
            }
        }

        int[] ans = new int[k];
        while (--k>=0) {
            ans[k] = H.poll().getValue();
        }
        return ans;
    }
}
