

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1504.특정한 최단 경로
 * <p>
 * 그냥 최소 신장 트리?->xx
 *
 * 다익스트라 문제->o
 */
public class oh_1504 {
    static ArrayList<ArrayList<node>> arr;
    static int n;
    static int visit[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        //인접리스트 생성
        arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        //값 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to, cost));
            arr.get(to).add(new node(from, cost));
        }
        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        int sum1 = 0;
        int sum2 = 0;


        dij(1);
        sum1 += visit[node1];
        sum2 += visit[node2];
        dij(node1);
        sum1 += visit[node2];
        dij(node2);
        sum2 += visit[node1];
        dij(n);
        sum1 += visit[node2];
        sum2 += visit[node1];
        //최대값넣으면 못푼다
        //최대 개수는 200,000이고, 가중치의 최댓값은 1,000이기 때문
        if (sum1 >= 200000000 && sum2 >= 200000000) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(sum1, sum2));
        }


    }

    private static void dij(int start) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, 0));
        visit = new int[n + 1];
        Arrays.fill(visit, 200000000);
        visit[start] = 0;
        while (!pq.isEmpty()) {
            node z = pq.poll();

            if (visit[z.to] < z.value) continue;

            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node next = arr.get(z.to).get(i);
                if (visit[next.to] > visit[z.to] + next.value) {
                    visit[next.to] = visit[z.to] + next.value;
                    pq.add(new node(next.to, visit[next.to]));
                }
            }

        }

    }
}
