import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        
        // 최초상태 초기화
        char prevWord = words[0].charAt(0);
        
        for (int i = 0; i < words.length; i++) { 
            if (set.contains(words[i]) || prevWord != words[i].charAt(0)) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            
            set.add(words[i]);
            prevWord = words[i].charAt(words[i].length() - 1);
        }
        
        return new int[] {0, 0};
    }
}
