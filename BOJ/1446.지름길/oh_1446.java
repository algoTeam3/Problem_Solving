
import javax.print.attribute.standard.JobMessageFromOperator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class oh_1446 {

    private static class node implements Comparable<node> {
        int to;
        int cost;

        private node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost-o.cost;
        }
    }

    private static int[] visited;
    private static int[][] map;
    private static ArrayList<ArrayList<node>> arr;
    private static int INF =987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new int[1001][1001];
        visited = new int[1001];
        
        //고속도로연결
        for (int i = 0; i < map.length-1; i++) {
            for (int j = 0; j < map.length; j++) {
                if(j-i==1){
                    map[i][j]=1;
                }else{
                    map[i][j]=-1;
                }
            }
        }
        //지름길연결
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            if(map[from][to]==-1){
                map[from][to]=cost;
            }else{
                map[from][to]=Math.min(map[from][to],cost);
            }
            if(map[to][from]==-1){
                map[to][from]=cost;
            }else{
                map[to][from]=Math.min(map[to][from],cost);
            }

        }
        Arrays.fill(visited,INF);
        dij();
        System.out.println(visited[d]);
    }

    private static void dij() {
        PriorityQueue<node> que = new PriorityQueue<>();
        que.add(new node(0,0));
        visited[0]=0;

        while(!que.isEmpty()){
            node z =que.poll();

            if(visited[z.to]<z.cost)continue;
            for (int i = 0; i < map[z.to].length; i++) {
                if(map[z.to][i]!=-1){
                    if(visited[i]>visited[z.to]+map[z.to][i]){
                        visited[i]=visited[z.to]+map[z.to][i];
                        que.add(new node(i,visited[z.to]+map[z.to][i]));
                    }
                }
            }
        }
    }
}
