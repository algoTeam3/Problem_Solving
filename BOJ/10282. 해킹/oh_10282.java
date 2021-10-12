import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class oh_10282 {
    static int v,e,start;
    static ArrayList<ArrayList<node>> arr;
    static int visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            //인접리스트 생성
            arr= new ArrayList<>();
            for (int j = 0; j < v+1; j++) {
                arr.add(new ArrayList<>());
            }
            //값 넣기
            for (int j = 0; j < e; j++) {
                st= new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                
                arr.get(from).add(new node(to,cost));
            }
            visit=new int[v+1];
            Dij(start);
            //무한대 아닌거 값계산
            int count=0;
            int max=0;
            for (int j = 0; j < visit.length; j++) {
                if(visit[j]!=Integer.MAX_VALUE){
                    count++;
                    max=Math.max(visit[j],max);
                }
            }
            System.out.println(count+" "+max);
        }
    }

    private static void Dij(int start) {
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(start,0));
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[start]=0;
        while (!pq.isEmpty()){
            node z = pq.poll();
            if(z.value>visit[z.to])continue;
            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node next= arr.get(z.to).get(i);
                if(visit[next.to]>visit[z.to]+next.value){
                    visit[next.to]=visit[z.to]+next.value;
                    pq.add(new node(next.to,visit[next.to]));
                }
            }
        }
    }
}
