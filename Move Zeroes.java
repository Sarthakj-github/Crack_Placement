class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length,j=0,i;
        for(i=0;i<n;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                if(j++!=i)    nums[i]=0;
            }
        }
    }
}
