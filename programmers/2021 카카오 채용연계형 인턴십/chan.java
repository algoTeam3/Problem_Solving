import java.util.ArrayList;
import java.util.Arrays;

public class chan {
	static char[][] room;
	static int[] sel = new int[2];
	static ArrayList<int[]> person;
	static int v, temp;
	public static void main(String[] args) throws Exception {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
							{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
							{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
							{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
							{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

		room = new char[5][5];
        int[] answer = {1, 1, 1, 1, 1};

		// 5개의 대기실 차례로 방문
		for (int i = 0; i < 5; i++) {
			person = new ArrayList<>();
			// 각 대기실마다 자리 배치 확인
			for (int j = 0; j < 5; j++) {
				room[j] = places[i][j].toCharArray();
			}
			System.out.println("room : " + i);
			// 각 방의 대기실 구조마다 거리두기 준수 여부 확인
			getPersonList(room);
			comb(0,0);
			answer[i] = v;
		}
		
		System.out.println(Arrays.toString(answer));
	}
	
	static void getPersonList(char[][] r) {
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				if (r[i][j] == 'P') person.add(new int[] {i, j});
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void comb(int cnt, int start) {
		// temp를 설정해서 해당 부분집합에서 거리두기 지켜지지 않으면 바로 종료되게 했더니 성공, 안했을 때는 49.3/100
		if (cnt == 2) {
			System.out.println(Arrays.toString(sel));
			// 두 응시자를 뽑는 모든 조합
			int manhattanDist = Math.abs(person.get(sel[0])[0] - person.get(sel[1])[0]) + 
								Math.abs(person.get(sel[0])[1] - person.get(sel[1])[1]);

			if (manhattanDist == 1) {
				System.out.println(sel[0] + " " + sel[1]);
				v = 0;
				temp = 0;
			}
			if (manhattanDist == 2) {
				v =  checkDist(sel[0], sel[1]);
				if (v == 0) {
					System.out.println(sel[0] + " " + sel[1]);
					temp = 0;
					
				}
			}
			return;
		}
		temp = person.size();
		for (int i = start; i < person.size(); i++) {
			temp--;
			sel[cnt] = i;
			comb(cnt + 1, i + 1);
			if (temp == 0) break;
		}
	}
	
	static int checkDist(int a, int b) {
		int r1 = person.get(a)[0];
		int c1 = person.get(a)[1];
		int r2 = person.get(b)[0];
		int c2 = person.get(b)[1];
		
		// 행이 같다면 직선에 위치
		if (r1 == r2) {
			if (room[r1][(c1 + c2)/2] == 'O') return 0;
		}
		// 열이 같다면 직선에 위치
		else if (c1 == c2) {
			if (room[(r1 + r2)/2][c1] == 'O') return 0;
		}
		// 행과 열이 모두 다르다면 대각선에 위치
		else {
			if (room[r1][c2] == 'O' || room[r2][c1] == 'O') return 0;
		}
		// 조건에 모두 맞지 않다면 거리두기가 지켜지고 있음
		return 1;
	}
}
