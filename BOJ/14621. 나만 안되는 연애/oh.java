import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14621 {
    static int v, e, cnt;
    static boolean[] visit;
    static char[] wm;
    static ArrayList<ArrayList<node>> arr;
    static PriorityQueue<node> pq;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        //남초 여초 입력
        wm = new char[v + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < wm.length; i++) {
            wm[i] = st.nextToken().charAt(0);
        }
        //인접리스트 생성
        arr = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            arr.add(new ArrayList<>());
        }
        //배열에 담기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            //가성비 낮은 길도 입력값에 있음
            arr.get(to).add(new node(from, value));
            arr.get(from).add(new node(to, value));
        }
        System.out.println(Prim());
    }

    private static int Prim() {
        cnt = 0;
        int ret = 0;
        pq = new PriorityQueue<>();
        visit = new boolean[v + 1];
        pq.add(new node(1, 0));

        while (!pq.isEmpty()) {
            node n = pq.poll();

            //값뽑아내기
            if (visit[n.to]) continue;
            visit[n.to] = true;
            ret += n.value;

            if (++cnt == v) {
                return ret;
            }
            for (int i = 0; i < arr.get(n.to).size(); i++) {
                node next = arr.get(n.to).get(i);
                if (wm[n.to] == wm[next.to] || visit[next.to]) continue;
                pq.add(next);
            }
        }
        return -1;
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

