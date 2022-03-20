import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class oh_17142 {
    private static class xxyy {
        int x;
        int y;
        char val;

        private xxyy(int x, int y, char val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    static int M, N;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer[]> pos;
    static boolean[] comb;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Integer> answer;
    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //값 입력
        map = new int[N][N];
        pos = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    pos.add(new Integer[]{i, j});
                }
            }
        }

        //조합
        comb = new boolean[pos.size()];
        answer = new ArrayList<>();
        count = 0;
        comb(0, 0);

        int result = answer.stream().filter(o1 -> o1!=-1).min((o1, o2) -> o1 - o2).orElse(-22);
        //퍼트리지 못하는 경우
        boolean flag = true;
        for (Integer i : answer) {
            if(i!=-1){
                flag = true;
                break;
            }
            flag = false;
        }
        if(!flag){
            System.out.println(-1);
            return;
        }
        if (result == -22) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            bfs();
            return;
        }
        for (int i = start; i < comb.length; i++) {
            if (comb[i]) continue;
            comb[i] = true;
            comb(cnt + 1, i + 1);
            comb[i] = false;
        }
    }

    private static void bfs() {
        visit = new boolean[N][N];
        //map 복사
        char[][] temp = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    temp[i][j] = '-';
                } else if (map[i][j] == 2) {
                    temp[i][j] = '*';
                } else if (map[i][j] == 0) {
                    temp[i][j] = '0';
                }
            }
        }
        //바이러스 찍기
        Queue<xxyy> que = new LinkedList();
        for (int i = 0; i < pos.size(); i++) {
            if (comb[i]) {
                int x = pos.get(i)[0];
                int y = pos.get(i)[1];
                que.offer(new xxyy(x, y, '0'));
                temp[x][y] = '*';
                visit[x][y] = true;

            }
        }
        int zero = 0;
        while (!que.isEmpty()) {
            xxyy z = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = z.x + dir[i][0];
                int ny = z.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= temp.length || ny >= temp.length) continue;

                if (temp[nx][ny] != '-' && !visit[nx][ny]) {

                    visit[nx][ny] = true;

                    if (temp[nx][ny] == '*') {
                        que.add(new xxyy(nx,ny,(char) (z.val + 1)));
                    } else{
                        temp[nx][ny] = (char) (z.val + 1);
                        que.add(new xxyy(nx, ny, temp[nx][ny]));
                    }

                }
            }
        }
        boolean flag = true;
        int max = 0;
        out:
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i][j] == '0') {
                    answer.add(-1);
                    flag = false;
                    break out;
                }else if(temp[i][j]!='-'&&temp[i][j]!='*'){
                    max = Math.max(max, temp[i][j] - '0');
                }
            }
        }
        if (flag) {
            answer.add(max);
        }
    }
}
