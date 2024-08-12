class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> d = new HashMap<>();
        
        for (String s : string_list) {
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
