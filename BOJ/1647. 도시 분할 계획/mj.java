package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647 {

    static class Edges implements Comparable<Edges>{
        private int A;
        private int B;
        private int C;

        public Edges(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }

        @Override
        public int compareTo(Edges o) {
            return this.C - o.C;
        }
    }

    static private int[] parents;
    static private int N, M;
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
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edges> pq = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.offer(new Edges(A, B, C));
        }

        make();

        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty()){
            Edges e = pq.poll();
            if(union(e.A, e.B)){
                cnt++;
                ans += e.C;
            }

            if(cnt == N-2) break;
        }

        System.out.println(ans);

    }
}
