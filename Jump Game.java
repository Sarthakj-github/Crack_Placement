class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int m=0;
        for(int i=0;i<(n-1);i++){
            m=Math.max(m,nums[i]+i);
            if(m==i)    return false;
        }
        return true;
    }
}
