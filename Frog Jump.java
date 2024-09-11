class Solution {
    public boolean canCross(int[] stones) {

        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0);

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int jump : dp.get(stone)) {
                for (int k = jump - 1; k <= jump + 1; k++) {
                    if (k > 0 && dp.containsKey(stone + k)) {
                        dp.get(stone + k).add(k);
                    }
                }
            }
        }
        
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
