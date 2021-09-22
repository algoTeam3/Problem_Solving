package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {
    static long[] memo;

    static long d(int n){
        if(n>=2&&memo[n]==0){
            memo[n]=d(n-1)+d(n-2);
        }
        return memo[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new long[n+1];
        memo[0]=0;
        memo[1]=1;
        System.out.println(d(n));
    }
}
