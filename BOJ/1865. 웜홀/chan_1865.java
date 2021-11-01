import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 도로는 양의 가중치를 갖는 무향 그래프이고, 웜홀은 음의 가중치를 갖는 유향 그래프일 때 가중치의 합이 음수인 싸이클이 있는지 구해라
 * 
 * 입력 - 첫째줄 : 테케 수 TC - 각 테케의 첫째줄 : 지점의 수 N, 도로의 수 M, 웜홀의 개수 W - 각 테케의 둘째줄 ~ M +
 * 1째줄 : 도로의 정보 - 연결된 지점의 번호 S, E, 이 도로로 이동하는데 걸리는 시간 T - 각 테케의 M + 2째줄 ~ M + W
 * + 1째줄 : 웜홀의 정보 - 시작 지점 S, 도착 지점 E, 줄어드는 시간 T 출력 : 테케별 시간이 줄어들면서 출발 위치로 돌아오는 게
 * 가능하면 YES, 불가능하면 NO
 * 
 * @author chaeu
 *
 */
public class chan_1865 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 지점의 수
            int M = Integer.parseInt(st.nextToken()); // 도로의 수
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 개수
            int[][] matrix = new int[N + 1][N + 1]; // 각 지점에 대한 도로 정보 2차원 배열
            final int INF = 987654321;
            String ans = "NO";

            // 큰 값으로 초기화
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    matrix[i][j] = INF;
                }
            }

            // 도로 정보 입력 받기
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                // 기존 세팅된 값보다 작을 때만 새로 들어온 입력으로 세팅하기
                matrix[S][E] = Math.min(matrix[S][E], T);
                matrix[E][S] = Math.min(matrix[E][S], T);
            }

            // 웜홀 정보 입력 받기
            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine(), " ");
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                // 기존 세팅된 값보다 작을 때만 새로 들어온 입력으로 세팅하기
                matrix[S][E] = Math.min(matrix[S][E], T * (-1));
            }

            // 플로이드 와샬
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                // (i, i)가 음수라면 음의 싸이클 존재
                if (matrix[i][i] < 0)
                    ans = "YES";
            }

            System.out.println(ans);
        }
    }

}
