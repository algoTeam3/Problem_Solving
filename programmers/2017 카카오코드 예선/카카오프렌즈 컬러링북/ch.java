import java.util.*;

class ch {
    public static int maxSizeOfOneArea;
    public static boolean[][] visited;

    public static int[][] copy;

    public int[] solution(int m, int n, int[][] picture) {
        maxSizeOfOneArea = 0;
        int numberOfArea = 0;
        visited = new boolean[m][n];
        int[] answer = new int[2];
        copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = picture[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] != 0 && !visited[i][j]){
                    bfs(i, j, copy);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void bfs(int x, int y, int[][] copy) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        int cnt = 1;
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            x = arr[0];
            y = arr[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= copy.length || ny >= copy[0].length) continue;
                if (copy[nx][ny] == copy[x][y] && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        if (cnt > maxSizeOfOneArea) maxSizeOfOneArea = cnt;
    }
}