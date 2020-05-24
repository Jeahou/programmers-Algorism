package practice;
import java.util.*;
public class Hash3 {
// 2∑¶ ¿ß¿Â
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int answer = 1;
	       HashMap<String, Integer> result = new HashMap<String, Integer>();
			for(int i=0; i<clothes.length; i++) {
				if(!result.containsKey(clothes[i][1])) {
					result.put(clothes[i][1], 1);
				}else {
					result.put(clothes[i][1], result.get(clothes[i][1])+1);
				}
			}
			for(int i : result.values()) {
				answer *= (i+1);
			}
			answer -= 1;
	        //return answer;
			System.out.println(answer);
	}

}
