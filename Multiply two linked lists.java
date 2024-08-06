class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        long a=0,b=0,mod=1000000007;
        while(first!=null){
            a=(a*10+first.data)%mod;
            first=first.next;
        }
        while(second!=null){
            b=(b*10+second.data)%mod;
            second=second.next;
        }
        
        return (a*b)%mod;
    }
}
