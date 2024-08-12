class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> d = new HashMap<>();
        
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String as = new String(charArray);
            
            d.putIfAbsent(as, new ArrayList<>());
            d.get(as).add(s);
        }
        
        for (List<String> group : d.values()) {
            ans.add(group);
        }
        
        return ans;
    }
}
