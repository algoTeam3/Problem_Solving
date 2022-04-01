import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class W9_1368_물대기 {

    static class Edges implements Comparable<Edges>{
        private int s;
        private int e;
        private int w;

        public Edges(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edges o) {
            return Integer.compare(this.w, o.w);
        }
    }

    private static int[] parents;
    private static boolean[][] visited;
    private static int N;
    private static void make(){
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a){
        if (parents[a] == a) return a;
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
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 새로운 정점을 추가해서 연결해준다.
            pq.offer(new Edges(i ,N, Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int w = Integer.parseInt(st.nextToken());
                pq.offer(new Edges(i, j, w));
            }
        }

        make();

        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty()){
            Edges es = pq.poll();
            if (union(es.s, es.e)){
                cnt++;
                ans += es.w;
//                System.out.println(cnt+ " " +es.w);
            }

            if (cnt == N) break;
        }

        System.out.println(ans);

    }
}
