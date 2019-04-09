import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Box;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ConveyerBelt extends JComponent {
	LinkGroceryItem first = null;
	LinkGroceryItem pickedUpItem = null;

	public ConveyerBelt() {
		class ml implements MouseListener, MouseMotionListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (pickedUpItem != null &&  e.getY() > 0) {
					if (e.getY() > 170) {
						addItem();
					} else {
						pickedUpItem.setLocation(e.getX(), e.getY());
					}
					repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		}
		addMouseMotionListener(new ml());
	}

	public int numItems() {
		if (first == null)
			return 0;
		else {
			LinkGroceryItem temp = first;
			int count = 1;

			while (temp.next != null) {
				count++;
				temp = temp.next;
			}
			return count;
		}

	}

	public void setPickedUpItem(GroceryItem item) {
		if (pickedUpItem == null) {
			pickedUpItem = new LinkGroceryItem(item, null);
			pickedUpItem.setLocation(350, 30);
			repaint();
		} else {
			System.out.println("could not set pick up item it is not null");
		}
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D g3 = (Graphics2D) g;
		Graphics2D g4 = (Graphics2D) g;
		Graphics2D g5 = (Graphics2D) g;
		Graphics2D g6 = (Graphics2D) g;


	
		if (pickedUpItem != null)
			pickedUpItem.draw(g2);

		if (first != null)
			first.draw(g2);
		
		
		
		g2.setColor(Color.BLACK);
		g2.fillRect(275, 270, 440, 20);
		
		g2.setColor(Color.GRAY);
		g2.fillRect(280, 273, 430, 14);
		
		g3.setColor(Color. BLACK);
		g3.fillRect(345, 10, 85, 15);

		g4.setColor(Color. BLACK);
		g4.fillRect(338, 10, 10, 50);
		
		g4.setColor(Color. BLACK);
		g4.fillRect(428, 10, 10, 50);


	}

	public void addItem() {

		if (numItems() < 5) {
			LinkGroceryItem temp = first;
			pickedUpItem.setLocation(310, 228);
			first = pickedUpItem;
			first.next = temp;
			pickedUpItem = null;
			repaint();
		}

	}

	public GroceryItem removeItem() {
		GroceryItem remove = null;
		LinkGroceryItem position = first;
		LinkGroceryItem previous = first;

		if (first.next == null) {
			remove = first.gitem;
			first = null;
			repaint();
			return remove;
		}

		else {
			while (position.next != null) {
				previous = position;
				position = position.next;

			}
			remove = previous.next.gitem;
			previous.next = null;
			repaint();
			return remove;

		}

	}

	private class LinkGroceryItem {
		private GroceryItem gitem = null;
		private LinkGroceryItem next = null;
		private Rectangle box = null;

		public LinkGroceryItem(GroceryItem gitem, LinkGroceryItem next) {
			this.gitem = gitem;
			this.next = next;
			box = new Rectangle(200, 200, 75, 41);
		}

		public void setLocation(int x, int y) {
			box.setLocation(x, y);
		}

		public boolean intersects(LinkGroceryItem item) {
			return box.intersects(item.box);

		}

		public void draw(Graphics2D g2) {
			g2.draw(box);
			g2.drawString(gitem.getLabel(), (int) box.getX() + 6, (int) box.getY() + 30);
			try {
				if (next != null) {
					next.setLocation((int) this.box.getX() + 75, (int) this.box.getY());
					next.draw(g2);
				}
			} catch (Exception e) {
				System.out.println("caught: " + e.getMessage());
			}
		}
	}
}