import java.util.*;

class Solution {
    private static int[] unf;    
    public int solution(int n, int[][] computers) {
        unf = new int[n];
        for (int i = 0; i < n; i ++) {
            unf[i] = i;
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) 
                    union(i, j);
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (unf[i] == i) ans++;
        }
        
        return ans;
    }
    
    private int find(int x) {
        if (unf[x] == x) return x;
        return unf[x] = find(unf[x]);
    }
    
    private void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a != b) unf[a] = b;
    }
}