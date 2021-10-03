import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1753.최단경로
 * 
 * 다익스트라 기본 문제
 *
 * 간선이 많아서 가망없는거 컷해야됨
 * 했는데 왜 안되는데
 * 75번라인 pq에 노드 추가할때 가중치합을 넣어줘야
 * 69번라인이 제대로 작동한다
 */
public class BOJ1753 {
    static int v, e, start;
    static ArrayList<ArrayList<node>> arr;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        //인접리스트 생성
        arr= new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            arr.add(new ArrayList<>());
        }
        //값 입력 
        for (int i = 0; i < e; i++) {
            st= new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to= Integer.parseInt(st.nextToken());
            int value =Integer.parseInt(st.nextToken());
            
            arr.get(from).add(new node(to,value));
        }
        Dij();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visit.length; i++) {
            if(visit[i]==Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(visit[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void Dij() {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start,0));

        visit=new int[v+1];
        Arrays.fill(visit,Integer.MAX_VALUE);
        visit[start]=0;

        while(!pq.isEmpty()){
            node z = pq.poll();

            if(z.value>visit[z.to])continue;


            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node next=arr.get(z.to).get(i);
                if(visit[next.to]>next.value+visit[z.to]){
                    visit[next.to]=next.value+visit[z.to];
                    pq.add(new node(next.to,visit[next.to]));
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
