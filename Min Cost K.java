class Solution {
    public int MinCoin(int[] nums, int k) {
        // Code here
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, cost = 0;
        while (i <= j) {
            cost += nums[i]; 
            j-=k;   i++;
        }
        return cost;
    }
}
