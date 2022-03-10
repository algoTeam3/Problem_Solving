

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class oh_13424 {

    private static ArrayList<ArrayList<node>> arr;
    private static int[][] pos;
    private static int INF = 987654321;
    private static int[][] ints;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();

            for (int j = 0; j < n+1; j++) {
                arr.add(new ArrayList<>());
            }
            //간선 입력
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                
                arr.get(from).add(new node(to,cost));
                arr.get(to).add(new node(from,cost));
            }

            int friends = Integer.parseInt(br.readLine());
            ints = pos = new int[friends][n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < pos.length; j++) {
                int room = Integer.parseInt(st.nextToken());
                dij(j,room);
            }

            //최솟값 계산
            int min = Integer.MAX_VALUE;
            int answer =0;
            for (int j = pos[0].length-1; j > 0; j--) {
                int sum =0;
                for (int k = 0; k < pos.length; k++) {
                    sum+=pos[k][j];
                }
                if(min>=sum){
                    min=sum;
                    answer=j;

                }
            }
            System.out.println(answer);
        }
    }

    private static void dij(int order,int start) {
        PriorityQueue<node> que = new PriorityQueue<>();
        que.add(new node(start,0));
        for (int i = 1; i < pos[order].length; i++) {
            pos[order][i]=INF;
        }
        pos[order][start]=0;

        while (!que.isEmpty()){
            node z = que.poll();

            if(pos[order][z.to]<z.value)continue;

            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node next = arr.get(z.to).get(i);
                if(pos[order][next.to]>pos[order][z.to]+next.value){
                    pos[order][next.to]=pos[order][z.to]+next.value;
                    que.add(new node(next.to,pos[order][z.to]+next.value));
                }
            }
        }
    }
}
