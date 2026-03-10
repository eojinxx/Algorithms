import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int c = stack.pop();
                ans[c] = i - c;
            }
            stack.push(i);
        }
        
        int t = stack.peek();
        
        while (!stack.isEmpty()) {
            int i = stack.removeFirst();
            ans[i] = t - i;
        }
        
        return ans;
    }
}