import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for (String s : record) {
            String[] token = s.split(" ");
            if (!token[0].equals("Leave")) {
                map.put(token[1], token[2]);
            }
        }
        
        for (String s : record) {
            String[] token = s.split(" ");
            if (!token[0].equals("Change")) {
                String verb = token[0].equals("Enter") ? "들어왔습니다." : "나갔습니다.";
                ans.add(map.get(token[1]) + "님이 " + verb);
            }
        }
        
        return ans.toArray(String[]::new);
    }
}