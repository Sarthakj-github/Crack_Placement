class Solution {
    public String decodeString(String s) {
        Stack<String> S = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char p = s.charAt(i);
            if (p == ']') {
                StringBuilder ans = new StringBuilder();
                while (!S.peek().matches("\\d+")) {
                    ans.insert(0, S.pop());
                }
                int k = Integer.parseInt(S.pop());
                String repeated = ans.toString().repeat(k);
                S.push(repeated);
            } else if (Character.isDigit(p)) {
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }
                i--;
                S.push(num.toString());
            } else if (p != '[') {
                S.push(String.valueOf(p));
            }
        }

        StringBuilder result = new StringBuilder();
        for (String str : S) {
            result.append(str);
        }

        return result.toString();
    }
}
