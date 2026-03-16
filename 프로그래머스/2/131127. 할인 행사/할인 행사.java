import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> dis10d = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    dis10d.put(discount[j], dis10d.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if (dis10d.equals(wantMap))
                ans++;
        }
        
        return ans;
    }
}