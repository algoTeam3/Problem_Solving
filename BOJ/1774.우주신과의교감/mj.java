import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class W9_1774_우주신과의교감 {

    static class Edges implements Comparable<Edges>{
        private int s;
        private int e;
        private double d;

        public Edges(int s, int e, double d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Edges o) {
            return Double.compare(this.d, o.d);
        }
    }

    private static int[] parents;
    private static int N, M;
    private static void make(){
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edges> pq = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][2];
        // N개의 좌표
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        make();

        // M개의 이미 연결된 상황
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            union(n1, n2);
        }

        // 모든 좌표끼리의 거리 pq에 넣기
        for (int i = 1; i <= N; i++) {
            int[] now = map[i];
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                int[] next = map[j];
                double dist = Math.sqrt(Math.pow(now[0]-next[0], 2) + Math.pow(now[1]-next[1], 2));
                pq.offer(new Edges(i, j, dist));
            }
        }

        int cnt = 0;
        double ans = 0;
        while(!pq.isEmpty()){
            Edges es = pq.poll();
            if(union(es.s, es.e)){
                cnt++;
                ans += es.d;
//                System.out.println("좌표 "+es.s+","+es.e);
//                System.out.println(es.d);
            }

            if (cnt == N-M-1) break;
        }

        System.out.printf("%.2f", ans);


   }
}
