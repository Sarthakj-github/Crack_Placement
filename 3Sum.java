class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i : nums) {
            d.put(i, d.getOrDefault(i, 0) + 1);
        }
        int n = nums.length;

        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < (n - 2); i++) {
            for (int j = i + 1; j < (n - 1); j++) {
                int third = -nums[i] - nums[j];
                if (d.containsKey(third)) {
                    int s = (third == nums[i]?1:0) + (third == nums[j]?1:0);
                    if (d.get(third)>s) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                        Collections.sort(triplet);
                        ans.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
