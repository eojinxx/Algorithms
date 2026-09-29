import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] ans = new int[enroll.length];
        HashMap<String, String> graph = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < referral.length; i++) {
            graph.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int propit = amount[i] * 100;
            String current = seller[i];
            
            while (!current.equals("-") && propit > 0) {
                int parentPropit = propit / 10;
                int myPropit = propit - parentPropit;
                
                map.put(current, map.getOrDefault(current, 0) + myPropit);
                current = graph.get(current);
                propit = parentPropit;
            }
        }
        
        ans = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            ans[i] = map.getOrDefault(enroll[i], 0);
        }
        
        return ans;
    }
}