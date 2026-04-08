import java.util.*;

class Solution {
    
    // 막다른 노드인 경우 생각
    private static void dfs(String now) {
        while (map.containsKey(now) && !map.get(now).isEmpty()) {
            dfs(map.get(now).poll());    
        }
        
        answer.add(now);
    }
    private static HashMap<String, PriorityQueue<String>> map;
    private static ArrayList<String> answer;
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<>());
            }
            
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        
        
        dfs("ICN");
        Collections.reverse(answer);
        return answer.toArray(String[]::new);
    }
}
