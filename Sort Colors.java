class Solution {
    public void sortColors(int[] nums) {
        
        int n=nums.length;
        int i=0,j=n-1,k=0,t;
        while(i<=k && k<=j){
            if(nums[k]==0){
                t=nums[k];  nums[k]=nums[i];    nums[i++]=t;
            }
            if(nums[k]==2){
                t=nums[k];  nums[k]=nums[j];    nums[j--]=t;
            }
            if(nums[k]==1 || k<i)   k++;
        }
    }
}
