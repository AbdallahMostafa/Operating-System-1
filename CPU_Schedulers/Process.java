import java.util.ArrayList;

public class Process {
	private String name;
	private int arrivalTime , burstTime;
	private int quantmTime ;
	private int priority;
	private int quantm;
	private boolean preemptive;
	public ArrayList<Integer> historyAg = new ArrayList<>();

	public boolean isPreemptive() {
		return preemptive;
	}
	public void setPreemptive(boolean preemptive) {
		this.preemptive = preemptive;
	}
	public int getQuantm() {
		return quantm;
	}
	public void setQuantm(int quantm) {
		this.quantm = quantm;
	}
	public int waitingtime;
	public int turnaroundtime;

	public Process() {
		this.name="";
		this.arrivalTime=0;
		this.burstTime=0;
		this.quantmTime=0;
		this.priority=0;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getQuantmTime() {
		return quantmTime;
	}
	public void setQuantmTime(int quantmTime) {
		this.quantmTime = quantmTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getBurstTime() {
		return burstTime;
	}
	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	public  void decBurstTime ()
	{
		burstTime-=1;
	}
	public void incPriority()
	{
		priority+=1;
	}
	public void incQuantim() {
		
		quantm+=1;
	}
}