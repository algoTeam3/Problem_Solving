
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ4970
 * @date : 2022-01-05
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_1967 {

    private static ArrayList<ArrayList<node>> arr;
    private static int reuslt_search;
    private static int answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();


        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        //정보입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to, len));
            arr.get(to).add(new node(from, len));
        }

        reuslt_search = 0;
        answer = 0;
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);
        answer = 0;
        visited = new boolean[n + 1];
        visited[reuslt_search] = true;
        dfs(reuslt_search, 0);
        System.out.println(answer);
    }

    private static void dfs(int next, int sum) {
        for (int i = 0; i < arr.get(next).size(); i++) {
            node temp = arr.get(next).get(i);
            if (!visited[temp.to]) {
                visited[temp.to] = true;
                dfs(temp.to, sum + temp.value);
                visited[temp.to] = false;
            }
        }
        if (answer < sum) {
            reuslt_search = next;
            answer = sum;
            return;
        }


    }
}
