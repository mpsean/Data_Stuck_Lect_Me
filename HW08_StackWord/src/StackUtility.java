
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		String Ans = "";
		double sizeS1 = Math.floor(s1.size()/2); //pair up
		for(int n=0; n<sizeS1;n++) {
			int v1 = s1.top();
			s1.pop();
			int v2 = s1.top();
			s1.pop();
			if(s2.top()<0) {
				Ans = alphabets.charAt(v1 - v2) + Ans;
			}
			if(s2.top()>=0){
				Ans = alphabets.charAt(v1 + v2) + Ans;
			}
			s2.pop();
		}
		return Ans;
	}
}
