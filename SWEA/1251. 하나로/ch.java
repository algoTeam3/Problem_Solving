package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_MST_하나로 {
    static class Edge implements Comparable<Edge> {

        int start, end;
        long E;

        public Edge(int start, int end, long E) {
            this.start = start;
            this.end = end;
            this.E = E;
        }

        @Override
        public int compareTo(Edge o) {
//            return this.weight - o.weight;  // 간선의 부호가 같을 때
            return Long.compare(this.E, o.E);
        }
    }

    static int[] parents;   // 부모 원소를 관리(트리처럼 사용)

    private static void make() {
        parents = new int[N];
        // 모든 원소를 자신을 대표자로 만듦
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }
    private static int find(int a) {
        if (a == parents[a]) return a;  // 자신이 대표자.
        return parents[a] = find(parents[a]);   // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
    }

    // 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;   // 이미 같은 집합으로 합치지 않음

        parents[bRoot] = aRoot;
        return true;
    }

    static int N;
    static Long[] X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // 섬의 개수
            N = Integer.parseInt(br.readLine());

            String[] Xarr = br.readLine().split(" ");
            String[] Yarr = br.readLine().split(" ");

            Long[] X = new Long[N];
            Long[] Y = new Long[N];
            double E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N; i++) {
                X[i] = Long.parseLong(Xarr[i]);
                Y[i] = Long.parseLong(Yarr[i]);
            }

            make();


            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    long distance = (X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j]);
                    pq.add(new Edge(i, j, distance));
                }
            }

            long result = 0;
            int cnt = 0;
            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                if (union(e.start, e.end)) {
                    result += e.E;
                    if (++cnt == N - 1) break;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
