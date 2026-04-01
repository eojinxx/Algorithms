import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        boolean flag = false;
        int count = 1;
        int uid = 0;
        
        set.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            uid = (i % n) + 1;
            if (uid == 1) count++;
            
            String now = words[i];
            String before = words[i - 1];
            
            if (now.charAt(0) != before.charAt(before.length() - 1)) {
                flag = true;
                break;
            }
            
            if (set.contains(now)) {
                flag = true;
                break;
            } else {
                set.add(now);
            }
            
            
        }
        
        if (flag) return new int[] {uid, count};
        else return new int[] {0,  0};
    }
}