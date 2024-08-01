class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans  = new ArrayList();
        int n=nums.length+1;
        for(int i:nums){
            if(nums[i%n-1]/n == 1)    ans.add(i%n);
            else    nums[i%n-1]+=n;
        }
        return ans;
    }
}
