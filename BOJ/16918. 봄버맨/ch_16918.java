import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1초후 설치
 * 2초후 초기 폭탄 터짐
 * 3초후 설치
 * 4초후 1초 설치 폭탄 터짐
 * 5초후 설치
 * -------------------
 * 홀수시간에는 폭탄 설치
 * 짝수 시간에는 터짐
 * 터지는 시간을 또다른 2차원 배열에 저장하자
 *
 */
public class ch_16918 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C, N;
    static char[][] map;
    static int[][] bomb;    // 터질 시간 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());   // N초일 때 상태

        map = new char[R][C];
        bomb = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                // 터질 시간 체크
                if (map[i][j] == 'O') bomb[i][j] = 3;
            }
        }

        int time = 0;
        while (time++ < N){
            // 폭탄 설치
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bomb[i][j] = time + 3; // 현재 시간부터 3초 뒤
                        }
                    }
                }
                // 폭탄 터짐
            } else if (time % 2 == 1) {
                for (int x = 0; x < R; x++) {
                    for (int y = 0; y < C; y++) {
                        if (bomb[x][y] == time) { // 터질 시간이 됐을 때
                            map[x][y] = '.';
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dx[d];
                                int ny = y + dy[d];

                                // 범위 체크
                                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                                // 인접 폭탄은 폭발 없이 파괴
                                if (map[nx][ny] == 'O' && bomb[nx][ny] != time) {
                                    map[nx][ny] = '.';
                                    bomb[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }
    }
}
