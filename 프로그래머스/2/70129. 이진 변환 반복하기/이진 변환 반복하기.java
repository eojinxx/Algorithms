import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int deleteCnt = 0;
        
        while (!s.equals("1")) {
            String str = "";
            int n = s.length();
            
            for (char c : s.toCharArray()) {
                if (c == '1') str += c;
            }
            
            deleteCnt += n - str.length();
            
            int len = str.length();
            String tmp = "";
            
            while (len > 1) {
                tmp += len % 2;
                len /= 2;
            }
            
            if (len == 1) tmp += len;
            
            s = "";
            for (int i = tmp.length() - 1; i >= 0; i--) {
                s += tmp.charAt(i);
            }
            
            cnt++;
            
        }
        
        return new int[] {cnt, deleteCnt};
    }
}