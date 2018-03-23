
public class Partation {
	private int partationSize , allocatedSize , address;
	private boolean state , orginal;
	public Partation()
	{
		partationSize = 0;
		address = 0;
		allocatedSize = 0;
		address = 0;
		orginal=true;
		state=false;
	}
	public int getPartationSize() {
		return partationSize;
	}
	public void setPartationSize(int partationSize) {
		this.partationSize = partationSize;
	}
	public int getAllocatedSize() {
		return allocatedSize;
	}
	public void setAllocatedSize(int allocatedSize) {
		this.allocatedSize = allocatedSize;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public boolean isOrginal() {
		return orginal;
	}
	public void setOrginal(boolean orginal) {
		this.orginal = orginal;
	}
}
