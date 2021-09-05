import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expert1216 {
    static char[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("algo/src/input/input1216.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 0; test_case < T; test_case++) {
            int tc = Integer.parseInt(br.readLine());
            map = new char[100][100];
            count = 0;
            int max = Integer.MIN_VALUE;
            for (int r = 0; r < map.length; r++) {

                String str = br.readLine();
                for (int c = 0; c < map.length; c++) {
                    map[r][c] = str.charAt(c);
                }
            }
            //가로탐색
            for (int r = 0; r < map.length; r++) {
                for (int c = 0; c < map.length - 1; c++) {

                    for (int i = map.length - 1; i > c; i--) {
                        if (map[r][c] == map[r][i]) {

                            search(r, c, i);
                            max = Math.max(max, count);
                            count = 0;
                            continue;
                        }
                    }
                }
            }

            //세로탐색
            for (int c = 0; c < map.length; c++) {
                for (int r = 0; r < map.length - 1; r++) {

                    for (int i = map.length - 1; i > r; i--) {
                        if (map[r][c] == map[i][c]) {

                            search2(r, c, i);
                            max = Math.max(max, count);
                            count = 0;
                            continue;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    static void search(int r, int c, int i) {
        if ((i - c) % 2 == 1) {
            if (c + 1 == i && i - 1 == c) {
                count += 2;
                return;
            }
        } else {

            if (c == i) {
                count++;

                return;
            }
        }
        count += 2;
        c += 1;
        i -= 1;
        if (map[r][c] == map[r][i]) {

            search(r, c, i);
        } else {
            count = 0;
            return;
        }

    }

    static void search2(int r, int c, int i) {
        if ((i - r) % 2 == 1) {
            if (r + 1 == i && i - 1 == r) {
                count += 2;
                return;
            }
        } else {

            if (r == i) {
                count++;

                return;
            }
        }
        count += 2;
        r += 1;
        i -= 1;
        if (map[r][c] == map[i][c]) {

            search2(r, c, i);
        } else {
            count = 0;
            return;
        }


    }
}
