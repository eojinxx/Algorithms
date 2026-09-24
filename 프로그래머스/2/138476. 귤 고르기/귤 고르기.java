import java.util.*;

class Solution {
    int ans = 1;
    
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());
        
        for (int i : list) {
            if (i >= k) break;
            k -= i;
            ans++;
        }
        
        return ans;
    }
}