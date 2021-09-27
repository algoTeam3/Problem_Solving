import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922 {
    static int v,e;
    static ArrayList<ArrayList<node>> arr;
    static boolean[] visit;
    static PriorityQueue<node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        //인접리스트 생성
        arr=  new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            arr.add(new ArrayList<node>());
        }
        //배열담기
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to,value));
            arr.get(to).add(new node(from,value));

        }
        System.out.println(prim());
    }
    static int prim(){
        int cnt= 0;
        int ret =0;
        visit = new boolean[v+1];
        pq =new PriorityQueue<>();
        pq.add(new node(1, 0));

        while (!pq.isEmpty()){
            node z = pq.poll();
            //방문 검사
            if(visit[z.to])continue;
            visit[z.to]=true;
            ret+=z.value;

            if(++cnt== v){
                return ret;
            }
            for (int i = 0; i < arr.get(z.to).size(); i++) {
                if(visit[arr.get(z.to).get(i).to])continue;
                pq.add(arr.get(z.to).get(i));

            }
        }
        return ret;
    }

}
class node implements Comparable<node> {
    int to;
    int value;

    node(int to,int value){
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(node o) {
        return this.value-o.value;
    }
}
