package practice;
import java.util.*;

public class Kakao2020_2 {
	 static boolean check(String s) {
			boolean chk = true;
			Stack<String> stack = new Stack<String>();
			for(int i=0; i<s.length(); i++) {
				if(s.substring(i,i+1).equals("(")) {
					stack.push("(");
				}else {
					if(stack.isEmpty()) {
						chk = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			return chk;
		}
		static int division(String s) {
			int a =0, b=0;
			int idx = 0;
			for(int i=0; i<s.length(); i++) {
				if(s.substring(i, i+1).equals("(")) {
					a++;
				}else {
					b++;
				}
				if(a == b) {
					idx = i;
					break;
				}
			}
			return idx;
		}
		static String makeCorrectString(String s) {
			if(s.equals("")) return s;
			String result = "";
			int idx = division(s);
			String u = s.substring(0, idx+1);
			String v = "";
			if(idx+1 < s.length()) {
				v = s.substring(idx+1, s.length());
			}
			
			if(check(u) == true) {
				result += u + makeCorrectString(v);
			}else {
				result = "(" + makeCorrectString(v) + ")";
				u = u.substring(1, u.length()-1);
				if(!u.equals("")) {
					for(int i=0; i<u.length(); i++) {
						if(u.substring(i,i+1).equals("(")) result += ")";
						if(u.substring(i,i+1).equals(")")) result += "(";
					}
				}
			}
			return result;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p ="()))((()";
		String answer = "";
        if(check(p)){
            answer = p;
        }else{
            answer = makeCorrectString(p);
        }
        System.out.println(answer);
	}

}
