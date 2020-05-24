package practice;
import java.util.*;
// 2랩 전화번호 목록
public class Hash2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer = true;
		String[] phone_book = {"119", "97674223", "1195524421"};
	       Arrays.sort(phone_book);
	       HashMap<String, Integer> map = new HashMap<String,Integer>();
	       for(String s:phone_book) {
	          for(int i=0;i<s.length()-1;i++) {
	             String data=s.substring(0,i+1);
	             if(map.containsKey(data)) {
	                answer=false;
	               // return answer;
	             }
	          }
	          map.put(s, 0);
	       }
	        System.out.println(answer);
	}

}
