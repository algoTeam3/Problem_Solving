import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class oh_1263 {
    static int N;
    static int[][] map;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\ttest\\algorithm\\algo\\src\\input\\input1263.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            // 값입력
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            //노드 순회
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                Dij(j);
                int sum = 0;
                for (int k : visit) {
                    sum += k;
                }
                min = Math.min(sum, min);

            }
            System.out.println("#" + i + " " + min);
        }

    }

    private static void Dij(int start) {
        int cost = 1;
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, cost));
        visit = new int[N];
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[start] = 0;

        while (!pq.isEmpty()) {
            node z = pq.poll();


            for (int i = 0; i < N; i++) {
                //간선확인
                if (map[z.to][i] != 1) continue;
                //가지치기
                if (z.value > visit[i]) continue;
                if (visit[i] > visit[z.to] + cost) {
                    visit[i] = visit[z.to] + cost;
                    pq.add(new node(i, visit[i]));
                }
            }
        }
    }
}

class node implements Comparable<node> {
    int to;
    int value;

    node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(node o) {
        return this.value - o.value;
    }
}
