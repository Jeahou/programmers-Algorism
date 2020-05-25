package practice;

public class DfsBfs2 {
	static void dfs(int[][] computers, int idx, boolean[] chk){
        chk[idx] = true;
        for(int i=0; i<computers[0].length; i++) {
        	if(chk[i] == false && computers[idx][i] == 1) dfs(computers, i, chk);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; 
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int answer = 0;
        boolean[] chk = new boolean[n];
		for(int i=0; i<n; i++) {
			if(chk[i] == false) {
				answer++;
				dfs(computers, i, chk);
			}
		}
		System.out.println(answer);
	}

}
