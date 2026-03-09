import java.util.*;

class Solution {
    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) 
                    return false;
                
                if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else return false;
                    
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else return false;
                    
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        int p = s.length();
        String doubleS = s + s;
        
        for (int i = 0; i < s.length(); i++) {
            String tmp = doubleS.substring(i, p + i);   
            if (isValid(tmp)) 
                answer++;
        }
        
        return answer;
    }
}