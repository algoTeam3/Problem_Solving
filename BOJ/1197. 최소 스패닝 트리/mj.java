import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class W_1197_최소스패닝트리 {

    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
//            return this.c - o.c;
            return Integer.compare(this.c, o.c);
        }
    }

    static int[] parents;

    private static void make(){
        // 모든 원소를 자신을 대표자로 만들기
        parents = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    // a가 속한 집합의 대표자 찾기
    private static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    // 두 원소를 하나의 집합으로 합치기
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges);

        make();

        int cnt = 0;
        int ans = 0;
        // 간선 하나씩 시도하며 만들기
        for (Edge e : edges) {
            if(union(e.a, e.b)){
                cnt++;
                ans += e.c;
                if(cnt == V-1) break;
            }
        }

        System.out.println(ans);
    }
}
