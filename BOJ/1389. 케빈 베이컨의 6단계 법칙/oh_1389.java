

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_1389 {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //map 생성
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                map[i][j] = INF;
            }
        }

        //값 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1;
            map[to][from] = 1;
        }

        //플로이드
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        //출력
        int min = Integer.MAX_VALUE;
        int answer=0;
        for (int i = 1; i <= N; i++) {
        int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum+=map[i][j];
            }
            if(min>sum){
                min=sum;
                answer=i;
            }
        }
        System.out.println(answer);
    }
}
