import java.util.ArrayList;

public class Scheduler {
	
	public CPU cpu;
	
	public ArrayList<Process> New = new ArrayList<Process>();
	public ArrayList<Process> Ready = new ArrayList<Process>();
	public ArrayList<Process> Run = new ArrayList<Process>();
	public ArrayList<Process> Wait = new ArrayList<Process>();
		
	public void addToNew(Process process){ //adds a new process to the New queue
		New.add(process);
	}
	
	public void newToReady(){ // if memory allows, move elements from New to Ready
		while(New.isEmpty() == false){
			if(New.get(0).getMemReq() + cpu.getMemory() <= 4096){
				Ready.add(New.get(0));
				Ready.get(Ready.size()-1).setState(2);
				New.remove(0);
			}
		}
	}
	
	public void ReadyToRun(){
		
	}
}
