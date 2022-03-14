import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ16234
 * @date : 2022-01-22
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_16234 {

    private static int count;

    private static class xy {
        int x;
        int y;
        int val;

        private xy(int x,int y,int val){

            this.x=x;
            this.y=y;
            this.val = val;
        }

    }

    private static int[] visited;
    private static xy[] map;
    private static ArrayList<ArrayList<Integer>> arr;
    private static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int l =Integer.parseInt(st.nextToken());
        int r =Integer.parseInt(st.nextToken());

        map = new xy[n*n];



        //정보입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[n*i+j]=new xy(i,j,Integer.parseInt(st.nextToken()));
            }
        }
        int day =0;
        while(true){
            visited = new int[n*n];
            arr = new ArrayList<>();
            //간선체크
            boolean flag =true;
            for (int i = 0; i < n*n; i++) {
                arr.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dir[k][0];
                        int nc = j + dir[k][1];

                        if(nr<0||nc<0||nr>=n||nc>=n)continue;
                        int gap = Math.abs(map[n*i+j].val-map[n*nr+nc].val);
                        if(gap>=l&&gap<=r){
                            flag =false;
                            int from = n*i+j;
                            int to =n*nr+nc;

                            arr.get(from).add(to);
//                            System.out.println(from+" "+to);
                        }
                    }
                }
            }
            if(flag)break;
            day++;

            //이동
            count = 1;
            ArrayList<Integer> mod = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if(arr.get(i).size()!=0&&visited[i]==0){
                    mod.add(bfs(i));
                    count++;
                }
            }
            for (int i = 0; i < map.length; i++) {
                if(visited[i]!=0){
                    map[i].val=mod.get(visited[i]-1);
                }
            }
        }
        System.out.println(day);
    }

    private static int bfs(int num) {
        int cell =1;
        int sum = map[num].val;
        Queue<Integer> que = new LinkedList<>();
        que.add(num);
        visited[num]=count;

        while (!que.isEmpty()){
            int z = que.poll();

            for (int i = 0; i < arr.get(z).size(); i++) {
                int next = arr.get(z).get(i);
                if(visited[next]==0){
                    visited[next]=count;
                    cell++;
                    sum += map[next].val;
                    que.add(next);
                }
            }
        }
        return sum/cell;
    }
}
