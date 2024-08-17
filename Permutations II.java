class Solution {
    List<List<Integer>> L;
    int[] arr;
    boolean[] vis;
    List<Integer> l;
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        arr = nums;
        L = new ArrayList<>();
        l = new ArrayList<>();
        n = nums.length;
        vis = new boolean[n];
        premnd(0);
        return L;
    }

    void premnd(int i){
        if(i==n)    L.add(new ArrayList<>(l));
        else{
            int prev=11;
            for(int j=0;j<n;j++){
                if(!vis[j] && prev!=arr[j]){
                    l.add(arr[j]);
                    vis[j]=true;
                    premnd(i+1);
                    vis[j]=false;
                    l.remove(l.size()-1);
                    prev=arr[j];
                }
            }
        }
    }
}
