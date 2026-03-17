import java.util.*;

// 중복 닉네임 허용
// return: 최종적으로 방을 개설한 사람이 보게되는 문자열 배열
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> idToNick = new HashMap<>();
        // Id와 Command 보관
        List<String[]> logs = new ArrayList<>();


        for (String line : record) {
            String[] info = line.split(" ");
            String command = info[0];
            String uid = info[1];
            
            if (command.equals("Enter") || command.equals("Change")) {
                idToNick.put(uid, info[2]);
            }
            
            if (command.equals("Enter") || command.equals("Leave")) {
                logs.add(new String[] {uid, command});
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {
            String uid = logs.get(i)[0];
            String command = logs.get(i)[1];
            String nickname = idToNick.get(uid);
            
            if (command.equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }


        return answer;
    }
}