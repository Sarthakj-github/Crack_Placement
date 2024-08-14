class Solution {
    // Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S) {
        Stack<Integer> St = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
            char p = S.charAt(i);
            
            if (p == '*' || p == '+' || p == '-' || p == '/') {
                int b = St.pop();
                int a = St.pop();
                switch (p) {
                    case '+':
                        St.push(a + b);
                        break;
                    case '-':
                        St.push(a - b);
                        break;
                    case '*':
                        St.push(a * b);
                        break;
                    case '/':
                        St.push(a / b);
                        break;
                }
            }
            else{
                St.push(p - '0');
            }
        }
        
        return St.pop();
    }
}
