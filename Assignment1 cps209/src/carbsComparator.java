import java.util.Comparator;

/**
 * @author Nicholas Dhanraj ID:500825354
 */

public class carbsComparator implements Comparator<FoodType> {

	@Override
	public int compare(FoodType o1, FoodType o2) {
		return o2.getCarbs() - o1.getCarbs();
	}

}
