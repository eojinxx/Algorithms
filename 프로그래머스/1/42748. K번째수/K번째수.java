import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        
        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0], j = commands[l][1], k = commands[l][2];
            
            int[] silcedArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(silcedArr);
            ans[l] = silcedArr[k - 1];
        }
        return ans;
    }
}