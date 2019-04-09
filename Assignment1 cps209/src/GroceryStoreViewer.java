import javax.swing.JFrame;

/*
* @author Nicholas Dhanraj ID:500825354 This program allows the user to view
*         font effects.
*/
public class GroceryStoreViewer {

	public static void main(String[] args) throws Exception {
		JFrame frame = new GroceryStoreFrame();
		frame.setResizable(true);
		frame.setOpacity(1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Grocery Store Simulator");
		frame.setVisible(true);
	
	}
}