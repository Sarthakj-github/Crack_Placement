class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer,Integer> d = new HashMap();
        d.put(0,-1);
        int s=0,m=0;
        for(int i=0;i<n;i++){
            s+=arr[i];
            if(d.containsKey(s)){
                m=Math.max(m,i-d.get(s));
            }
            else{
                d.put(s,i);
            }
        }
        return m;
    }
}
