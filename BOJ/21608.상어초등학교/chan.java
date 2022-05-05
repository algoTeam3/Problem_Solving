import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 
 * 풀이 : 자리를 배치하는 조건 세 가지를 Comparable 정렬로 처리하기
 *
 */
public class chan {
	static class Seat implements Comparable<Seat> {

		int r; int c; int likeCnt; int emptyCnt;
		public Seat(int r, int c, int likeCnt, int emptyCnt) {
			this.r = r; this.c = c; this.likeCnt = likeCnt; this.emptyCnt = emptyCnt;
		}
		
		@Override
		public int compareTo(Seat o) {
			// 인접한 칸에 좋아하는 학생이 많은 순
			if (o.likeCnt != this.likeCnt) return o.likeCnt - this.likeCnt;
			// 인접한 칸 중 빈 칸이 가장 많은 순
			if (o.emptyCnt != this.emptyCnt) return o.emptyCnt - this.emptyCnt;
			// 행의 번호가 가장 작은 순
			if (this.r != o.r) return this.r - o.r;
			// 열의 번호가 가장 작은 순
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] classRoom = new int[N][N];
		boolean[][] emptySeat = new boolean[N][N];
		int[][] likes = new int[N * N + 1][4];
		ArrayList<Integer> list = new ArrayList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[] satisfaction = {0, 1, 10, 100, 1000};
		int answer = 0;
		
		for (int n = 0; n < N * N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			list.add(curr);
			for (int k = 0; k < 4; k++) {
				likes[curr][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 순서대로 학생 자리 배치
		for (int i = 0; i < list.size(); i++) {
			int curr = list.get(i);
			ArrayList<Seat> possibleSeats = new ArrayList<>();
			// N*N개의 자리 중에서
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
				
					// 자리가 비어있지 않을 때
					if (classRoom[r][c] != 0) continue;
					// 자리가 비어있을 때 인접한 칸 탐색
					int lCnt = 0;
					int eCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nx = dx[d] + r;
						int ny = dy[d] + c;
						if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
						// 인접한 칸에 좋아하는 학생이 있을 때
						for (int k = 0; k < 4; k++) {
							if (likes[curr][k] == classRoom[nx][ny]) lCnt++;
						}
						// 인접한 칸 중 빈칸 수
						if (classRoom[nx][ny] == 0) eCnt++;
					}
					possibleSeats.add(new Seat(r, c, lCnt, eCnt));
				}
			}
			Collections.sort(possibleSeats);
			Seat currSeat = possibleSeats.get(0);
			classRoom[currSeat.r][currSeat.c] = curr;
		}
		
		// 만족도 구하기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int curr = classRoom[r][c];
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = dx[d] + r;
					int ny = dy[d] + c;
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					// 인접한 칸에 좋아하는 학생이 있을 때
					for (int k = 0; k < 4; k++) {
						if (likes[curr][k] == classRoom[nx][ny]) cnt++;
					}
				}	
				
				answer += satisfaction[cnt];
			}
		}
		
		System.out.println(answer);
	}

}

/*
3
4 2 5 1 7
3 1 9 4 5
9 8 1 2 3
8 1 9 3 4
7 2 3 4 8
1 9 2 5 7
6 5 2 3 4
5 1 9 2 8
2 9 3 1 4
*/