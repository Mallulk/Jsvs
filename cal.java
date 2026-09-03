import java.util.Scanner;

public class cal {

    static int claim(int n) {
        if (n <= 2) {
            return n;
        }

        return claim(n - 1) + claim(n - 2);
    }

    static int claimstrais(int n) {
        if (n <= 2) {
            return n;
        }

        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(claim(50));
        System.out.println(claimstrais(50));
    }
}