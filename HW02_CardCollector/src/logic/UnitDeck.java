package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		setCardsInDeck();
		setDeckName(deckName);
	}
	public void setDeckName(String deckName) {
		if(deckName.isBlank()) {
			deckName = "Untitled Deck";
		}
		this.deckName = deckName;
	}
	public String getDeckName() {
		return this.deckName;
	}
	public ArrayList<CardCounter> getCardsInDeck(){
		return this.cardsInDeck;
	}
	public void setCardsInDeck() {
		this.cardsInDeck = new ArrayList<CardCounter>();
	}
	public void addCard(UnitCard newCard, int count) {
		if (count <= 0) {
			return;
		}
		if (existsInDeck(newCard)) {
			for (CardCounter c : cardsInDeck) {
				if (newCard.equals(c.getCard())) {
					c.setCount(c.getCount() + count);
					return;
				}

			}
		} else {
			CardCounter newCardCounter = new CardCounter(newCard, count);
			cardsInDeck.add(newCardCounter);
		}
	}
	public void removeCard(UnitCard toRemove,int count) {
		if (count <= 0) {
			return;
		}
		if (existsInDeck(toRemove)) {
			for (CardCounter c : cardsInDeck) {
				if (toRemove.equals(c.getCard())) {
					c.setCount(c.getCount() - count);
					if(c.getCount() <= 0) {
						cardsInDeck.remove(c);
					}
					return;
				}

			}
		} else {
			return;
		}
	}
	public int cardCount() {
		int n = 0;
		for (CardCounter c : cardsInDeck) {
			n += c.getCount();
		}
		return n;
	}
	public boolean existsInDeck(UnitCard card) {
		for (CardCounter c : cardsInDeck) {
			if (c.getCount() >= 1 && c.getCard().getName().equals(card.getName())) {
				return true;
			}
		}
		return false;
	}
	public boolean equals(UnitDeck other) {
		if(this.deckName == other.getDeckName()) {
			return true;
		}
		return false;
	}
}
