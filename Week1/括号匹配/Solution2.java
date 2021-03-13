import java.util.Deque;

public class Solution2 {  //栈
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(char c:s.toCharArray()) {
            if (c == '(') stack.push(')'); //遇左压右，便于比较
            else if (c=='[') stack.push(']');
            else if (c=='{') stack.push('}');
            else if (stack.isEmpty() || stack.pop()!=c)
                return false;
        }
        return stack.isEmpty();
    }
}
