import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	
	public static int N, min;
	public static boolean[] start, link;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// N명
		map = new int[N][N];					// 능력치
		start = new boolean[N];					// 스타트팀
		min = Integer.MAX_VALUE;				// 최솟값
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		// 출력
		System.out.println(min);
	}
	
	// 조합
	public static void comb(int n, int begin) {
		if (n == N/2) {
			link = new boolean[N];
			for (int i = 0; i < N; i++) {
                if (!start[i]) link[i] = true;
            }
            // 능력치 차이 구하기
            getDistance();
            return;
		}
		
		for (int i = begin; i < N; i++) {
			start[i] = true;
			comb(n + 1, i + 1);
			start[i] = false;
		}
	}
	
	// 능력치 차이 구하기
	public static void getDistance() {
		int sumStart = 0;
		int sumLink = 0;
		
		// start팀 능력치
		for (int i = 0; i < N; i++) {
			if (start[i]) {
	            for (int j = 0; j < N; j++) {
	                if (i != j && start[j]) {
	                	sumStart += map[i][j];
	                }
	            }
			}
        }
		
		// link팀 능력치
        for (int i = 0; i < N; i++) {
        	if (link[i]) {
	            for (int j = 0; j < N; j++) {
	                if (i != j && link[j]) {
	                	sumLink += map[i][j];
	                }
	            }
        	}
        }
        
        // 최솟값 갱신
        int dis = Math.abs(sumStart - sumLink);
        if (dis < min) min = dis;
	}
}
