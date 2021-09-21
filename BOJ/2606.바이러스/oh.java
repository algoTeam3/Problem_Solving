import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {
    static boolean visit[];
    static int map[][];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        count = 0;
        visit = new boolean[v + 1];
        map = new int[v + 1][v + 1];
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            map[num1][num2] = 1;
            map[num2][num1] = 1;
        }
        bfs(1);
        System.out.println(count);


    }

    static void bfs(int c) {
        int n = map.length - 1;
        Queue queue = new LinkedList<>();
        queue.offer(c);
        visit[c] = true;

        while (!queue.isEmpty()) {
            int x = (int) queue.poll();


            for (int i = 1; i <= n; i++) {
                if (map[x][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }


    }
}
