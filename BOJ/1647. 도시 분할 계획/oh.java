import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1647.도시 분할 계획
 *
 * mst응용 문제 -prim
 * cost가 높은 길과 연결된 마을 하나를 빼버리자 
 *
 */
public class BOJ1647 {
    static int v,e;
    static ArrayList<ArrayList<node>>arr;
    static boolean[] visit;
    static PriorityQueue<node> pq;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        //인접 리스트 생성
        arr= new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            arr.add(new ArrayList<node>());
        }
        //배열에 담기
        for (int i = 0; i < e; i++) {
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to,value));
            arr.get(to).add(new node(from,value));
        }

        System.out.println(prim()-max);
    }
    static int prim(){
        int cnt=0;
        int ret =0;
        max= 0;
        visit = new boolean[v+1];
        pq = new PriorityQueue<>();
        pq.add(new node(1,0));

        while (!pq.isEmpty()){
            node n = pq.poll();

            if(visit[n.to])continue;
            visit[n.to]=true;
            ret+=n.value;
            max=Math.max(n.value,max);

            if(++cnt==v){
                return ret;
            }
            for (int i = 0; i < arr.get(n.to).size(); i++) {
                node next = arr.get(n.to).get(i);
                if(visit[next.to])continue;
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

