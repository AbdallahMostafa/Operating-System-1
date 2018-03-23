
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Priority {
	
	ArrayList<Process> process;
	ArrayList<Process> watingQueue = new ArrayList<Process>();
	ArrayList<Process> finished = new ArrayList<Process>();
	ArrayList<String> finishdProcess = new ArrayList<String>();
	
	public Priority() {
		process = new ArrayList<Process>();
	}
	public ArrayList<Process> getProcesses() {
		return process;
	}
	public void setProcesses(ArrayList<Process> process) {
		this.process = process;
	}
	
	public void priority(ArrayList<Process> processes)
	{
		sortProcess(processes);
		Process process = null;
		int time = -1 ;
		while(true)
		{
			time++;
			while(!processes.isEmpty() && time == processes.get(0).getArrivalTime())
			{
				if(process==null)
				{
					process=processes.get(0);
					processes.remove(0);
				}
				else
				{
					watingQueue.add(processes.get(0));
					processes.remove(0);
					sortPriority(watingQueue);
				}
			}
			if((process.getBurstTime()<=0) && (processes.isEmpty()) &&( watingQueue.isEmpty()))
			{
				process.turnaroundtime=time-process.getArrivalTime();
				finished.add(process);
				break;
			}
			if(process.getBurstTime()<=0)
			{
				process.turnaroundtime=time-process.getArrivalTime();
				finished.add(process);
				if(!watingQueue.isEmpty())
				{
					process = watingQueue.get(0);
					watingQueue.remove(0);
				}
			}
			if(!watingQueue.isEmpty() && process.getPriority() > watingQueue.get(0).getPriority())
			{
				process.turnaroundtime=time-process.getArrivalTime();
				watingQueue.add(process);
				process = watingQueue.get(0);
				watingQueue.remove(0);
				sortPriority(watingQueue);
			}
			process.decBurstTime();
			for(int i=0;i<watingQueue.size();i++)
			{
				watingQueue.get(i).waitingtime++;
			}
			if(finishdProcess.size()>0)
			{
				if(!finishdProcess.get(finishdProcess.size()-1).equals(process.getName()))
					finishdProcess.add(process.getName());
			}
			else
				finishdProcess.add(process.getName());
		}
	}
	
	private void sortPriority(ArrayList<Process> processes)
	{
		Collections.sort(processes , new Comparator<Process>() {
			public int compare(Process p1 , Process p2) {
				return p1.getPriority() - p2.getPriority();
			}
		});
	}
	private void sortProcess(ArrayList<Process> processes)
	{
		Collections.sort(processes , new Comparator<Process>() {
			public int compare(Process p1 , Process p2) {
				return p1.getArrivalTime() - p2.getArrivalTime();
			}
		});
	}
	
	public void displayOrder()
	{
		int avgWaitingTime =0;
		int avgTurnAroundTime=0;
		for(int i=0;i<finishdProcess.size();i++)
		{
			System.out.print(finishdProcess.get(i)+" ");
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

