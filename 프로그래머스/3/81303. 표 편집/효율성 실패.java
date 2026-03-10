import java.util.*;

class Solution {
    /**
        n = 처음 표의 행의 개수
        k = 처음에 선택된 행의 위치를 나타내는 정수
        cmd = 명령어들이 담긴 배열
        리턴 값 = 삭제되지 않은 행(O), 삭제된 행(X)의 문자열 형태
        정확성: n^2 효율성 n*m 도 안될 듯?
    */
    
    private static boolean isLast(int[] table, int cur) {
        boolean flag = false;
        for (int i = cur + 1; i < table.length; i++) {
            if (table[i] == 0) {
                flag = true;
            }
        }
        
        if (flag) return false;
        else return true;
        
    }
    private static int moveCur(int[] table, String command, int cur, int size) {
        if (command.equals("U")) {
            while (size != 0 && cur >= 0) {
                if (table[cur - 1] == 0) {
                    cur -= 1;
                    size--;
                } else {
                    cur -= 1;
                }
            } 
        } else if (command.equals("D")) {
            while (size != 0 && cur <= table.length) {
                if (table[cur + 1] == 0) {
                    cur += 1;
                    size--;
                } else {
                    cur += 1;
                }
            } 
        }
        return cur;
		}
    
    public String solution(int n, int k, String[] cmd) {
        StringBuilder ans = new StringBuilder();
        int[] table = new int[n];
        int cur = k;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String str : cmd) {
            if (str.length() != 1) {
                String[] arr = str.split(" ");
                String command = arr[0];
                int size = Integer.parseInt(arr[1]);
                cur = moveCur(table, command, cur, size);
                
            } else {
                if (str.equals("C")) {
                    table[cur] = 1;
                    stack.push(cur);
                    if (isLast(table, cur)) {
                        cur = moveCur(table, "U", cur, 1);
                    } else {
                        cur = moveCur(table, "D", cur, 1);
                    }
                    
                } else if (str.equals("Z")) {
                    int deletedNum = stack.pop();
                    table[deletedNum] = 0;
                }
                
            }
        }
        
        for (int i : table) {
            if (i == 0) {
                ans.append("O");
            } else {
                ans.append("X");
            }
        }
        
        return ans.toString();
    }
}
