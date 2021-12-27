
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ14465
 * @date : 2021-12-27
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count =0;
        int answer =Integer.MAX_VALUE;
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < B; i++) {
            map.put(Integer.parseInt(br.readLine()),1);
        }

        for (int end = 1; end <= N; end++) {
            arr.add(end);
            if(map.containsKey(end))count++;
            if(arr.size()>=K){
                answer = Math.min(answer,count);
                if(map.containsKey(arr.get(0)))count--;
                arr.remove(0);

            }
        }
        System.out.println(answer);
    }
}
