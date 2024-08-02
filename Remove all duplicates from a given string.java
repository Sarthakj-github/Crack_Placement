class Solution {
    String removeDuplicates(String str) {
        Set<Character> s = new HashSet<>();
        String ans="";
        char p;
        for(int i=0;i<str.length();i++){
            p=str.charAt(i);
            if(s.contains(p))   continue;
            s.add(p);
            ans=ans+p;
        }
        return ans;
    }
}
