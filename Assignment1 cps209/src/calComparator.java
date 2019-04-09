import java.util.Comparator;

/**
 * @author Nicholas Dhanraj ID:500825354
 */

public class calComparator implements Comparator<FoodType> {

	@Override
	public int compare(FoodType o1, FoodType o2) {
		return o2.getCal() - o1.getCal();
	}

}
