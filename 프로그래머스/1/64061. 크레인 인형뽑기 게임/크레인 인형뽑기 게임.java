import java.util.*;
// 사라진 인형의 개수를 리턴 (점수 x) 한 번 사라질 때 2개씩
/**
    1. 크레인을 보드의 위치로 이동시킨다.
    2. 보드의 있는 데이터를 확인한다.(없을 경우 아무런 일도 일어나지 않음)
    3. 잡은 데이터를 스택에 담는다.
    4. 연속해서 같은 데이터의 경우 스택에서 없애고 1점을 올린다.
*/
class Solution {
    private static int answer = 0;
    private static Deque<Integer> stack = new ArrayDeque<>();
    
    private static void putBucket(int d) {
        if (!stack.isEmpty() && stack.peek() == d) {
            stack.pop();
            answer += 2;
        } else {
            stack.push(d);
        }
    }
    
    public int solution(int[][] board, int[] moves) {
        for (int i : moves) {
            int p = i - 1;
            
            for (int j = 0; j < board.length; j++) {
                if (board[j][p] != 0) {
                    int d = board[j][p];
                    board[j][p] = 0;
                    putBucket(d);
                    break;
                }
            }
        }
        
        return answer;
    }
}