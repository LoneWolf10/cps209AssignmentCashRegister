/**
 * @author Nicholas Dhanraj ID:500825354
 */

public class GroceryItem {

	private String label;
	private double price;
	private int foodCode;

	/**
	 * default constructer
	 */
	public GroceryItem() {
		this.label = "";
		this.price = 0;
		this.foodCode = 0;
	}

	/**
	 * @param foodCode
	 * @param label
	 * @param price
	 */
	public GroceryItem(int foodCode, String label, double price) {
		this.foodCode = foodCode;
		this.label = label;
		this.price = price;
	}

	/**
	 * @param foodCode
	 * @param label
	 */
	public GroceryItem(int foodCode, String label) {
		this.foodCode = foodCode;
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @param foodCode
	 */
	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}

	public int getFoodCode() {
		return this.foodCode;
	}

}

class Dairy extends GroceryItem {

	private double volume;

	/**
	 * @param foodCode
	 * @param label
	 * @param price
	 */
	public Dairy(int foodCode, String label, double price, int vol) {

		super(foodCode, label, price);
		this.volume = vol;
	}

	public double getPrice() {
		return super.getPrice() * volume;
	}

}

class Meat extends GroceryItem {
	
	private double weight;

	/**
	 * @param foodCode
	 * @param label
	 * @param price
	 */
	public Meat(int foodCode, String label, double price,int weight) {
		super(foodCode, label, price);
		this.weight = weight;
	}


	public double getPrice() {
		return super.getPrice() * weight;
	}
}