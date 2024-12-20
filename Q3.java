
    
import java.util.Scanner;

public class Q3 {
    public static int coinChangeCombinations(int[] coins, int target) {
        // DP array, dp[i] stores the number of ways to make amount i
        int[] dp = new int[target + 1];

        // There is exactly 1 way to make amount 0 (choosing no coins)
        dp[0] = 1;

        // Process each coin one by one
        for (int coin : coins) {
            // Update dp[i] for all i >= coin
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }

        // The result is the number of ways to make the target amount
        return dp[target];
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        System.out.print("Enter the number of test cases: ");
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            // Read number of coins and target
            System.out.print("Enter the number of coins and the target: ");
            int n = sc.nextInt();
            int target = sc.nextInt();

            // Read coin denominations
            System.out.print("Enter the coin denominations: ");
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = sc.nextInt();
            }

            // Compute and print the result for the current test case
            int result = coinChangeCombinations(coins, target);
            System.out.println(result);
        }

        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
    

