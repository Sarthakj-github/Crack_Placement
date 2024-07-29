class Solution {
    public String addBinary(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        
        while (n >= 0 || m >= 0 || carry > 0) {
            int x = (n >= 0) ? a.charAt(n) - '0' : 0;
            int y = (m >= 0) ? b.charAt(m) - '0' : 0;
            
            int sum = x + y + carry;
            carry = sum / 2;
            ans.append(sum % 2);
            
            n--;
            m--;
        }
        
        return ans.reverse().toString();
    }
}
