
public class Deck extends DeQLinkedList{
	DeQLinkedList deck;

	public Deck(){
		this.deck = new DeQLinkedList();
	}
	public int draw(){
		int ans = -1;
		if(isEmpty()) {
			return ans;
		}
		
		//since testDraw() dont have throws, we cant add throw here
		try {
			ans = this.removeFirst();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}
	
	public int removeNth(int n) {
		//System.out.println("/////////////////////first n = "+n);
		int NthCard = -1;
		//System.out.println("this.size() ="+this.size());
		DeQLinkedList list = new DeQLinkedList();
		int sizeOG = this.size();
		for(int i=0; i<sizeOG;i++) {
			//System.out.println("i = "+i);
			int currentCard = 0;
			currentCard = this.draw();
			//System.out.println("CC draw="+currentCard);
			if(n==i) {
				NthCard = currentCard;
				//System.out.println("Nthcard found");
				//System.out.println("i = "+i);
				//System.out.println("n = "+n);
				break;
			} //else {
			try {
				list.insertFirst(currentCard);
				//System.out.println("CC inserted="+currentCard);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println("error");
				//e.printStackTrace();
				}
			//}
			//System.out.println("looping");
		}
		int sizeNew = list.size();
		for(int i=0; i<sizeNew;i++) {
			try {
				this.insertFirst(list.removeFirst());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//System.out.println(list.size());
		//System.out.println(this.size());
		return NthCard;
	}
	
	public void putBottom(int n) {
		try {
			//if (isEmpty()) {
				//insertFirst(n);
			//}
			this.insertLast(n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void reverseTopN(int n) {
		DeQLinkedList list = new DeQLinkedList();
		int sizeOG = this.size();
		for(int i=0; i<sizeOG;i++) {
			int currentCard = 0;
			currentCard = this.draw();
			if(n==i) {
				try {
					list.insertFirst(currentCard);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			} 
			try {
				list.insertLast(currentCard);
			} catch (Exception e) {
				}
		}
		int sizeNew = list.size();
		for(int i=0; i<sizeNew;i++) {
			try {
				this.insertFirst(list.removeFirst());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}		
}
