class Solution {
    public int maxProfit(int[] prices) {
        int j=0,i,n=prices.length,m=0;
        for(i=1;i<n;i++){
            if(prices[i]<prices[j]) j=i;
            else
                m=Math.max(m,prices[i]-prices[j]);
        }
        return m;
    }
}
