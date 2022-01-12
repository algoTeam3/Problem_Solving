

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ9996
 * @date : 2021-12-31
 * @language : JAVA
 * @classification : regex
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_9996 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());            // testcase
        String str = br.readLine();                     // pattern
        str = str.replace("*", "\\w*");
        Pattern pattern = Pattern.compile("^"+str+"$");
        for (int i = 0; i < T; i++) {
            String file = br.readLine();
            Matcher matcher = pattern.matcher(file);
            if (matcher.matches()) {
                sb.append("DA" + "\n");
            } else {
                sb.append("NE" + "\n");
            }
        }
        System.out.println(sb);
    }
}
