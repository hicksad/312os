import java.util.ArrayList;
import java.util.Collections;

public class ArrayTester {

	public static void main(String[] args) {
		ArrayList<Process> New = new ArrayList<Process>();

		Process apple = new Process("Apple", 10, 100, 50);
		Process orange = new Process("Orange", 20, 50, 30);
		Process pear = new Process("Pear", 0, 0, 100);

		New.add(apple);
		New.add(orange);
		New.add(pear);

		System.out.println(New.size());

		for (Process str : New) {
			System.out.println(str);
		}
		
		Collections.sort(New);
		System.out.println("Sorted.");
		
		for (Process str : New) {
			System.out.println(str);
		}
	}
}
