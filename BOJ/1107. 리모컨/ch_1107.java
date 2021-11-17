import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_1107{
    static int N, M, ans;
    static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];   // 버튼 체크 배열
        if (M != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        ans = Math.abs(N - 100);    // 채널 100번 초기 설정
        for (int i = 0; i <= 999999 ; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean flag = false;   // 고장 버튼 체크
            for (int j = 0; j < len; j++) {
                // 고장 버튼 누를 시
                if (broken[str.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans = Math.min(Math.abs(N - i) + len, ans);
            }
        }
        System.out.println(ans);
    }
}
