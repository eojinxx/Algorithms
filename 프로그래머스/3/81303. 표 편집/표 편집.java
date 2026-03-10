import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Deque<Integer> deleted = new ArrayDeque<>();
        
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        // 현재 위치를 나타내는 인덱스
        k++;
        for (String c : cmd) {
            if (c.startsWith("C")) {    
                deleted.push(k);     
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                // 현재 행이 마지막일 경우 
                k = n < down[k] ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] ans = new char[n];
        Arrays.fill(ans, 'O');
        
        for (int i : deleted) {
            ans[i - 1] = 'X';
        }
        
        return new String(ans);
    }
}