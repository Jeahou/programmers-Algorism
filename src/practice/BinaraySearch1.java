package practice;
import java.util.*;

public class BinaraySearch1 {
	
// 3·¦ ¿¹»ê 
	static int answer = 0;
	static void ch(int l,int h, int max, int[] n) {
		int low = l;
		int high = h;
		int mid = (l+h)/2;
		long result = 0;
		for(int i : n) {
			if(i < mid) {
				result += (long)i;
			}else {
				result += (long)mid;
			}
		}
		if(result > max) {
			ch(low, mid, max, n);
		}else {
			if(low != mid) {
				ch(mid, high, max, n);
			}else {
				answer = mid;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		 long max = 0;
	        for(int i : budgets) {
				max += i;
			}
			if(max<(long)M) {
				Arrays.sort(budgets);
				answer = budgets[budgets.length-1];
			}else {
				ch(0, M, M, budgets);
			}
	        //return answer;
			System.out.println(answer);

	}

}
