package practice;
import java.util.*;

public class Dp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int number = 12;
		int answer = 0,che=0;
        ArrayList<ArrayList<Integer>> s =new ArrayList<ArrayList<Integer>>();
        String num = Integer.toString(N);
        for(int i=0;i<8;i++) {
           s.add(new ArrayList<Integer>());
           s.get(i).add(Integer.parseInt(num));
           num+=N;
        }
        for(int i=1;i<8;i++) {
           for(int j=0;j<i;j++) {
              for(int k:s.get(j)) {
                 for(int k2:s.get(i-j-1)) {
                    s.get(i).add(k+k2);
                    s.get(i).add(k-k2);
                    s.get(i).add(k*k2);
                    if (k2 != 0) s.get(i).add(k/k2);
                 }
              }
           }
           if (s.get(i).contains(number)) {
              answer=i+1;
              che=1;
              break;
           }
        }
        if (che==0)answer=-1;
       	System.out.println(answer);
	}

}
