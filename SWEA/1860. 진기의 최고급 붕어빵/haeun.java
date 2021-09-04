import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SW_D3_1860_진기의최고급붕어빵 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());        // 테스트케이스
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());   // 자격을 얻은 N명의 사람
            int M = Integer.parseInt(st.nextToken());   // M초의 시간
            int K = Integer.parseInt(st.nextToken());   // K개의 붕어빵
            String result = "Possible";
             
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
             
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            // 먼저 온 사람 순서대로 정렬
            Arrays.sort(arr);
             
            // 붕어빵이 만들어지기 전에 온다면
            if (arr[0] < M) result = "Impossible";
            else {
                // 먹은 사람 수
                int people = 0;
                // 붕어빵 개수
                int cnt = 0;
                // 붕어빵이 만들어지는 시간
                outer: for (int i = M; ; i+=M) {
                    // 만들어진 붕어빵의 개수
                    cnt += K;
                    while (arr[people] < i+M) {
                        people++;
                        if (cnt == 0) {
                            result = "Impossible";
                            break outer;
                        }
                        cnt--;
                        // 사람들이 다 먹으면 반복문 탈출
                        if (people >= N) break outer;
                    }
                     
                }
            }
            // 출력
            System.out.printf("#%d %s\n", tc, result);
        }
    }
}
