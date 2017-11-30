import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaders {

	// public ArrayList<String> commands = new ArrayList<String>();

	/**public void jobLineToCommand(String commandLine) {

		String command = "";
		String parameter = "";

		Scanner sc = new Scanner(commandLine);
		sc.useDelimiter(" ");

		Scanner sc1 = new Scanner(sc.next());
		Scanner sc2 = new Scanner(sc.next());

		while (sc1.hasNext()) {
			command = command + sc1.next() + " ";
		}
		command = command.substring(0, command.length() - 1);

		while (sc2.hasNext()) {
			parameter = parameter + sc2.next() + " ";
		}
	}*/

	/**
	 * @param FILE NAME
	 * @return an array of the lines of the file
	 */
	public static String[] fileToArray(String file) throws FileNotFoundException {

		ArrayList<String> commands = new ArrayList<String>();

		Scanner sc = new Scanner(new BufferedReader(new FileReader(file))); //file to be read in

		while (sc.hasNextLine()) {
			commands.add(sc.nextLine());
		}
		
		String[] commandsArray = new String[commands.size()];
		
		for (int i=0; i<commands.size(); i++) {
			commandsArray[i] = commands.get(i);
		}
		
		return commandsArray;
	}
}
