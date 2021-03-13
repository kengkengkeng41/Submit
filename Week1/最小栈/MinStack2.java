public class MinStack2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack2() {   //两栈数量可能不一致
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {  
        stack.push(x);
        if (!minStack.isEmpty()) {
            if (x <= minStack.peek())
                minStack.push(x);
        }else{
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        int top = minStack.peek();
        if (pop == top) //等于时再出栈
            minStack.pop(); 
        //不等时stack栈顶不是最小，而minStack栈顶为最小。
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
