

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ2671
 * @date : 2022-01-05
 * @language : JAVA
 * @classification : regex
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Pattern pattern = Pattern.compile("^(100+1+|01)+$");
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            System.out.println("SUBMARINE");
        }else{
            System.out.println("NOISE");
        }
        }

}
