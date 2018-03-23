
import java.util.ArrayList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class cpu {

	public static void main(String[] args) {
		ArrayList<Process> pros = new ArrayList<Process>();
		SJF shortJobFirst = new SJF();
		RoundRobin robin = new RoundRobin();
		Priority priority = new Priority();
		
		int numberOfProcess, Quantum , choice = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please Choose one of the Following: \n1-SJF \n2-Round Robin \n3-Priority \n4-AG \n5- (-1) to exit");
		
		
		while(choice != -1)
		{
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Number of Process: ");
				numberOfProcess = scan.nextInt();
				System.out.println("Enter the Name, Arrival time and Busrt time for each Process :");
				for(int i = 0; i <numberOfProcess ; i++)
				{
					Process process = new Process();
					process.setName(scan.next());
					process.setArrivalTime(scan.nextInt());
					process.setBurstTime(scan.nextInt());
					pros.add(process);
				}
				shortJobFirst.setProcesses(pros);
				shortJobFirst.sjf(pros);
				shortJobFirst.displayOrder();
				break;
			
			case 2:
				System.out.println("Enter the Number of Process: ");
				numberOfProcess = scan.nextInt();
				System.out.println("Enter the Name, Arrival time and Busrt time for each Process :");
				for(int i = 0; i <numberOfProcess ; i++)
				{
					Process process = new Process();
					process.setName(scan.next());
					process.setArrivalTime(scan.nextInt());
					process.setBurstTime(scan.nextInt());
					pros.add(process);
				}
				System.out.println( "Enter the Qqantum time: ");
		    	Quantum=scan.nextInt();
		    	robin.setProcesses(pros);
				robin.roundRobin(pros, Quantum);
				robin.displayOrder();
				break;
			case 3:
				System.out.println("Enter the Number of Process: ");
				numberOfProcess = scan.nextInt();
				System.out.println("Enter the Name, Arrival time ,Busrt time and Priority for each Process :");
				
				for(int i = 0; i <numberOfProcess ; i++)
				{
					Process process = new Process();
					process.setName(scan.next());
					process.setArrivalTime(scan.nextInt());
					process.setBurstTime(scan.nextInt());
					process.setPriority(scan.nextInt());
					pros.add(process);
				}
				priority.setProcesses(pros);
				priority.priority(pros);
				priority.displayOrder();
			case 4:
				PriorityQueue<Process> pos = new PriorityQueue<>(new Arrival());
				System.out.println("Enter the Number of Process: ");
				numberOfProcess = scan.nextInt();
				System.out.println("Enter the Name, Arrival time ,Busrt time and Quantm for each Process :");
				
				for(int i = 0; i <numberOfProcess ; i++)
				{
					Process process = new Process();
					process.setName(scan.next());
					process.setArrivalTime(scan.nextInt());
					process.setBurstTime(scan.nextInt());
					process.setQuantm(scan.nextInt());
					pos.add(process);
				}
				AG ag = new AG(pos);
				ag.AGScheduling();
				ag.displayOrder();
			default:
				System.out.println("Enter a vaild number or (-1) to exit");
				break;
			}
		}
	}

}
class Arrival implements Comparator<Process>
{
    public int compare(Process p1, Process p2)
    {
        if (p1.getArrivalTime() < p2.getArrivalTime())
            return -1;
        else
            return 1;
    }
}
		
