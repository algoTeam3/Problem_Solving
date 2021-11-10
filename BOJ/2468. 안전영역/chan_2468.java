import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chan_2468 {
    static int N;
    static int[][] area;
    static boolean[][] safeArea;
    static boolean[] height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans = 1; // 물에 잠기지 않는 경우 안전한 영역은 하나(전 영역)이므로 1로 초기화
        area = new int[N][N];
        height = new boolean[101];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                height[area[i][j]] = true;
            }
        } // 입력 받기 완료

        for (int i = 1; i < 101; i++) {
            // i 높이에 해당하는 영역이 있을 때,
            if (height[i]) {
                // 그 높이를 초과하는 높이의 영역들을 true 처리
                safeArea = new boolean[N][N];
                floodedArea(i);
                // 지역에서 안전한 영역 개수 찾기
                int count = bfs();
                // 안전한 영역의 수가 가장 큰 경우를 저장하기
                ans = Math.max(count, ans);
            }
        }

        System.out.println(ans);
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!safeArea[i][j])
                    continue;

                queue.offer(new int[] { i, j });
                safeArea[i][j] = false;
                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    // 사방탐색
                    for (int d = 0; d < 4; d++) {
                        int nx = current[0] + dx[d];
                        int ny = current[1] + dy[d];

                        // 범위체크
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                            continue;
                        // 방문체크
                        if (!safeArea[nx][ny])
                            continue;
                        // 이동 가능한 곳 일 때, 큐에 추가하고, 이동시간 1 추가
                        queue.add(new int[] { nx, ny });
                        safeArea[nx][ny] = false;
                    }
                }
                count++;
            }
        }

        return count;
    }

    private static void floodedArea(int height) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (height < area[i][j]) {
                    safeArea[i][j] = true;
                }
            }
        }
    }
}
