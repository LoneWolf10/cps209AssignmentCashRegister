import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class GroceryStoreFrame extends JFrame {

	private GroceryCart cart = new GroceryCart();
	private CashRegister cartEmpty = new CashRegister();
	private NutritionScanner chart;
	private ConveyerBelt items = new ConveyerBelt();
	

	private JButton refillBtn;
	private JButton checkBtn;
	private JButton scanGroceryItem;
	private JButton scanFooditem;
	private JButton btnCarbs;
	private JButton btnFat;
	private JButton btnSugar;
	private JButton btnCalories;

	private JLabel label;;

	private JTextArea area;
	private JTextArea textArea;
	private JTextArea resultArea;
	private JTextArea textArea_1_1;

	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 40;

	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 900;
	private JScrollPane scrollPane_2;

	public GroceryStoreFrame() throws FileNotFoundException {

		// createScanItemsPanel();
		createCashRegisterPanel();
		createNutritionScannerPanel();
		createGroceryCartPanel();

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 1000, 700);

		items.setBounds(0, 31, 1000, 678);
		getContentPane()/* contentPane. */.add(items);

		JButton btnNewButton = new JButton("Pickup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//GroceryCart temp = new GroceryCart();
			//	temp = cart.returnNextItem();
				if(items.pickedUpItem == null && cartEmpty != null) {
				items.setPickedUpItem(cart.removeTopItem());
				items.repaint();

				cart.display(resultArea);
				}
			}
			
		});
		btnNewButton.setBounds(350, 6, 99, 20);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add");
		class add implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (items.pickedUpItem != null) 

				items.addItem();
				
				
			}
		}

		ActionListener listenerAdd = new add();
		btnNewButton_1.addActionListener(listenerAdd);

		btnNewButton_1.setBounds(105 + 350, 6, 99, 20);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Scan");

		class scan implements ActionListener {
			public void actionPerformed(ActionEvent event) {

				System.out.println("scanning...");
				if (items.numItems() > 0) {
					cartEmpty.scanItem(items.removeItem());
					cartEmpty.displayAll(textArea);
					System.out.println("works");
				}
			}
		}

		ActionListener listenerScan = new scan();
		btnNewButton_2.addActionListener(listenerScan);

		btnNewButton_2.setBounds(211 + 350, 6, 99, 20);
		getContentPane().add(btnNewButton_2);
	}

	public void createGroceryCartPanel() {

		try {
			cart.fill();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		label = new JLabel("Grocery Cart");
		label.setIcon(new ImageIcon(
				GroceryStoreFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/newFolder.gif")));
		label.setBackground(SystemColor.controlDkShadow);
		label.setBounds(15, 11, 153, 34);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 386);
		panel.setBackground(new Color(240, 255, 255));
		panel.setLayout(null);

		panel.add(label);

		getContentPane().add(panel);
		resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);

		cart.display(resultArea);

		resultArea.setLineWrap(true);
		resultArea.setBackground(SystemColor.info);
		resultArea.setForeground(Color.BLACK);
		resultArea.setBounds(3, 3, 275, 343);
		resultArea.setFont(new Font("Monospaced", Font.PLAIN, 18));

		panel.add(resultArea);
		resultArea.setEditable(false);
		refillBtn = new JButton("REFILL");
		refillBtn.setIcon(new ImageIcon(
				GroceryStoreFrame.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		refillBtn.setBackground(new Color(240, 248, 255));
		refillBtn.setBounds(147, 6, 105, 39);
		refillBtn.setFont(new Font("Dialog", Font.BOLD, 17));
		panel.add(refillBtn);

		JScrollPane scrollPane = new JScrollPane(resultArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(25, 56, 220, 317);

		panel.add(scrollPane);

		class refillCart implements ActionListener {
			public void actionPerformed(ActionEvent event) {

				cart = new GroceryCart();
				try {
					cart.fill();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				cart.display(resultArea);

			}
		}

		ActionListener listener = new refillCart();
		refillBtn.addActionListener(listener);

	}

	public void createCashRegisterPanel() {
		getContentPane().setLayout(null);

		label = new JLabel("Cash Register");
		label.setIcon(null);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(19, 15, 149, 29);

		JPanel panel = new JPanel();
		panel.setBounds(726, 0, 257, 386);
		panel.setBackground(new Color(240, 255, 255));
		panel.setLayout(null);

		panel.add(label);
		JScrollPane scrollPane = new JScrollPane(area);
		scrollPane.setBounds(169, 15, 2, 2);
		panel.add(scrollPane);

		getContentPane().add(panel);

		textArea = new JTextArea(10, 40);
		textArea.setLineWrap(true);
		textArea.setBackground(SystemColor.info);
		textArea.setEditable(false);
		textArea.setBounds(10, 56, 281, 319);
		panel.add(textArea);
		checkBtn = new JButton("CHECKOUT");
		checkBtn.setIcon(new ImageIcon(GroceryStoreFrame.class
				.getResource("/com/sun/javafx/scene/web/skin/UnorderedListBullets_16x16_JFX.png")));
		checkBtn.setBackground(new Color(240, 248, 255));
		checkBtn.setBounds(143, 12, 134, 35);
		checkBtn.setFont(new Font("Dialog", Font.BOLD, 17));
		panel.add(checkBtn);

		JScrollPane scrollPane_1 = new JScrollPane(textArea);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_1.setBounds(35, 56, 217, 319);
		panel.add(scrollPane_1);

		class checkout implements ActionListener {
			public void actionPerformed(ActionEvent event) {

				cartEmpty = new CashRegister();

				cartEmpty.displayAll(textArea);

			}
		}

		ActionListener listener = new checkout();
		checkBtn.addActionListener(listener);

	}

	public void createScanItemsPanel() {
		scanGroceryItem = new JButton("SCAN GROCERY ITEM");
		scanGroceryItem.setIcon(new ImageIcon(GroceryStoreFrame.class
				.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		scanGroceryItem.setBackground(new Color(240, 248, 255));
		scanGroceryItem.setFont(new Font("Terminator Two", Font.BOLD, 19));
		scanGroceryItem.setBounds(6, 16, 315, 46);

		class scanItems implements ActionListener {
			public void actionPerformed(ActionEvent event) {

				cartEmpty.scanItem(cart.removeTopItem());
				cartEmpty.displayAll(textArea);
				cart.display(resultArea);

				cart.nextItem = 0;

			}
		}

		ActionListener listener = new scanItems();
		scanGroceryItem.addActionListener(listener);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(332, 0, 332, 386);
		panel.setLayout(null);

		panel.add(scanGroceryItem);
		// panel.add(lblNewLabel_1);

		getContentPane().add(panel);

	}

	public void createNutritionScannerPanel() throws FileNotFoundException {

		//chart = new NutritionScanner();
		scanFooditem = new JButton("SCAN FOOD ITEM");
		scanFooditem.setBounds(523, 5, 219, 38);
		scanFooditem.setIcon(new ImageIcon(GroceryStoreFrame.class
				.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-enter-button.png")));
		scanFooditem.setBackground(new Color(240, 248, 255));
		scanFooditem.setFont(new Font("X-Files", Font.PLAIN, 15));

		JPanel panel = new JPanel();
		panel.setBounds(10, 384, 984, 266);
		panel.setBackground(new Color(188, 143, 143));
		panel.setLayout(null);

		panel.add(scanFooditem);

		getContentPane().add(panel);
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(741, 5, 122, 38);
		class clearInfo implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				textArea_1_1.setText("");
				chart.clear();
				cart.resetNextItem();
			}
		}

		ActionListener listener = new clearInfo();
		btnClear.addActionListener(listener);

		btnClear.setSelectedIcon(null);
		btnClear.setIcon(new ImageIcon(
				GroceryStoreFrame.class.getResource("/com/sun/javafx/webkit/prism/resources/missingImage.png")));
		btnClear.setBackground(new Color(240, 248, 255));
		btnClear.setFont(new Font("X-Files", Font.PLAIN, 15));
		panel.add(btnClear);

		JLabel lblNewLabel = new JLabel("CART NUTRITION INFORMATION");
		lblNewLabel.setBounds(158, 2, 366, 38);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 22));
		panel.add(lblNewLabel);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 45, 972, 184);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane_2);

		textArea_1_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1_1);
		textArea_1_1.setEditable(false);

		btnCarbs = new JButton("CARBS");
		btnCarbs.setBounds(430, 231, 117, 29);
		panel.add(btnCarbs);

		btnFat = new JButton("FAT");
		btnFat.setBounds(538, 231, 117, 29);
		panel.add(btnFat);

		btnSugar = new JButton("SUGAR");
		btnSugar.setBounds(646, 231, 117, 29);
		panel.add(btnSugar);

		btnCalories = new JButton("CALORIES");
		btnCalories.setBounds(319, 231, 117, 29);
		panel.add(btnCalories);

		class buttonFat implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Collections.sort(chart.items, new fatComparator());
				chart.displayAll(textArea_1_1);
			}
		}

		listener = new buttonFat();
		btnFat.addActionListener(listener);

		class buttonCals implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Collections.sort(NutritionScanner.items, new calComparator());
				chart.displayAll(textArea_1_1);
			}
		}

		listener = new buttonCals();
		btnCalories.addActionListener(listener);

		class buttonCarbs implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Collections.sort(chart.items, new carbsComparator());
				chart.displayAll(textArea_1_1);
			}
		}

		listener = new buttonCarbs();
		btnCarbs.addActionListener(listener);

		class buttonSugar implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				Collections.sort(chart.items, new sugarComparator());
				chart.displayAll(textArea_1_1);
			}
		}

		listener = new buttonSugar();
		btnSugar.addActionListener(listener);

		class scanItemInfo implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				try {
					chart.scanFoodCode(cart.returnNextItem().getFoodCode());
					textArea_1_1 = chart.displayAll(textArea_1_1);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}

		listener = new scanItemInfo();
		scanFooditem.addActionListener(listener);

	}
}