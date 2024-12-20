
    
import java.util.Scanner;

public class Q2 {
    public static int maxPathSum(int[][] matrix, int n, int m) {
    
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
      
                int down = dp[i - 1][j]; 
                int leftDiag = (j - 1 >= 0) ? dp[i - 1][j - 1] : 0; // Diagonally left
                int rightDiag = (j + 1 < m) ? dp[i - 1][j + 1] : 0; // Diagonally right

                dp[i][j] = matrix[i][j] + Math.max(down, Math.max(leftDiag, rightDiag));
            }
        }

        
        int maxSum = 0;
        for (int j = 0; j < m; j++) {
            maxSum = Math.max(maxSum, dp[n - 1][j]);
        }

        return maxSum;
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int t = 0; t < T; t++) {
          
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

           
            int result = maxPathSum(matrix, n, m);
            System.out.println(result);
        }

        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }
}
    

