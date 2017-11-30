import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {

	public CPU cpu;

	public ArrayList<Process> AllProcesses = new ArrayList<Process>();
	public ArrayList<Process> New = new ArrayList<Process>();
	public ArrayList<Process> Ready = new ArrayList<Process>();
	public ArrayList<Process> Run = new ArrayList<Process>();
	public ArrayList<Process> Wait = new ArrayList<Process>();
	public ArrayList<Process> WaitCS = new ArrayList<Process>();  //A FIFO queue for critical section
	public ArrayList<Process> Done = new ArrayList<Process>();

	
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

	public void addProcess(Process process) {
		AllProcesses.add(process);
	}

	public void addToNew(Process process) { // adds a new process to the New
											// queue

		New.add(process);
	}

	/**
	 * Moves a process to the ready queue if memory allows
	 */
	public void newToReady() {

		while (New.isEmpty() == false) {
			if (New.get(0).getMemReq() + cpu.getMemory() <= 4096) {
				Ready.add(New.get(0));
				Ready.get(Ready.size() - 1).setState(2);
				New.remove(0);
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

	public void runToWait() {

		Wait.add(Run.get(0));
		Wait.get(Wait.size() - 1).setState(4);
		Run.remove(0);
	}

	public void waitToRun() {

		Run.add(Wait.get(0));
		Run.get(Run.size() - 1).setState(3);
		Wait.remove(0);
	}

	public void firstInFirstOutTick() {
		
		Collections.sort(AllProcesses);

		while (AllProcesses.get(0).getArrivalTime() < cpu.getcpuTime()) {
			AllProcesses.remove(0);
		}

		if (AllProcesses.get(0).getArrivalTime() == cpu.getcpuTime()) {
			addToNew(AllProcesses.get(0));
			newToReady();
		}
	}
}
