class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr,-1);
        arr[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j:coins){
                int p=i-j;
                if(p>=0 && arr[p]!=-1)
                    arr[i]=Math.min(arr[i]!=-1?arr[i]:amount,arr[p]+1);
            }
        }
        return arr[amount];
    }
}
