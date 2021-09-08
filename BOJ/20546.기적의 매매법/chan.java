import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int jh_cash = input;
		int sm_cash = input;
		
		int[] MachineDuck = new int[14];
		String[] data = br.readLine().split(" ");
		for (int i = 0; i < 14; i++) {
			MachineDuck[i] = Integer.parseInt(data[i]);
		}
		//입력받기 완료 - 준현이와 성민이가 가진 돈과, 14일간의 MachineDuck 주가
		
		// 준현과 성민이 산 주식 수 초기화
		int jh_stock = 0;
		// 준현의 BNP 전략
		for (int i = 0; i < 14; i++) {
			// 준현이 가진 돈으로 오늘 주식을 살 수 있을 때
			if (jh_cash / MachineDuck[i] > 0) {
				jh_stock += jh_cash / MachineDuck[i];
				jh_cash = jh_cash % MachineDuck[i];
			}
		}
		
		// 성민의 33 매매법
		int sm_stock = 0;
		int up = 0;	// 연속 상승일을 셀 변수
		int down = 0;	// 연속 하락일을 셀 변수
		for (int i = 1; i < 14; i++) {
			// 전일 주가를 뺐을 때 양수이면 주가 상승
			if (MachineDuck[i] - MachineDuck[i - 1] > 0) {
				up++; down = 0;
			} 
			// 전일 주가를 뺐을 때 음수이면 주가 하락
			else if (MachineDuck[i] - MachineDuck[i - 1] < 0) {
				down++; up = 0;
			}
			
			// 연속 3일 상승했고, 성민이 팔 주식이 있으면 전량 매도
			if (up == 3 && sm_stock > 0) {
				sm_cash = sm_stock * MachineDuck[i];
				sm_stock = 0;
			} 
			// 연속 3일 하락했고, 성민이 살 돈이 있으면 전량 매수
			else if (down >= 3 && sm_cash / MachineDuck[i] > 0) {
				sm_stock += sm_cash / MachineDuck[i];
				sm_cash = sm_cash % MachineDuck[i];
			}
		} 
		
		// 자산 비교
		int jh_asset = jh_cash + jh_stock * MachineDuck[13];
		int sm_asset = sm_cash + sm_stock * MachineDuck[13];
		
		if (jh_asset > sm_asset) System.out.println("BNP");	// 준현의 자산이 더 클 때
		else if (sm_asset > jh_asset) System.out.println("TIMING");	// 성민의 자산이 더 클 때
		else System.out.println("SAMESAME");	// 준현과 성민의 자산이 같을 때
		
	}

}
