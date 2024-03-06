package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count = 0;
	
	public CardCounter(UnitCard card, int count) {
		this.card = card;
		if(count < 0) {
			count = 0;
		}
		this.count = count;
	}
	public UnitCard getCard() {
		return this.card;
	}
	public int getCount() {
		return this.count;
	}
	public void setCard(UnitCard card) {
		this.card = card;
	}
	public void setCount(int count) {
		if(count < 0) {
			count = 0;
		}
		this.count = count;
	}
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}

}
