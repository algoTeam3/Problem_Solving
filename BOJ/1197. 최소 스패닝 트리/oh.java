import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1197 {
    static int v;
    static int e;
    static ArrayList<ArrayList<node>> arr;
    static boolean[] visit;
    static PriorityQueue<node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        //인접리스트생성
        arr = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            arr.add(new ArrayList<>());
        }

        //배열에 담기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to, value));
            arr.get(to).add(new node(from, value));
        }
        System.out.println(prim());

    }

    static int prim() {
        int ret = 0;
        pq = new PriorityQueue<>();
        visit = new boolean[v + 1];
        pq.add(new node(1, 0));

        int cnt = 0;
        while (!pq.isEmpty()) {
            node n = pq.poll();

            if (visit[n.to]) continue;
            ret += n.value;
            visit[n.to] = true;

            if (++cnt == v) {
                return ret;
            }
            for (int i = 0; i < arr.get(n.to).size(); i++) {
                node next = arr.get(n.to).get(i);
                if (visit[next.to]) continue;
                pq.add(next);
            }
        }
        return ret;
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
