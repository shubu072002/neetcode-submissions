class MinStack {

   Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack= new Stack<>();
    }
    public void push(int val) {
    
     if(minStack.isEmpty() || minStack.peek()>=val){
         minStack.push(val);
     }
      stack.push(val);
    }

    public void pop() {
       int poppedValue = stack.pop();
    if (poppedValue == minStack.peek())
      minStack.pop();
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return minStack.peek();
}
    }

