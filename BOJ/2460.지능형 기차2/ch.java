package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_2460_지능형기차2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            sum -= Integer.parseInt(st.nextToken());   // 내린 사람
            sum += Integer.parseInt(st.nextToken());   // 탄 사람
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
