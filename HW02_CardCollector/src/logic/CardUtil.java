package logic;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for (UnitCard c : list) {
			if (c.getName().equals(card.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for (UnitDeck d : list) {
			if (d.getDeckName().equals(deck.getDeckName())) {
				return true;
			}
		}		
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for (UnitDeck d : deckList) {
			if(d.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		Scanner scanner;
		try {
            scanner = new Scanner(fileToRead);
            ArrayList<UnitCard> temp = new ArrayList<UnitCard>();
            while (scanner.hasNextLine()) {
            	String[] line;
            	try {
                line = scanner.nextLine().split(",", 5);
                String cardName = line[0];
                int bloodCost = Integer.parseInt(line[1]);
				int power = Integer.parseInt(line[2]);
				int health = Integer.parseInt(line[3]); 
				String flavorText = line[4];
				
				UnitCard newCard = new UnitCard(cardName,bloodCost,power,health,flavorText);
				temp.add(newCard);
				} catch (Exception e) {
					System.out.println("File contains string with incorrect format!");
					scanner.close();
					return null;
				}
            }
            scanner.close();
        	for(UnitCard c : temp) {
        		cardsFromFile.add(c);
        	}
        } catch (FileNotFoundException e) {
        	System.out.println("Cannot find file!");
        	return null;
        }
		
		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
