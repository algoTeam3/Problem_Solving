import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class W_14621_나만안되는연애 {

    static int N, M;
    static boolean[] male;
    static int[] parents;
    static void make(){
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int d;

        public Edge(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.d - o.d;
        }
    }

    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        male = new boolean[N+1];
        edges = new Edge[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if(st.nextToken().equals("M"))
                male[i] = true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, d);
        }

        Arrays.sort(edges);
        make();

        int cnt = 0, ans = 0;
        for (Edge e : edges) {
            if(male[e.u] == male[e.v]) continue;
            if(union(e.u, e.v)){
                ans += e.d;
                cnt++;
                if(cnt == N-1) break;
            }

        }

        if(cnt != N-1) ans = -1;

        System.out.println(ans);
    }
}
