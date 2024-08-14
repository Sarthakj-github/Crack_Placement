class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> S = new Stack();
        int n=temperatures.length-1;
        int[] ans = new int[n+1];
        while(n>=0){
            while(!S.isEmpty() && temperatures[n]>=temperatures[S.peek()])
                S.pop();
            if(!S.isEmpty())    ans[n]=S.peek()-n;
            S.push(n--);
        }
        return ans;
    }
}
