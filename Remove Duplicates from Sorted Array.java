class Solution {
    public int removeDuplicates(int[] nums) {
        int i,n=nums.length,j=1;
        for(i=1;i<n;i++){
            if(nums[i]!=nums[i-1])  nums[j++]=nums[i];
        }
        return j;
    }
}
