import java.util.ArrayList;

public class Manger {

	ArrayList<Partation> partations;
	Partation partation;

	public Manger() {
		partations = new ArrayList<Partation>();
	}

	public Manger(int partationSize) {
		partations = new ArrayList<Partation>();
		partation = new Partation();
		partation.setPartationSize(partationSize);
		partation.setState(false);
		partation.setAddress(0);
		partations.add(partation);
	}

	public void bestFit(int memorySize) {
		int index = -1;
		int bestMemoryFound = 1000000;

		for (int i = 0; i < partations.size(); i++) {
			Partation currentPartation = partations.get(i);
			if (!currentPartation.isState())
				if (currentPartation.getPartationSize() - memorySize <= bestMemoryFound && currentPartation.getPartationSize() >= memorySize) {
					// System.out.println(currentPartation.getPartationSize());
					bestMemoryFound = currentPartation.getPartationSize() - memorySize;
					index = i;
					// ]System.out.println(bestMemoryFound + " ------>> " + index);
				}
		}
		if (index == -1) {
			System.out.println("Can't be add to the memory");
		} else {
			// System.out.println(partations.get(index).isState());
			if (partations.get(index).isOrginal() && partations.get(index).getPartationSize() > memorySize) {
				Partation partation = new Partation();
				// System.out.println(partations.get(index).getPartationSize() - memorySize);
				partation.setPartationSize(partations.get(index).getPartationSize() - memorySize);
				partation.setAllocatedSize(partations.get(index).getPartationSize() - memorySize);
				partation.setAddress(partations.size());
				
				partations.add(partation);
				
				partations.get(index).setAllocatedSize(memorySize);
				partations.get(index).setPartationSize(memorySize);
				partations.get(index).setOrginal(false);
				partations.get(index).setState(true);
			} else {
				partations.get(index).setAllocatedSize(memorySize);
				partations.get(index).setOrginal(false);
				partations.get(index).setState(true);
			}
		}
		// printPartaion();
	}

	public void worstFit(int memorySize) {
		int index = -1;
		int bestMemoryFound = -1;

		for (int i = 0; i < partations.size(); i++) {
			Partation currentPartation = partations.get(i);
			if (!currentPartation.isState())
				if (currentPartation.getPartationSize() - memorySize >= bestMemoryFound && currentPartation.getPartationSize() >= memorySize) {
					// System.out.println(currentPartation.getPartationSize());
					bestMemoryFound = currentPartation.getPartationSize() - memorySize;
					index = i;
					// System.out.println(bestMemoryFound + " ------>> " + index);
				}
		}
		if (index == -1) {
			System.out.println("Can't be add to the memory");
		} else {
			// System.out.println(partations.get(index).isState());
			if (partations.get(index).isOrginal() && partations.get(index).getPartationSize() > memorySize) {
				Partation partation = new Partation();
				// System.out.println(partations.get(index).getPartationSize() - memorysize);
				partation.setPartationSize(partations.get(index).getPartationSize() - memorySize);
				partation.setAddress(partations.size());
				partation.setAllocatedSize(partations.get(index).getPartationSize() - memorySize);
				
				partations.add(partation);

				partations.get(index).setAllocatedSize(memorySize);
				partations.get(index).setPartationSize(memorySize);
				partations.get(index).setOrginal(false);
				partations.get(index).setState(true);
			} else {
				partations.get(index).setAllocatedSize(memorySize);
				partations.get(index).setOrginal(false);
				partations.get(index).setState(true);
			}
		}

		// printPartaion();
	}

	public void firstFit(int memorySize) {
		int index = -1;
		for (int i = 0; i < partations.size(); i++) {
			Partation currentPartation = partations.get(i);
			if (!currentPartation.isState())
				if (currentPartation.getPartationSize() >= memorySize && currentPartation.getPartationSize() >= memorySize) {
					index = i;
					break;
				}
		}
		if (index == -1) {
			System.out.println("Can't be add to the memory");
		} else {
			if (partations.get(index).isOrginal() && partations.get(index).getPartationSize() > memorySize) {
				Partation partation = new Partation();
				// System.out.println(partations.get(index).getPartationSize() - memorySize);
				partation.setPartationSize(partations.get(index).getPartationSize() - memorySize);
				partation.setAddress(partations.size());
				partation.setAllocatedSize(partations.get(index).getPartationSize() - memorySize);
				
				partations.add(partation);
				
				partations.get(index).setAllocatedSize(memorySize);
				partations.get(index).setPartationSize(memorySize);
				partations.get(index).setOrginal(false);
				partations.get(index).setState(true);
			} else {
				partations.get(index).setAllocatedSize(memorySize);
				partations.get(index).setOrginal(false);
				partations.get(index).setState(true);
			}
		}
		// printPartaion();

	}

	public void deAllocation(int address) {
		if (address > partations.size()) {
			System.out.println("Not Vaild input");
		}
		for (int i = 0; i < partations.size(); i++) {
			if (partations.get(i).getAddress() == address) {
				partations.get(i).setState(false);
				partations.get(i).setAllocatedSize(0);
			}
		}
	}
	public void defragmentationCase1()
	{
		for(int i = 0; i<partations.size(); i++)
		{
			if(partations.get(i).isState() && partations.get(i).getAllocatedSize() < partations.get(i).getPartationSize())
			{
				Partation partation = new Partation();
				partation.setPartationSize(( partations.get(i).getPartationSize() - partations.get(i).getAllocatedSize()));
				partation.setAllocatedSize(0);
				partations.get(i).setPartationSize(partations.get(i).getAllocatedSize());
				partations.add(partation);
			}
		}
		setindexes();
	}
	public void defragmentationCase2()
	{
		for(int i = 1; i<partations.size() ; i++)
		{
			//System.out.println(i);
			if(partations.get(i).getAllocatedSize() == 0 && partations.get(i-1).getAllocatedSize() == 0)
			{
				partations.get(i-1).setPartationSize(partations.get(i).getPartationSize() + partations.get(i-1).getPartationSize());
				partations.remove(i);
				if(i>=1)
					i--;
			}
		}
		setindexes();
	}
	public void defragmentationCase3()
	{
		int totalSize=0;
		for(int i = 0; i<partations.size(); i++)
		{
			if(partations.get(i).getAllocatedSize()== 0)
			{
				totalSize+= partations.get(i).getPartationSize();
				partations.remove(i);
				i--;	
			}
		}
		partation=new Partation();
		partation.setPartationSize(totalSize);
		partations.add(partation);
		setindexes();
	}
	private void setindexes()
	{
		for(int i = 0; i<partations.size(); i++)
		{
			partations.get(i).setAddress(i);
		}
	}
	public void printPartaion() {
		// System.out.println("5555");
		for (int i = 0; i < partations.size(); i++) {
			System.out.println(partations.get(i).getAddress() + "----->" + partations.get(i).getAllocatedSize() + "---->" + partations.get(i).getPartationSize());
		}
	}
}
