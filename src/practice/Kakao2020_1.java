package practice;

public class Kakao2020_1 {
	static int cal(String s){
        int numberResult = s.length();
        String result = "";
        int count = 1;
        for(int i=1; i <= s.length()/2; i++){
            String res = s.substring(0, i);
            for(int j = i; j<s.length(); j+=i){
            	if(j+i <= s.length()) {
            		if(res.equals(s.substring(j, j+i ))) {
                		count+=1;
                	}else {
                		if(count == 1) {
                			result += res;
                			res = s.substring(j, j+i);
                		}else {
                			result += Integer.toString(count) + res;
                			res = s.substring(j, j+i);
                			count = 1;
                		}
                	}
            	}else {
            		if(count == 1) result += res + s.substring(j, s.length());
            		if(count != 1) result += Integer.toString(count) +res + s.substring(j, s.length());
            		res = "";
            		count = 1;
            	}
            }
            if(count == 1) result += res;
        	if(count != 1) {
        		result += Integer.toString(count) + res;
        		count = 1;
        	}
        	if(result.length() < numberResult) numberResult = result.length();
            result = "";
        }
        return numberResult;   
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcdcdababcdcd"; 
		int answer = cal(s);
	     System.out.println(answer);
	}

}
