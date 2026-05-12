import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.naturalOrder());
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i].length() > phone_book[i + 1].length()) continue;
            int len = phone_book[i].length();
            String s = phone_book[i + 1].substring(0, len);
            
            if (phone_book[i].equals(s)) return false;
        }
        
        return true;
    }
}