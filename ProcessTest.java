
public class ProcessTest {

	public static void main(String[] args) {
		String[] array = new String[8];
		array[0] = "250";
		array[1] = "CALCULATE 1";
		array[2] = "IO";
		array[3] = "CALCULATE 1";
		array[4] = "CRIT_ON";
		array[5] = "CALCULATE 1";
		array[6] = "CRIT_OFF";
		array[7] = "OUT";
		
		Process test = new Process("imATest", 1);
		test.setProgram(array);
		test.generateTimeReq();
		test.generateMemReq();
		System.out.println(test.toString());
		test.printProgram();
		
		test.goToNextLine();
		System.out.println(test.toString());
		
		test.goToNextLine();
		
		test.processTick();
		System.out.println(test.toString());
		test.goToNextLine();
		System.out.println(test.toString());
		test.processTick();
		System.out.println(test.toString());
		
		test.goToNextLine();
		test.processTick();
		System.out.println(test.toString());
		
		test.goToNextLine();
		test.processTick();
		System.out.println(test.toString());
		
		test.goToNextLine();
		test.processTick();
		System.out.println(test.toString());
		
		test.goToNextLine();
		test.processTick();
		System.out.println(test.toString());
		
		
		/**System.out.println(test.toString());
		
		test.goToNextLine();
		System.out.println(test.toString());
		
		test.processTick();
		System.out.println(test.toString());*/
	}
}
