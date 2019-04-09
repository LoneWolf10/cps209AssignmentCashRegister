import java.util.ArrayList;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;

/**
 * @author Nicholas Dhanraj ID:500825354
 */

public class CashRegister {

	private String totalPriceToString = "";

	private ArrayList<GroceryItem> list;

	/**
	 * default constructor
	 */
	public CashRegister() {
		list = new ArrayList<GroceryItem>();
	}

	/**
	 * @param area the area to which the text goes within
	 */
	public void displayAll(JTextArea area) {
		double totalPrice = 0;

		try {
			area.setText("");
			area.append("\n");

			for (GroceryItem it : list) {
				totalPrice += it.getPrice();
				area.append(it.getLabel() + "     " + it.getPrice() + "\n");
			}
		} catch (Exception e) {

		}

		totalPriceToString = String.format("Total Price: $ %.2f", totalPrice);

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(Calendar.getInstance().getTime());
		area.append("___________________________________" + "\n");
		area.append(totalPriceToString + "\n");
		area.append(timeStamp);

	}

	/**
	 * clears the list
	 */
	public void clear() {
		list = new ArrayList<GroceryItem>();
	}

	/**
	 * @param item
	 */
	public void scanItem(GroceryItem item) {
		list.add(item);
	}

}
