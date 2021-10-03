import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 14938.서강그라운드
 * <p>
 * 다익스트라문제인지 판단하는게 가장 큰 문제
 * <p>
 * 모르고 풀었으면 한참 헤멜듯
 * <p>
 * 근데 이거 플로이드 아님?
 */
public class oh_14938.java {
    static int n, m, r;
    static ArrayList<ArrayList<node>> arr;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        //각구역 아이템 입력
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < items.length; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        //인접리스트 생성
        arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }
        //값 입력받기
        //양방향
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to, value));
            arr.get(to).add(new node(from, value));
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++) {

            Dij(i);
            int sum = 0;
            for (int j = 1; j < items.length; j++) {
                if (visit[j] <= m) {
                    sum += items[j];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    private static void Dij(int start) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start, 0));

        visit = new int[n + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[start] = 0;
        while (!pq.isEmpty()) {
            node z = pq.poll();

            if (z.value > visit[z.to]) continue;

            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node next = arr.get(z.to).get(i);
                if (visit[next.to] >= visit[z.to] + next.value) {
                    visit[next.to] = visit[z.to] + next.value;
                    pq.add(new node(next.to, visit[next.to]));
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
