import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2468.안전영역
 */
public class oh_2468 {
    static int N, count;
    static int[][] map;
    static int[][] visit;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new int[N][N];
        Set set = new HashSet();
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int num = Integer.parseInt(st.nextToken());
                map[r][c] = num;
                set.add(num);
            }
        }
        //큐에 넣기
        PriorityQueue<Integer> que = new PriorityQueue<>(set);
        ArrayList<Integer> answer = new ArrayList<>();
        while (!que.isEmpty()) {
            int rain = que.poll();
            //침수 지역 설정
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] < rain) {//침수
                        visit[i][j] = -1;
                    } else {
                        visit[i][j] = 0;
                    }
                }
            }
            //안전지역 확인
            count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == 0) {
                        bfs(i, j);
                    }
                }
            }
            answer.add(count);
        }
        int max = answer.stream().max((o1, o2) -> o1-o2).orElse(0);
        System.out.println(max);

    }

    private static void bfs(int r, int c) {
        count++;
        visit[r][c]=count;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{r,c});

        while (!queue.isEmpty()){
            Integer[] z = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nr = z[0] + dir[i][0];
                int nc = z[1] + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visit[nr][nc] == 0) {
                    visit[nr][nc] = count;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }
    }
}
