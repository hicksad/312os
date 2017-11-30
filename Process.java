import java.util.Random;
import java.util.Scanner;

public class Process implements Comparable {

	public String name;
	public int id;

	public String[] program;
	boolean needsNewLine;
	public int executedLines;

	public int arrivalTime;
	public int startTime;
	public int burstTime;
	public int waitingTime;
	public int priority;
	public int ioTime;

	public int state; // 1-6 - NEW, READY, RUN, WAIT, CSWAIT, EXIT

	public int memReq;
	public int timeReq;
	public int timeUsed;
	public int ioCount;

	/**
	 * Initializes a process with a new state with an arrival time and
	 * memory+time requirements
	 */
	public Process(String name, int arrivalTime) {

		this.name = name;
		this.arrivalTime = arrivalTime;
		setState(1);
		setMemReq(0);
		setTimeReq(0);
		setTimeUsed(0);
		setIoCount(0);
		setIoTime(0);
		setBurstTime(0);
		setExecutedLines(0);
		setNeedsNewLine(true);
	}
	
	public int generateMemReq(){
		setMemReq(Integer.parseInt(getProgram(0)));
		return getMemReq();
	}

	/**
	 * Runs a global "tick" on the process if it's in running or waiting for an
	 * I/O completion.
	 */
	public void processTick() {

		switch (state) {
		
		case 2: //ready
			
			incWaitingTime();

		case 3: // running
			decBurstTime();
			
			incTimeUsed();
			
			if(getBurstTime()==0){
				setNeedsNewLine(true);
			}

		case 4: // waiting for I/O
			decIoTime();
			
			incIoCount();
			
			if(getIoTime()==0){
				setNeedsNewLine(true);
			}
		//case 5????
		}
	}
	
	public void doNextLine(){
		
		String command = "";
		int parameter = 0;
		
		if(isNeedsNewLine() == true){
			incExecutedLines();
			setNeedsNewLine(false);
		}
		
		if(getExecutedLines()>getProgram().length){
			setState(6);
			return;
		}
		
		String line = getProgram(getExecutedLines());
		
		if(line.contains(" ")){
			int space = line.indexOf(" ");
			command = line.substring(0,  space);
			parameter = Integer.parseInt(line.substring(space+1,  line.length()+1));
		}
		else{
			command = line;
		}
		
		switch(command){
		
			case "CALCULATE" :
				
				setState(3);
				setBurstTime(parameter);
				
			case "IO" :
				
				setState(4);
				Random rand = new Random();
				int randomNum = rand.nextInt(25) + 25;
				 
			case "YIELD" :
				 
				setState(2);
				setNeedsNewLine(true);
				
			case "OUT" :
				
				//do a print
				setNeedsNewLine(true);
				
			case "CRIT_ON" :
				
				setNeedsNewLine(true);
				
			case "CRIT_OFF" :
				
				setNeedsNewLine(true);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProgram(int index) {
		return program[index];
	}

	public String[] getProgram() {
		return program;
	}

	public void setProgram(String[] program) {
		this.program = program;
	}

	public int getExecutedLines() {
		return executedLines;
	}

	public void setExecutedLines(int executedLines) {
		this.executedLines = executedLines;
	}

	public void incExecutedLines() {
		executedLines++;
	}
	
	public boolean isNeedsNewLine() {
		return needsNewLine;
	}

	public void setNeedsNewLine(boolean needsNewLine) {
		this.needsNewLine = needsNewLine;
	}
	
	public int getTimeRemaining(){
		return getTimeReq()-getTimeUsed();
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}

	public void decBurstTime() {
		burstTime--;
	}
	
	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	
	public void incWaitingTime(){
		waitingTime++;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getIoTime() {
		return ioTime;
	}

	public void setIoTime(int ioTime) {
		this.ioTime = ioTime;
	}

	public void decIoTime() {
		ioTime--;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getMemReq() {
		return memReq;
	}

	public void setMemReq(int memReq) {
		this.memReq = memReq;
	}

	public int getTimeReq() {
		return timeReq;
	}

	public void setTimeReq(int timeReq) {
		this.timeReq = timeReq;
	}

	public int generateTimeReq() {

		timeReq = 0;

		for (int i = 1; i < program.length; i++) {
			if (program[i].matches(".*\\d+.*")) {
				String temp = program[i];
				timeReq += Integer.parseInt(temp.replaceAll("[\\D]", ""));
			}
		}
		return timeReq;
	}

	public void incTime() {
		timeUsed++;
	}

	public int getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(int timeUsed) {
		this.timeUsed = timeUsed;
	}

	public void incTimeUsed() {
		timeUsed++;
	}

	public int getIoCount() {
		return ioCount;
	}

	public void setIoCount(int ioCount) {
		this.ioCount = ioCount;
	}

	public void incIoCount() {
		ioCount++;
	}

	@Override
	public String toString() {
		return "PROCESS DATA: [name=" + name + ", id=" + id + ", arrivalTime=" + arrivalTime + ", startTime="
				+ startTime + ", burstTime=" + burstTime + ", priority=" + priority + ", state=" + state + ", memReq="
				+ memReq + ", timeReq=" + timeReq + ", timeUsed=" + timeUsed + ", ioCount=" + ioCount + "]";
	}

	public String getPCB() {
		return "PROCESS DATA: [name=" + name + ", id=" + id + ", arrivalTime=" + arrivalTime + ", startTime="
				+ startTime + ", burstTime=" + burstTime + ", priority=" + priority + ", state=" + state + ", memReq="
				+ memReq + ", timeReq=" + timeReq + ", timeUsed=" + timeUsed + ", ioCount=" + ioCount + "]";
	}

	@Override
	public int compareTo(Object compare) {
		int compareTime = ((Process) compare).getArrivalTime();
		return this.getArrivalTime() - compareTime;
	}
}
