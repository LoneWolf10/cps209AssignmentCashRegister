import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JTextArea;



/**
 * @author Nicholas Dhanraj ID:500825354
 */
   
public class GroceryCart {
	private Stack<GroceryItem> stack = new Stack<>();
	private Iterator<GroceryItem> iter;

	public static int nextItem = 0;
    
	/**
	 * @param item
	 */
	public void addItem(GroceryItem item) {
		stack.push(item);
	}

	/**
	 * fills the list with food items according to the file
	 * 
	 * @throws FileNotFoundException
	 */
	public void fill() throws FileNotFoundException {

		String lineTester;
		String label;
		int code;
		int vol;
		int weight;
		double price;

		@SuppressWarnings("resource")
		Scanner in = new Scanner(new File("groceryItems.txt"));
		while (in.hasNext()) {

			label = "";
			code = in.nextInt();
			lineTester = in.next();

			if (lineTester.equals("Meat")) {
				//in.next();

				while (!in.hasNextDouble()) {
					label += " " + in.next();
				}
				label = label.substring(1,label.length());
				price = in.nextDouble();
				weight = in.nextInt();

				stack.push(new Meat(code, label, price, weight));

			} else if (lineTester.equals("Dairy")) {
			//	in.next();

				while (!in.hasNextDouble()) {
					label += " " + in.next();
				}

				price = in.nextDouble();
				vol = in.nextInt();
				label = label.substring(1,label.length());

				stack.push(new Meat(code, label, price, vol));
			}
			else //(!lineTester.equals("Dairy") || !lineTester.equals("Meat")) 
				{
				label = lineTester;
				while (!(in.hasNextDouble())) {
					label += " " + in.next();
				}
				//label = in.next();
				price = in.nextDouble();
				
			//	in.next();

				stack.push(new GroceryItem(code, label, price));
			}
			
		}
	}

	/**
	 * @param area
	 *            the JTextArea that the list is supposed to show in
	 */
	public void display(JTextArea area) {
		area.setText("");

		iter = stack.iterator();
		while (iter.hasNext()) {
			area.append(iter.next().getLabel() + "\n");
		}
	}

	/**
	 * @return the top grocery item without removing it
	 */
	public GroceryItem removeTopItem() {
		try {
			return stack.pop();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * @return return the next item without removing it
	 */
	public GroceryItem returnNextItem() {
		try {
			return stack.get(nextItem++);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * resets the counter variable nextItem
	 */
	public void resetNextItem() {
		nextItem = 0;
	}
}