class Solution {
    public int majorityElement(int[] nums) {
        int ans = nums[0], c = 1;
        for (int i = 1; i < nums.length; i++) {
            ans = c == 0 ? nums[i] : ans;
            c += (nums[i] == ans) ? 1 : -1;
        }
        return ans;
    }
}
