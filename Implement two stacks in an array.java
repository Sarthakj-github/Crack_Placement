class twoStacks {
    int[] arr;
    int i,j;
    twoStacks() {
        arr=new int[100];
        i=0;j=99;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        arr[i++]=x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        arr[j--]=x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        if(i==0)    return -1;
        return arr[--i];
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        if(j==99)   return -1;
        return arr[++j];
    }
}
