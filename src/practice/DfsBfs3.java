package practice;
import java.util.*;

public class DfsBfs3 {
	 static int bfs(ArrayList<Integer>[] list, int begin, int target, boolean[] visited, int[] resultList){
	        int result = 0;
	        Queue<Integer> queue = new LinkedList<Integer>();
	        visited[begin] = true;
	        resultList[begin] = result;
	        queue.offer(begin);
	        
	        while(!queue.isEmpty()){
	            int current = queue.peek();
	            queue.remove();
	            
	            for(int i=0; i<list[current].size(); i++){
	                int next = list[current].get(i);
	                if(visited[next] == false) {
	                	visited[next] = true;
	                	queue.offer(next);
	                	resultList[next] = resultList[current] + 1;
	                }
	             }
	            if(current == target) {
	            	result = resultList[current];
	            	break;
	            }
	         }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int tar = 0;
		boolean[] visited = new boolean[words.length+1];
        int[] resultList = new int[words.length + 1];
		ArrayList<Integer>[] list = new ArrayList[words.length + 1];
		String temp = begin;
		int answer = 0;
		for(int i=0; i<words.length+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<words.length+1; i++) {
			if(i != 0 && words[i-1].equals(target)) tar = i;
			for(int j=i; j<words.length; j++ ) {
				if(i==0) {
					int count = 0;
					for(int k=0; k<begin.length(); k++) {
						if(temp.charAt(k) == words[j].charAt(k)) count++;
					}
					if(count == words[0].length()-1) {
						list[i].add(j+1);
						list[j+1].add(i);
					}
				}else {
					temp = words[i-1];
					int count = 0;
					for(int k=0; k<begin.length(); k++) {
						if(temp.charAt(k) == words[j].charAt(k)) count++;
					}
					if(count == words[0].length()-1) {
						list[i].add(j+1);
						list[j+1].add(i);
					}
				}
			}
		}
        if(tar != 0) answer = bfs(list, 0, tar, visited, resultList);
        System.out.println(answer);
	}

}
