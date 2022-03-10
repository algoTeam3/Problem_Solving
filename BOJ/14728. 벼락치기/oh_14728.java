
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int t =Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][t + 1];

        int[] k = new int[n+1];
        int[] s = new int[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            k[i]=Integer.parseInt(st.nextToken());
            s[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(j>=k[i]){
                    dp[i][j]=Math.max(s[i]+dp[i-1][j-k[i]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];

                }
            }
        }
        System.out.println(dp[n][t]);
    }
}
