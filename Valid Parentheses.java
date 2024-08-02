class Solution {
    public boolean isValid(String s) {
        Stack<Character> S = new Stack<>();
        char p;
        for(int i=0;i<s.length();i++){
            p=s.charAt(i);
            if(p=='}'){
                if(S.isEmpty() || S.peek()!='{')    return false;
                else    S.pop();
            }
            else if(p==')'){
                if(S.isEmpty() || S.peek()!='(')    return false;
                else    S.pop();
            }
            else if(p==']'){
                if(S.isEmpty() || S.peek()!='[')    return false;
                else    S.pop();
            }
            else    S.push(p);
        }
        return S.isEmpty();
    }
}
