class MyQueue {
    Stack<Integer> S1,S2;
    public MyQueue() {
        S1 = new Stack(); 
        S2 = new Stack();
    }
    
    public void push(int x) {
        while(!S1.isEmpty()){
            S2.push(S1.pop());
        }
        S2.push(x);
        while(!S2.isEmpty()){
            S1.push(S2.pop());
        }
    }
    
    public int pop() {
        return S1.pop();
    }
    
    public int peek() {
        return S1.peek();
    }
    
    public boolean empty() {
        return S1.isEmpty();
    }
}
