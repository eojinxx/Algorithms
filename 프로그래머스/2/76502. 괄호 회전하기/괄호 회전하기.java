import java.util.*;

class Solution {
    private static final HashMap<Character, Character> map = new HashMap<>();
    
    private static boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
            } else 
                stack.push(c);
        }
        
        return stack.isEmpty();
        
    }
    
    public int solution(String s) {
        int answer = 0;
        int p = s.length();
        String doubleS = s + s;
        map.put(']', '['); map.put(')', '('); map.put('}', '{');
        
        for (int i = 0; i < s.length(); i++) {
            String tmp = doubleS.substring(i, p + i);   
            if (isValid(tmp)) 
                answer++;
        }
        
        return answer;
    }
}