import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NutritionChart {

	private Map<Integer, FoodType> list = new HashMap<>();

	// Iterator<E>
	@SuppressWarnings("resource")
	public NutritionChart() throws FileNotFoundException {

		String label;
		int code;
		int cal;
		int sugar;
		int fat;
		int carbs;
		int measure;
		Scanner in = new Scanner(new File("nutrition.txt"));

		while (in.hasNext()) {			
			label = "";
			
			code = in.nextInt();

			while (!in.hasNextInt()) {
				label += " " + in.next();
			}
		
			measure = in.nextInt();
			cal = in.nextInt();
			sugar = in.nextInt();
			fat = in.nextInt();
			carbs = in.nextInt();



			list.put(code, new FoodType(code, label, cal, sugar, fat, carbs));
		}

	}

	public FoodType getFoodType(int foodCode) {
		Set<Integer> keySet = list.keySet();

		//Iterator<Integer> iter = keySet.iterator();
		for (Integer key : list.keySet()) {
			FoodType foodTypeCode = list.get(key);

			if (foodTypeCode.getFoodCode() == foodCode)
				return foodTypeCode;
		}
			return null;
		

	}
}