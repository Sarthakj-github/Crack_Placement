class Solution {
    List<List<Integer>> L;
    int[] arr;
    List<Integer> l;
    public List<List<Integer>> subsets(int[] nums) {
        arr = nums;
        L = new ArrayList();
        l = new ArrayList();
        make_subs(0);
        return L;
    }

    void make_subs(int i){
        if(i==arr.length) L.add(new ArrayList<>(l));
        else{
            make_subs(i+1);
            l.add(arr[i]);
            make_subs(i+1);
            l.remove(l.size() - 1);
        }
    }
}
