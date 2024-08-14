class MyStack {
    Queue<Integer> Q;
    public MyStack() {
        Q = new LinkedList<>();
    }
    
    public void push(int x) {
        Q.add(x);
    }
    
    public int pop() {
        int n=Q.size()-1;
        while(n--!=0){
            Q.add(Q.poll());
        }
        return Q.poll();
    }
    
    public int top() {
        int n=Q.size()-1;
        while(n--!=0){
            Q.add(Q.poll());
        }
        int p = Q.peek();
        Q.add(Q.poll());
        return p;
    }
    
    public boolean empty() {
        return Q.isEmpty();
    }
}
