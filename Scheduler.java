import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {

	public CPU cpu = new CPU();

	public ArrayList<Process> AllProcesses = new ArrayList<Process>();
	public ArrayList<Process> New = new ArrayList<Process>();
	public ArrayList<Process> Ready = new ArrayList<Process>();
	public ArrayList<Process> Run = new ArrayList<Process>();
	public ArrayList<Process> Wait = new ArrayList<Process>();
	public ArrayList<Process> WaitCS = new ArrayList<Process>();
	public ArrayList<Process> Done = new ArrayList<Process>();
	
	public void tick() {
		
		arriveToNew();

		for (Process process : Wait) {
			process.goToNextLine();
			process.waitTick();
		}
		for (Process process : Run) {
			process.goToNextLine();
			process.runTick();
		}
		for (Process process : Ready) {
			process.goToNextLine();
			process.readyTick();
		}
		firstInFirstOut();
		cpu.incTime();
	}

	/**
	 * Moves processes to different queues appropriately after a global tick
	 */
	public void firstInFirstOut() {

		newToReady();

		Collections.sort(Ready);

		if (Run.size() > 0) {
			if (Run.get(0).getStateDesired() == 4) {
				runToWait();
			}
		}

		if (Run.size() > 0) {

			if (Run.get(0).isNeedsNewLine()) {

				Run.get(0).goToNextLine();

				switch (Run.get(0).getStateDesired()) {

				case 6:
					runToDone();
					break;

				case 4:
					runToWait();
					break;

				case 3:
					break;

				case 2:
					runToReady();
					break;
				}
			}
		}

		/**if (Wait.size() > 0) {
			for (int i = 0; i < Wait.size(); i++) {
				if (Wait.get(i).isNeedsNewLine()) {

					Wait.get(i).goToNextLine();

					if (Wait.get(i).getStateDesired() == 6) {
						waitToDone(i);
					}
					if (Wait.get(i).getStateDesired() == 4 || Wait.get(i).getStateDesired() == 2) {
						waitToReady(i);
					}
					else {
						waitToReady(i);
					}
				}
			}
		}*/
		
		if (Wait.size() > 0) {
			for (int i = 0; i < Wait.size(); i++) {
				if (Wait.get(i).isNeedsNewLine()) {

					Wait.get(i).goToNextLine();

					if (Wait.get(i).getStateDesired() == 6) {
						waitToDone(i);
						i--;
					}
					else if (Wait.get(i).getStateDesired() == 4 || Wait.get(i).getStateDesired() == 2) {
						waitToReady(i);
						i--;
					}
					else {
						waitToReady(i);
						i--;
					}
				}
			}
		}
		
		if (Run.size() < 1 && Ready.size() > 0) {

			readyToRun();

			if (Run.size() > 0) {
				if (Run.get(0).getStateDesired() == 4) {
					runToWait();
				}
			}

			if (Ready.size() > 0) {
				firstInFirstOut();
			}
		}
	}
	
	/**
	 * Searches through a queue to find the index of the searched process
	 */
	public int processListSearch(ArrayList<Process> list, Process process) {

		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (process.getName().equals(list.get(i).getName())) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Prints all items in all queues
	 */
	public void printQueues() {
		System.out.println("===NEW===");
		for (Process process : New) {
			System.out.println(process.toString());
		}
		System.out.println("===READY===");
		for (Process process : Ready) {
			System.out.println(process.toString());
		}
		System.out.println("===RUNNING===");
		for (Process process : Run) {
			System.out.println(process.toString());
		}
		System.out.println("===WAIT===");
		for (Process process : Wait) {
			System.out.println(process.toString());
		}
		System.out.println("===DONE===");
		for (Process process : Done) {
			System.out.println(process.toString());
		}
		System.out.println("");
	}
	
	public void setProcesses(ArrayList<Process> inputProcessList) {
		AllProcesses = inputProcessList;
	}

	public void addProcess(Process process) {
		AllProcesses.add(process);
	}

	public void allToNew() {
		for (Process all : AllProcesses) {
			all.retrieveData();
			New.add(all);
		}
	}
	
	public void arriveToNew() {
		for (Process all : AllProcesses) {
			if(all.getArrivalTime()==getCpu().getcpuTime()){
				all.retrieveData();
				New.add(all);
			}
		}
	}

	/**
	 * Moves a process to the ready queue if memory allows
	 */
	public void newToReady() {

		for (int i = 0; i < New.size(); i++) {
			if (New.get(i).getMemReq() + cpu.getMem() <= 4096) {
				Ready.add(New.get(i));
				Ready.get(Ready.size() - 1).setState(2);
				New.remove(i);
				i--;
			}
		}
	}

	public void readyToRun() {

		Run.add(Ready.get(0));
		Run.get(Run.size() - 1).setState(3);
		Ready.remove(0);
	}

	public void runToWait(Process process) {

		int index = processListSearch(Run, process);
		Wait.add(Run.get(index));
		Wait.get(Wait.size() - 1).setState(4);
		Run.remove(index);
	}

	public void runToDone() {

		Done.add(Run.get(0));
		Done.get(Done.size() - 1).setState(6);
		Run.remove(0);
	}

	public void waitToDone(int index) {

		Done.add(Wait.get(index));
		Done.get(Done.size() - 1).setState(6);
		Wait.remove(index);
	}

	public void waitToDone() {

		Done.add(Wait.get(0));
		Done.get(Wait.size() - 1).setState(6);
		Wait.remove(0);
	}

	public void runToWait() {

		Wait.add(Run.get(0));
		Wait.get(Wait.size() - 1).setState(4);
		Run.remove(0);
	}

	public void runToReady() {

		Ready.add(Run.get(0));
		Ready.get(Ready.size() - 1).setState(2);
		Run.remove(0);
	}

	public void waitToReady() {

		Ready.add(Wait.get(0));
		Ready.get(Ready.size() - 1).setState(2);
		Wait.remove(0);
	}

	public void waitToReady(int index) {

		Ready.add(Wait.get(index));
		Ready.get(Ready.size() - 1).setState(2);
		Wait.remove(index);
	}

	public CPU getCpu() {
		return cpu;
	}
}
