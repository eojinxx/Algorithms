class Solution {
    private int[] unf;
    public int solution(int n, int[][] wires) {
        unf = new int[n + 1];
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int cnt = 0;
            
            for (int l = 1; l <= n; l++) {
                unf[l] = l;
            }
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                if (find(wires[j][0]) != find(wires[j][1])) {
                    union(wires[j][0], wires[j][1]);
                }
            }
            
            int root = find(1);
            for (int k = 1; k <= n; k++) {
                if (root == find(k)) cnt++;
            }
            
            ans = Math.min(ans, Math.abs(n - cnt - cnt));
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
        if (a != b) unf[a] = b;
    }
}