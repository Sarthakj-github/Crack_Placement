class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        int n=nums.length,c=0;
        long[] ans = new long[n];
        long mul=1;
        for(int i:nums){
            if(i==0) c++;
            else mul*=i;
        }
        for(int i=0;i<n;i++){
            if(c>1) ans[i]=0;
            else if(nums[i]==0) ans[i]=mul;
            else ans[i]=c==0?(long) mul/nums[i]:0;
        }
        return ans;
    }
