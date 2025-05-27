import java.util.*;

class Solution {
    boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char cur : s.toCharArray()) {
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) return false;
                
                char target = stack.pop();
                if ((target == '(' && cur != ')') ||
                    (target == '{' && cur != '}') ||
                    (target == '[' && cur != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public int solution(String s) {
        String doubleS = s + s;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(doubleS.substring(i, i + s.length()))) answer++;
        }
        return answer;
    }
}