import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        for (String s : report) {
            String[] tmp = s.split(" ");
            String reporter = tmp[0];
            String reportee = tmp[1];
            
            map.computeIfAbsent(reportee, x -> new HashSet<>()).add(reporter);
        }
        
        int[] ans = new int[id_list.length];
        
        map.entrySet().stream()
            .filter(o -> o.getValue().size() >= k)
            .forEach(o -> {
                for (int i = 0; i < id_list.length; i++) {
                    if (o.getValue().contains(id_list[i])) {
                        ans[i] += 1;
                    }
                }
            });
        
        return ans;
    }
}