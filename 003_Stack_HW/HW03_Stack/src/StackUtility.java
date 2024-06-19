
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		MyStack s3 = new StackLinkedList();
		String DeCoded = "";
		int result = -1;
		while(s1.size()>1) {
			int s1Node1 = s1.top();
			s1.pop();
			int s1Node2 = s1.top();
			s1.pop();
			int s2Node = s2.top();
			s2.pop();
			if(s2Node < 0) {
				result = s1Node1 - s1Node2;
			}else { //s2.Node.data >= 0
				result = s1Node1 + s1Node2;
			}
			s3.push(result);

		}
		int s3Size = s3.size();
		for(int i=0; i<s3Size;i++) {
			int s3Node = s3.top();
			s3.pop();
			if(s3Node <0) {
				s3Node = 0;
			}
			DeCoded += alphabets.charAt(s3Node);
		}
		return DeCoded;
	}
}
