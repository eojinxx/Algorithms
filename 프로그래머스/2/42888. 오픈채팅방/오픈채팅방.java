import java.util.*;

// 중복 닉네임 허용
// return: 최종적으로 방을 개설한 사람이 보게되는 문자열 배열
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
            ArrayList<String> ans = new ArrayList<>();
            HashMap<String, String> map = new HashMap<>();


            for (String s : record) {
                String[] arr = s.split(" ");

                if (arr[0].equals("Enter")) {
                    map.put(arr[1], arr[2]);
                    ans.add(arr[1] + "님이 들어왔습니다.");
                    

                } else if (arr[0].equals("Leave")) {
                    ans.add(arr[1] + "님이 나갔습니다.");

                } else if (arr[0].equals("Change")) {
                    map.put(arr[1], arr[2]);
                }
            }

            for (String s : ans) {
                String[] ss = s.split("님");
                answer.add(map.get(ss[0]) + "님"+ ss[1]);
            }


            return answer.toArray(String[]::new);
    }
    
    
}