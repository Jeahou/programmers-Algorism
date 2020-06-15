package practice;
import java.util.*;
public class Kakao2020_3 {
	// 외벽 점검
	static LinkedList<Integer> weakList;
	static boolean checked;
	static int weakLen;
	public static LinkedList<Integer> getWeakList(int n, int[] weak) { 
	      weakLen = weak.length;
	      LinkedList<Integer> result = new LinkedList<>();

	      for (int num : weak) {
	         result.offer(num);
	      }
	      for (int i = 0; i < weakLen; i++) {
	         result.offer(result.get(i) + n);
	      }

	      return result;
	   }
	public static void permutation(int cnt, int[] visit, int[] dist, LinkedList<Integer> result) {
        if(checked) {
            return ;
        }
        else if(cnt == 0) {
            find(result);
            return ;
        }

        for(int i=0; i<dist.length; i++) {
            if(visit[i] ==0) {
                result.offer(dist[i]);
                visit[i] = 1;
                permutation(cnt-1,visit, dist, result);
                visit[i] =0;
                result.removeLast();
            }
        }
   }
   public static void find(LinkedList<Integer> distList) {
       for(int i = 0; i < weakLen; i++) {
            int distIdx = 0;
            int person = distList.get(distIdx);
            int prev = i; 
            boolean finish = true;
            for (int j = i; j < i + weakLen; j++) {
                int div = weakList.get(j) - weakList.get(prev);
                if (person - div < 0) {
                    if (distIdx + 1 < distList.size()) {
                        person = distList.get(++distIdx);
                    } else {
                        finish = false;
                        break;
                    }
                } else {    
                    person -= div;    
                }
                prev = j; 
            }
            if (finish) {  
                checked = true;
                break;
            }
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 12;
		int[] weak = {1,5,6,10};
		int[] dist = {1,2,3,4};
		LinkedList<Integer> ne = getWeakList(N, weak);
		System.out.println(ne);
		System.out.println(weakLen);
		int answer = -1;
	      if (N==1 || weak.length==1) answer=1;
	      else {
	         weakList = getWeakList(N, weak);
	           checked = false;
	           for(int i=1; i<=dist.length; i++) {
	               permutation(i,new int[dist.length], dist, new LinkedList<>());
	               if(checked) {
	                   answer = i;
	                   break;
	               }
	           }
	      }
	      System.out.println(answer);
	}

}
