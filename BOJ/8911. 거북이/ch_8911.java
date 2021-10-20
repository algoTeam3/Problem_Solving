import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * F: 한 눈금 앞으로
 * B: 한 눈금 뒤로
 * L: 왼쪽으로 90도 회전
 * R: 오른쪽으로 90도 회전
 */
public class ch_8911 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int dir = 0;
            int x = 0, y = 0;
            int maxX = 0, maxY = 0, minX = 0, minY = 0;
            for (int i = 0; i < str.length(); i++) {
                char command = str.charAt(i);
                switch (command) {
                    case 'F':
                        x += dx[dir];
                        y += dy[dir];
                        break;
                    case 'B':
                        x -= dx[dir];
                        y -= dy[dir];
                        break;
                    case 'L':
                        dir = dir - 1 == -1 ? 3: dir-1;
                        break;
                    case 'R':
                        dir = (++dir % 4);
                        break;
                }
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}
