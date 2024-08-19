class Stack {
    ArrayDeque<Integer> deq;

    Stack() {
        deq = new ArrayDeque<>();
    }

    public void push(int x) {
        deq.addLast(x); // Add element to the end of the deque (acts as the top of the stack)
    }

    public int pop() {
        return deq.removeLast(); // Remove and return the last element (top of the stack)
    }

    public int top() {
        if (!deq.isEmpty()) {
            return deq.getLast(); // Return the last element without removing it (top of the stack)
        }
        return -1;
    }

    public boolean empty() {
        return deq.isEmpty(); // Check if the deque is empty
    }
}

class Queue {
    ArrayDeque<Integer> deq;

    Queue() {
        deq = new ArrayDeque<>();
    }

    public void enqueue(int x) {
        deq.addLast(x); // Add element to the end of the deque (acts as the back of the queue)
    }

    public int dequeue() {
        return deq.removeFirst(); // Remove and return the first element (front of the queue)
    }

    public int front() {
        if (!deq.isEmpty()) {
            return deq.getFirst(); // Return the first element without removing it (front of the queue)
        }
        return -1;
    }

    public boolean empty() {
        return deq.isEmpty(); // Check if the deque is empty
    }
}
