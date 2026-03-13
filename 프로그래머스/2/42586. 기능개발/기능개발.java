import java.util.*;

class Node {
    private int progress;
    private int speed;
    
    public Node(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
    
    public int getProgress() {
        return this.progress;
    }
    
    public void plusProgress() {
        if (progress < 100)
            progress += speed;
    }
    
    public boolean isComplete() {
        return progress >= 100;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Node(progresses[i], speeds[i]));
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int cnt = 0;
            Node first = queue.peek();
            
            if (first.isComplete()) {
                boolean flag = true;
                for (Node cur : queue) {
                    
                    if (!cur.isComplete()) {
                        flag = false;
                    }
                    
                    if (flag) {
                        queue.poll();
                        cnt++;
                    } else {
                        cur.plusProgress();
                    }
                }
            } else {
                for (Node cur : queue) {
                    cur.plusProgress();
                }
            }
            
            if (cnt != 0)
                ans.add(cnt);
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}