
public class Process {

	public String name;
	public int id;
	
	public int arrivalTime;
	public int startTime;
	public int burstTime;
	public int priority;
	public int ioTime;

	public int state; //1-5 - NEW, READY, RUN, WAIT, EXIT
	
	public int memReq;
	public int timeReq;
	public int timeUsed;
	public int ioCount;
	
	public Process(String name, int memReq, int timeReq){
		setState(1);
		setTimeUsed(0);
		setIoCount(0);
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

	public int getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(int timeUsed) {
		this.timeUsed = timeUsed;
	}

	public int getIoCount() {
		return ioCount;
	}

	public void setIoCount(int ioCount) {
		this.ioCount = ioCount;
	}
	
	@Override
	public String toString() {
		return "PCB [name=" + name + ", id=" + id + ", arrivalTime=" + arrivalTime + ", startTime=" + startTime
				+ ", burstTime=" + burstTime + ", priority=" + priority + ", state=" + state + ", memReq=" + memReq
				+ ", timeReq=" + timeReq + ", timeUsed=" + timeUsed + ", ioCount=" + ioCount + "]";
	}
}
