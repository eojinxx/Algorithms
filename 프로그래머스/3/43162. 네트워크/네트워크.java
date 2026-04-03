class Solution {
    
    private static int[] unf;
    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) unf[a] = b;
    }
    
    private static int find(int x) {
        if (unf[x] == x) return x;
        else return unf[x] = find(unf[x]);
    }
    public int solution(int n, int[][] computers) {
        unf = new int[computers.length];
        for (int i = 0; i < computers.length; i++) {
            unf[i] = i;
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < unf.length; i++) {
            if (unf[i] == i) answer++;
        }
        return answer;
    }
}