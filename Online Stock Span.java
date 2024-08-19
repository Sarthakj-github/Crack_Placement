class StockSpanner {
    Stack<int[]> S;
    public StockSpanner() {
        S = new Stack();
    }
    
    public int next(int price) {
        int c = 1;
        while(!S.isEmpty() && S.peek()[0]<=price){
            c+=S.pop()[1];
        }
        S.push(new int[]{price,c});
        return c;
    }
}
