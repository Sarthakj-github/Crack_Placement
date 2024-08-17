import java.util.*;

class Solution {
    List<List<Integer>> L;
    int[] arr;
    List<Integer> l;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        arr = nums;
        L = new ArrayList<>();
        l = new ArrayList<>();
        n = nums.length;
        subsnd(0);
        return L;
    }

    void subsnd(int i) {
        if (i == n) {
            L.add(new ArrayList<>(l));
            return;
        }
        
        // Include the current element
        l.add(arr[i]);
        subsnd(i + 1);
        l.remove(l.size() - 1);

        // Exclude the current element
        while(i<(n-1) && arr[i]==arr[i+1])  i++;
        subsnd(i + 1);
    }
}
