
public class CPU {

	public int cpuTime;
	public int memory;
	
	public CPU(){
		cpuTime = 0;
		memory = 0;
	}
	
	public void incTime(){
		
		cpuTime++;
	}
	
	public int getcpuTime(){
		return cpuTime;
	}
	
	public void addMem(int mem){
		memory+= mem;
	}
	
	public void subMem(int mem){
		memory-= mem;
	}
	
	public int getMemory(){
		return memory;
	}
}
