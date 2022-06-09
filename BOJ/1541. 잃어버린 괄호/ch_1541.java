import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 최대한 큰 수를 빼야한다.
 * 덧셈 먼저 계산 후 빼기
 */
public class ch_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int sum = Integer.MAX_VALUE;

        while (st.hasMoreTokens()){
            int temp = 0;

            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");

            while (add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }

            // 첫 번째 수 판별
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            }else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
