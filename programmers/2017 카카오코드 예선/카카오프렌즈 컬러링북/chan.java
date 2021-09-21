import java.util.*;

class chan {
    static int[][] book;  // 컬러링북 2차원배열
    static boolean[][] visited; // 색 방문 체크 배열
    static int M, N, maxSizeOfOneArea;  // 그림의 세로크기, 가로크기, 가장 큰 영역의 넓이
    public int[] solution(int m, int n, int[][] picture) {
        M = m; 
        N = n;
        int numberOfArea = 0;
        maxSizeOfOneArea = 0;

        book = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                book[i][j] = picture[i][j];
            }
        }   // 입력받기 완료
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 0은 영역에 포함 안되므로, 0이 아니고, 방문하지 않은 공간을 bfs 탐색
                if (book[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    numberOfArea++; // 영역의 개수 1씩 증가
                }
            }
        } 
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int value = book[x][y];   // 현재 탐색할 공간의 색 정보
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;  // bfs 탐색을 할 영역의 칸을 셀 변수(처음 큐에 넣은 색부터니까 1로 초기화)
        while(!q.isEmpty()) {
            int[] current = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                // 방문 체크
                if (visited[nx][ny]) continue;
                // 같은 색상인지 체크
                if (book[nx][ny] != value) continue;
                // 같은 색이고, 방문하지 않았던 칸이면
                q.offer(new int[] {nx, ny});  // 큐에 넣고
                visited[nx][ny] = true;       // 방문 체크
                count++;    // 탐색중인 영역의 칸의 수 1 증가시키기
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count); // bfs 탐색 끝나면 탐색한 영역의 칸 수가 최대 크기인지 확인하기
    }
}
