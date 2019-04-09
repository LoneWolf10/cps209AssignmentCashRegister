import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 * @author Nicholas Dhanraj ID:500825354
 */

public class NutritionScanner {

	private NutritionChart chart;

	public static ArrayList<FoodType> items = new ArrayList<FoodType>();

	public NutritionScanner() {
		try {
			chart = new NutritionChart();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param foodCode the food code from the other int
	 */
	public void scanFoodCode(int foodCode) {

		boolean isMatch = false;

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getFoodCode() == foodCode) {
				items.get(i).setMeasure();

				isMatch = true;
			}

		}
		if (!isMatch) {
			items.add(chart.getFoodType(foodCode));
		}
	}

	/**
	 * @param displayArea the JTextArea varibale that is to display the text
	 * @return JTextArea the formatted display area
	 */
	public JTextArea displayAll(JTextArea displayArea) {
		// System.out.println(items.size());
		displayArea.setText("");
		displayArea.append("\n");

		/*
		 * for(int i = 0; i < items.size(); i++) {
		 * //displayArea.append(items.get(i).getLabel() + items.get(i).getCal() +
		 * items.get(i).getSugar() + items.get(i).getFat() + items.get(i).getCarbs());
		 * displayArea.append(items.get(i).toString()); }
		 */
		for (FoodType i : items)
			displayArea.setText(displayArea.getText() + i.toString() + "\n");

		return displayArea;

	}

	public void clear() {
		items.clear();
		


		for (int i = 0; i < items.size(); i++) {
		 
				items.get(i).setMeasureClear();

		}
	}
}


