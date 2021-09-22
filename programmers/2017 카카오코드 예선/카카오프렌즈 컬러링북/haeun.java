import java.util.*;

class Solution {
    public static int maxSizeOfOneArea;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        maxSizeOfOneArea = 0;
        arr = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = picture[i][j];
            }
        }

       for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    numberOfArea++;
                }
            }
        }
        
        // 출력
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    // bfs
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            x = temp[0];
            y = temp[1];
            // 4방 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) continue;
                if (arr[nx][ny] == arr[x][y] && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        // 최댓값 구하기
        if (cnt > maxSizeOfOneArea) maxSizeOfOneArea = cnt;
    }
}
