package entity;

public class Food {
	private String name; 
	private int price;
	private int tasteScore;

	public Food(String name, int price, int
	tastescore) {
		this.setName(name);
		this.setPrice(price);
		this.setTasteScore(tastescore);
	}

	public void setTasteScore(int s) {
		if(s<1) {
			this.tasteScore = 1;
		} else if(s>5) {
			this.tasteScore = 5;
		}
		else {
			this.tasteScore = s;
		}
	}
	public boolean equals(Food food) {
		if(this.name == food.name & this.price == food.price & this.tasteScore == food.tasteScore) {
			return true;
		}
		return false;
	}
	//1) Both names are the same.
	//2) Both prices are the same.
	//3) Both tasteScores are the same.

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", tasteScore=" + tasteScore + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTasteScore() {
		return tasteScore;
	}
	
}
