package BOJ.14938.서강그라운드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 요구사항 : 낙하한 지역을 중심으로 거리가 수색범위 이내의 모든 지역의 아이템을 습득할 수 있을 때, 얻을 수 있는 아이템의 최대 개수를
 * 구해라.
 */
public class chan_14938 {

    static int M, N, R;
    static int[] items, dist;
    static int[][] map;
    static boolean[] visited;
    static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        items = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        map = new int[N][N];
        dist = new int[N];
        for (int i = 0; i < N; i++) { // 출발지
            for (int j = 0; j < N; j++) { // 도착지
                if (i != j) {
                    map[i][j] = 31;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int length = Integer.parseInt(st.nextToken());
            map[start][end] = map[end][start] = length;
        }

        for (int k = 0; k < N; k++) { // 경유지
            for (int i = 0; i < N; i++) { // 출발지
                for (int j = 0; j < N; j++) { // 도착지
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int ans = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= M) {
                    max += items[j];
                }
            }
            ans = Math.max(max, ans);
        }
        System.out.println(ans);
    }

}
