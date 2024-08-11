class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> S = new Stack<>();
        int n=num.length();
        for(int i=0;i<n;i++){
            while(k!=0 && !S.isEmpty() && S.peek()>num.charAt(i)){
                S.pop();    k--;
            }
            if(!S.isEmpty() || num.charAt(i)!='0')    S.push(num.charAt(i));
        }
        
        String ans="";
        while(!S.isEmpty()){
            char p = S.pop();
            if(k!=0)    k--;
            else    ans = p+ans;
        }

        if(ans=="")  return "0";
        return ans;
    }
}
