import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SchedulerTester {
	
	public static void main(String[]args) throws FileNotFoundException{
		
		Scheduler sch = new Scheduler();
		
		Process one = new Process("p1", 0);
		Process two = new Process("p2", 3);
		Process three = new Process("p3", 10);
		
		Process four = new Process("p4", 0);
		Process five = new Process("p5", 3);
		Process six = new Process("p6", 10);
		
		FileReaders fileReader = new FileReaders();
		fileReader.fileToArray("program.txt");
		
		one.setProgram(FileReaders.fileToArray("program.txt"));
		two.setProgram(FileReaders.fileToArray("programm.txt"));
		three.setProgram(FileReaders.fileToArray("programmm.txt"));
		
		four.setProgram(FileReaders.fileToArray("program.txt"));
		five.setProgram(FileReaders.fileToArray("programm.txt"));
		six.setProgram(FileReaders.fileToArray("programmm.txt"));
		
		one.retrieveData();
		two.retrieveData();
		three.retrieveData();
		
		four.retrieveData();
		five.retrieveData();
		six.retrieveData();
		
		//one.printProgram();
		//two.printProgram();
		//three.printProgram();
		
		sch.addProcess(one);
		sch.addProcess(two);
		sch.addProcess(three);
		
		sch.addProcess(four);
		sch.addProcess(five);
		sch.addProcess(six);
		
		sch.allToNew();
		//sch.printQueues();
		sch.newToReady();
		//sch.printQueues();
		sch.tick();
		sch.firstInFirstOut();
		sch.printQueues();
		
		
		for(int i=0; i<1000; i++){
			sch.tick();
			
			if(i%12==0){
				System.out.println("---====================PRINTING QUEUES==================---");
				System.out.println("===GLOBAL COUNTER IS " + sch.getCpu().getcpuTime());
				sch.printQueues();
			}
			
		}
		
		one.outCommand();
		two.outCommand();
		three.outCommand();
		four.outCommand();
		five.outCommand();
		six.outCommand();	
		
	}
}
