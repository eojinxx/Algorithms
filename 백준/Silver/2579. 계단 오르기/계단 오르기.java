import java.util.*;

public class Main {
    static int[] dp;
    static int[] arr;
    static int solution(int n) {

        dp[1] = arr[1];
        
        if (n > 1)
            dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n));

    }
}
