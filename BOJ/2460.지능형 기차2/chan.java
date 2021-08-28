import java.util.Scanner;

public class chan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int passengers = 0;	// 현재 역에서의 사람 수
		int ans = 0;	// 기차에 사람이 가장 많을 때의 사람 수
		for (int i = 0; i < 10; i++) {
			int getOff = sc.nextInt();	// 내린 사람
			int getOn = sc.nextInt();	// 탄 사람
			
			passengers += ( getOn - getOff);	// 원래 타고있던 승객 수에서 내린 사람을 빼고, 탄 사람을 더하면 현재 역에서의 사람 수가 된다.

			ans = passengers > ans ? passengers : ans;	// 기차에 사람이 가장 많은지 비교
		}
		System.out.println(ans);
		sc.close();
	}

}
