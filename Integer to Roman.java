class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> d = new HashMap<>() {{
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }};

        int t = 1,n;
        String ans = "";

        while (num > 0) {
            n = num % 10;
            if (n == 4 || n == 9) {
                ans = d.get(1 * t) + d.get((n + 1) * t) + ans;
            } else {
                while (n!=5 && n!=0) {
                    ans = d.get(1 * t) + ans;
                    n--;
                }
                if(n==5)    ans=d.get(5*t)+ans;
            }
            num /= 10;
            t *= 10;
        }
        return ans;
    }
}
