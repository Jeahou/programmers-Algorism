package practice;
import java.util.*;
// 1레벨 완주하지 못한 선수 
public class Hash1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
 		String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
       for(int i=0;i<participant.length;i++) {
          if (!map.containsKey(participant[i])) map.put(participant[i], 1);
          else map.put(participant[i], map.get(participant[i])+1);
       }
       for(int i=0;i<completion.length;i++) {
          if(map.get(completion[i])-1!=0)map.put(completion[i], map.get(completion[i])-1);
          else map.remove(completion[i]);
       }
       for(Map.Entry<String, Integer> e:map.entrySet()) {
          answer=e.getKey();
       }

      System.out.println(answer);
   }
}
