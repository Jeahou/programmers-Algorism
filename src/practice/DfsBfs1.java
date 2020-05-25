package practice;

public class DfsBfs1 {
	static int dfs(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target) return 1;
            return 0;
        }
        return dfs(numbers, target, idx+1, sum + numbers[idx]) + dfs(numbers, target, idx+1, sum - numbers[idx]);  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] numbers = {1, 1, 1, 1, 1};
		 int target = 3;
		 int answer = dfs(numbers, target, 0, 0);
		 System.out.println(answer);
	}

}
