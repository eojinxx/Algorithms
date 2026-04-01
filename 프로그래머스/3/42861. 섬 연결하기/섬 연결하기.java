import java.util.*;

class Solution {
    private static int[] unf;
    
    private static int find(int x) {
        if (unf[x] == x) return x;
        else return unf[x] = find(unf[x]);
    }
    
    private static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) unf[a] = b;
    }
    
    public int solution(int n, int[][] costs) {
        // Arrays.sort 는 바구니에 있는 요소들을 하나씩 꺼내어 비교한다. 근데 2차원 배열의 바구니에는 1차원 배열이 있으므로 o1가 o2는 1차원 배열이다.
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        unf = new int[n];
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }
        
        int answer = 0;
        int edges = 0;
        
        for (int[] edge : costs) {
            if (edges == n - 1) break;
            
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        
        return answer;
    }
}