
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ1707
 * @date : 2022-01-11
 * @language : JAVA
 * @classification : graph
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_1707 {
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> arr;
    private static HashMap<Integer, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visit = new boolean[V+1];
            arr = new ArrayList<>();

            for (int j = 0; j < V+1; j++) {
                arr.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr.get(from).add(to);
                arr.get(to).add(from);
            }
            map = new HashMap<>();
            boolean answer = true;
            for (int j = 1; j < V+1; j++) {
                    if(!Bfs(j)){
                        answer =false;
                        break;
                    }
            }
            if(answer){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }


    private static boolean Bfs(int j) {
        Queue<Integer> que = new LinkedList();
        que.add(j);
        map.put(j,"red");

        while(!que.isEmpty()){
            int z = que.poll();

            if(visit[z])continue;

            for (int i = 0; i < arr.get(z).size(); i++) {
                visit[z]=true;
                int next = arr.get(z).get(i);
                String str ="";
                if(map.get(z)=="red"){
                    str = "blue";
                }else if(map.get(z)=="blue"){
                    str = "red";
                }
                if(map.containsKey(next)){
                    if(map.get(z).equals(map.get(next))){
                        return false;
                    }
                }else{
                    map.put(next,str);
                }
                que.add(next);
            }
        }
        return true;
    }
}
