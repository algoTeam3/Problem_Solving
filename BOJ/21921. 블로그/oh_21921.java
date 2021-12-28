import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ21921
 * @date : 2021-12-25
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int start =0;
        int sum=0;
        int answer=0;
        int count=1;
        int[] days = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < days.length; i++) {
            days[i]= Integer.parseInt(st.nextToken());
        }

        for (int end = 0; end < days.length; end++) {
            sum+=days[end];
            if(end>=X-1){
                if(sum==answer){
                    count++;
                }
                if(answer<sum){
                    answer=sum;
                    count=1;
                }

                sum-= days[start];
                start++;
            }
        }
        if(answer==0){
            System.out.println("SAD");
        }else{
            System.out.println(answer);
            System.out.println(count);
        }

    }
}
