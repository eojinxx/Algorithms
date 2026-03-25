import java.util.*;

class Solution {
    // return: 각 유저가 받은 정지 피드백 메일 수를 담은 배열
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> feedBackCnt = new HashMap<>();
        
        
        // 신고 받은 유저 목록을 저장
        for (String s : report) {
            String[] tmp = s.split(" ");
            String reporter = tmp[0];
            String respondent = tmp[1];
            
            if (!reportMap.containsKey(respondent)) {
                reportMap.put(respondent, new HashSet<>());
            }
            reportMap.get(respondent).add(reporter);
        }
        
        // 피드백 횟수를 유저 별로 저장
        for (String s : id_list) {
            if (reportMap.containsKey(s) && reportMap.get(s).size() >= k) {
                HashSet<String> tmp = reportMap.get(s);
                for (String ss : tmp) {
                    feedBackCnt.put(ss, feedBackCnt.getOrDefault(ss, 0) + 1);
                }
            }
        }
        /**
        reportedMap.entrySet().stream().map(Map.Entry<String, HashSet<String>>::getValue).forEach(set -> {
            if (set.size() >= k) {
                for (String s : set) {
                    count.put(s, count.getOrDefault(s, 0) + 1);
                }
            }
        });
        */
        
        int[] answer = new int[id_list.length];
        
        // 피드백 횟수를 배열에 저장
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            if (feedBackCnt.containsKey(reporter)) {
                answer[i] = feedBackCnt.get(reporter);
            } 
        }
        
        return answer;
    }
}
