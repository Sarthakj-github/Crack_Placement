class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        int i=0,j=m-1;
        long ans=Long.MAX_VALUE;
        while(j<n){
            ans=Math.min(ans,a.get(j++)-a.get(i++));
        }
        return ans;
    }
}
