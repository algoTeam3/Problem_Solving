import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	public static int N, M, cnt;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] map, melt;
	public static boolean[][] checked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 행
		M = Integer.parseInt(st.nextToken());	// 열
		
		checked = new boolean[N][M];
		melt = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
        while (true) {
        	cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (checked[i][j] == false && map[i][j] != 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            
            // 출력
            if (cnt == 0) {
                System.out.println(0);
                break;
            } else if (cnt >= 2) {
                System.out.println(year);
                break;
            }
            melt();
            year++;
        }
    }
	
	// dfs
    public static void dfs(int x, int y){
    	// 방문 체크
        checked[x][y] = true;
        // 4방탐색
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (map[nx][ny] == 0) melt[x][y]++;
            if (!checked[nx][ny] && map[nx][ny] != 0) dfs(nx, ny);
        }
    }
    
    // 빙산이 녹을 때
    public static void melt(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = map[i][j] - melt[i][j];
                if (map[i][j] < 0) map[i][j] = 0;
                checked[i][j] = false;
                melt[i][j] = 0;
            }
        }
    }
}
