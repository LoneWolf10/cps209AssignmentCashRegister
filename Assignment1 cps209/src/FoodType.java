/**
 * @author Nicholas Dhanraj ID:500825354
 */

public class FoodType implements Comparable<FoodType> {

	private String label;
	private int foodCode;
	public int measure = 1;
	private int calories;
	private int sugar;
	private int fat;
	private int carbs;

	public void setMeasure() {
		this.measure++;
	}
	
	public void setMeasureClear() {
this.measure = 1;
			}

	public int getMeasure() {
		return this.measure;
	}

	/**
	 * @param foodCode
	 * @param label
	 * @param calories
	 * @param sugar
	 * @param fat
	 * @param carbs
	 */
	public FoodType(int foodCode, String label, int calories, int sugar, int fat, int carbs) {
		this.foodCode = foodCode;
		this.label = label;
		this.calories = calories;
		this.sugar = sugar;
		this.fat = fat;
		this.carbs = carbs;
	}

	/**
	 * @return the food code
	 */
	public int getFoodCode() {
		return this.foodCode;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * @return the calories count
	 */
	public int getCal() {
		return this.calories * measure;
	}

	/**
	 * @return the sugar count
	 */
	public int getSugar() {
		return this.sugar * measure;
	}

	/**
	 * @return the fat count
	 */
	public int getFat() {
		return this.fat * measure;
	}

	/**
	 * @return the carbs count
	 */
	public int getCarbs() {
		return this.carbs * measure;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(FoodType FoodType) {

		if (this.calories * measure < FoodType.calories * measure)
			return -1;
		else if (this.calories * measure > FoodType.calories * measure)
			return 1;
		else
			return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return label + ":    Calories:  " + calories * measure + "  Sugar:  " + sugar * measure + "  Fat:  "
				+ fat * measure + "  Carbs:  " + carbs * measure;
	}

}
