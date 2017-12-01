import java.util.Random;

public class CPU {

	public int cpuTime;
	public int memory;
	public Process[] paging = new Process[4095]; // 0-3967 = main mem, 3968-3999 = registers, 4000-4095 = cache

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
	
	public int getMem(){
		return memory;
	}
	
	public void addToMem(Process process){
		
		for(int i=0; i<process.getMemReq();){
			
			if(paging[i] != null){
				paging[i] = process;
			}
			i++;
		}
	}

	public void removeFromMem(Process process) {

		for (int i = 0; i < 3967; i++) {
			
			if(paging[i].equals(process)){
				paging[i]=null;
			}
		}
	}

	public Process[] getPaging() {
		return paging;
	}

	public void setPaging(Process[] paging) {
		this.paging = paging;
	}
	
	public void randomIO(){

		Random randTime = new Random();
		int randomTime = randTime.nextInt(20) + 1;
		
		if (randomTime == 10) {
			
			Random randIO = new Random();
			int randomIO = randIO.nextInt(39) + 8;

			for(int i=0; i<randomIO; i++){
				//paging[3068+i] = 
			}
		}
	}
}
