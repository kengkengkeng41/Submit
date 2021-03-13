import java.util.Deque;

import javax.lang.model.util.ElementScanner14;

public class Solution3 {  //ASCII码法
    public boolean isValid(String s) {
        if(s=="") return true;
        Deque<Character> stack = new ArrayDeque<Character>();
        for (char c:s.toCharArray()) {
            if (stack.isEmpty()==true)
                stack.push(c);
            else if (c-stack.peek()==1 || c-stack.peek()==2)
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
