import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class chan_2644 {
    static int N, S, E, M;
    static int[][] family;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 전체 사람의 수
        String[] data = br.readLine().split(" ");
        S = Integer.parseInt(data[0]); // 촌수를 계산해야 하는 첫번째 사람
        E = Integer.parseInt(data[1]); // 촌수를 계산해야 하는 두번째 사람
        M = Integer.parseInt(br.readLine()); // 부모-자식 관계의 개수
        family = new int[N + 1][N + 1]; // 가족 관계 이차원 배열
        ans = new int[N + 1]; // 촌 수를 계산할 일차원 배열
        for (int m = 0; m < M; m++) {
            data = br.readLine().split(" ");
            int p = Integer.parseInt(data[0]);
            int c = Integer.parseInt(data[1]);

            family[p][c] = family[c][p] = 1;
        }

        System.out.println(bfs(S, E));
    }

    private static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 기저조건 : end에 해당하는 사람까지 도달했으면 end와의 촌수를 리턴
            if (cur == end)
                return ans[end];
            for (int i = 1; i <= N; i++) {
                // 방문 체크
                if (visited[i])
                    continue;
                // 관계 체크
                if (family[cur][i] == 0)
                    continue;
                // 방문한적없고, 관계가 있으면 큐에 넣고 촌수 1 증가
                queue.offer(i);
                visited[i] = true;
                ans[i] = ans[cur] + 1;
            }
        }
        // start와 end 관계가 없으면 촌수 계산 불가
        return -1;
    }

}
