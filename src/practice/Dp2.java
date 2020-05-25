package practice;

public class Dp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 6;
		long[] m = new long[N];
        m[0] = 1;
        m[1] = 1;
        if(N > 1){
            for(int i=2; i<m.length; i++){
                m[i] = m[i-1] + m[i-2];
            }
        }
        long answer = m[N-1]*4 + m[N-2]*2;
        System.out.println(answer);
	}

}
