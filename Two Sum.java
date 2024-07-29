class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> d = new HashMap<>();
        int i,complement;
        for (i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (d.containsKey(complement)) {
                return new int[]{d.get(complement), i};
            }
            d.put(nums[i], i);
        }
        
        return new int[0];
    }
}
