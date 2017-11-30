import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Helper extends TimerTask {
	public static int i = 0;

	public void run() {
		System.out.println("Timer ran " + ++i);
	}
}

public class Test {
	public static void main(String[] args) {
		/**
		 * Timer timer = new Timer(); TimerTask task = new Helper();
		 * 
		 * timer.schedule(task, 2000, 5000);
		 * 
		 * } System.out.println("abc".substring(0, 1));
		 * System.out.println("abc".substring(0, 2));
		 * System.out.println("abc".substring(1, 2)); }
		 */

		Random rand = new Random();
		int randomNum = rand.nextInt(3) + 1;

		System.out.println("" + randomNum);
	}
}