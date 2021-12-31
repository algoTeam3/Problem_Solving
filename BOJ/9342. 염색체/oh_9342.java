

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ9342
 * @date : 2021-12-31
 * @language : JAVA
 * @classification : regex
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T ; i++) {
            String str = br.readLine();
            Pattern pattern = Pattern.compile("(A|B|C|D|E|F)?A{1,}F{1,}C{1,}(A|B|C|D|E|F)?");
            Matcher matcher = pattern.matcher(str);
            if(matcher.matches()){
                System.out.println("Infected!");
            }else{
                System.out.println("Good");
            }
        }

    }
}
