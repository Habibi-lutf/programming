public class Dessert {
	
	private int borek;
	private int cake;
	private int drink;

	public Dessert() {
		borek= 0;
		cake=0;
		drink=0;		
	}

	public int getBorek() {
		return borek;
	}

	public void setBorek(int borek) {
		this.borek += borek;
	}

	public int getCake() {
		return cake;
	}

	public void setCake(int cake) {
		this.cake += cake;
	}

	public int getDrink() {
		return drink;
	}

	public void setDrink(int drink) {
		this.drink += drink;
	}
	
	
}