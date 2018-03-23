import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RoundRobin {
	private ArrayList<Process> processes;
	private ArrayList<Process> requestqueue = new ArrayList<Process>();
	private ArrayList<Process> finished = new ArrayList<Process>();
	private ArrayList<String> finishedProcess = new ArrayList<String>();
	
	
	public RoundRobin() {
		processes = new ArrayList<Process>();
	}
	public ArrayList<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(ArrayList<Process> processes) {
		this.processes = processes;
	}
	public void roundRobin(ArrayList<Process> processes , int quantm)
	{
		sortArrival(processes);
		Process process = null;
		int time = processes.get(0).getArrivalTime()-1;
		while(true)
		{
			time++;
			while(!processes.isEmpty() && time == processes.get(0).getArrivalTime())
			{
				if(process == null)
				{
					process = processes.get(0);
					processes.remove(0);
					process.setQuantmTime(0);
				}
				else 
				{
					requestqueue.add(processes.get(0));
					processes.remove(0);
				}
			}
		
			if(process.getBurstTime() <=0 && processes.isEmpty() && requestqueue.isEmpty())
			{
				process.turnaroundtime = time - process.getArrivalTime();
				finishedProcess.add(process.getName());
				finished.add(process);
				break;
			}
			if(!requestqueue.isEmpty() && process.getBurstTime() <= 0 )
			{
				process.turnaroundtime=time-process.getArrivalTime();
				finishedProcess.add(process.getName());
				finished.add(process);
				process = requestqueue.get(0);
				requestqueue.remove(0);
				process.setQuantmTime(0);
			}
			if(process.getQuantmTime() == quantm)
			{
				finishedProcess.add(process.getName());
				requestqueue.add(process);
				process = requestqueue.get(0);
				requestqueue.remove(0);
				process.setQuantmTime(0);
			}
			
			process.setQuantmTime(process.getQuantmTime()+1);
			process.decBurstTime();
			
			for(int i=0;i<requestqueue.size();i++)
			{
				requestqueue.get(i).waitingtime++;
			}
		}
	}
	private void sortArrival(ArrayList<Process>processes)
	{
		Collections.sort(processes , new Comparator<Process>() {
			public int compare(Process p1 , Process p2) {
				return p1.getArrivalTime() - p2.getArrivalTime();
			}
		});
	}
	public void displayOrder()
	{
		double avgWaitingTime =0;
		double avgTurnAroundTime=0;
		for(int i=0;i<finishedProcess.size();i++)
		{
			System.out.print(finishedProcess.get(i)+" ");
		}
		System.out.println("\nProccessName    Waiting Time   Turanaroundtime");
		for(int i=0;i<finished.size();i++)
		{
			System.out.println(finished.get(i).getName()+" "+finished.get(i).waitingtime+" "+finished.get(i).turnaroundtime);
			avgWaitingTime += finished.get(i).waitingtime;
			avgTurnAroundTime += finished.get(i).turnaroundtime;	
		}
		System.out.println("Avreage Turn Around Time is : " + avgTurnAroundTime/finished.size());
		System.out.println("Avrafe Waiting Time is : " + avgWaitingTime/finished.size());
	}
	
}
