class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char p = s.charAt(i);

            if (!stack.isEmpty() && stack.peek()[0] == p) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{p, 1});
            }
        }

        StringBuilder result = new StringBuilder();
        for (int[] pair : stack) {
            result.append(String.valueOf((char) pair[0]).repeat(pair[1]));
        }

        return result.toString();
    }
}
