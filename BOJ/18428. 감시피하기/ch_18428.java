import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ch_18428 {
    static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static String ans = "NO";
    static char[][] map;
    static boolean flag = false;
    static ArrayList<Pos> space = new ArrayList<>();
    static ArrayList<Pos> teacher = new ArrayList<>();

    static Pos[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        selected = new Pos[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'X') space.add(new Pos(i, j));
                if (map[i][j] == 'T') teacher.add(new Pos(i, j));
            }
        }

        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int cnt, int start) {
        if (cnt == 3){
            // 선택된 곳에 벽을 세운다.
            for (int i = 0; i < 3; i++) {
                map[selected[i].x][selected[i].y] = 'O';
            }
            // 선생이 학생을 찾지 못하면 yes 추가
            if (cal()){
                ans = "YES";
                flag = true;
                return;
            }else{
                // 실패하면 벽을 되돌려놓는다.
                for (int i = 0; i < 3; i++) {
                    map[selected[i].x][selected[i].y] = 'X';
                }
            }
            return;
        }

        for (int i = start; i < space.size(); i++) {
            // flag가 참이면 정답이 나온 상태
            if (flag) return;
            selected[cnt] = new Pos(space.get(i).x, space.get(i).y);
            solve(cnt + 1, i + 1);

        }
    }

    private static boolean cal() {
         for (int i = 0; i < teacher.size(); i++) {
            Pos curr = teacher.get(i);

         outer : for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    // 학생이 보이면 실패
                   if (map[nx][ny] == 'S') return false;

                    // 벽을 만나면 다른 방향으로
                   if (map[nx][ny] == 'O') continue outer;

                   // 거리 1 증가
                   nx += dx[d];
                   ny += dy[d];
                }
            }
        }
        return true;
    }
}
