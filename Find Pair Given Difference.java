class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int i=0,j=1,diff;
        while(i<n && j<n){
            diff=arr[j]-arr[i];
            if(diff==x && i!=j) return 1;
            else if(diff<x) j++;
            else    i++;
        }
        return -1;
        
    }
}
