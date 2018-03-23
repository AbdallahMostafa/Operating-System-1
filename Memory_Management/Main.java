import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the total memory size: ");
		Scanner scanner = new Scanner(System.in);
		int totalMemorySzie = scanner.nextInt();
		Manger manger = new Manger(totalMemorySzie);
		System.out.println("Choose one of the following options" + "\n" + "1-Memory Input" + "\n" + "2-Deallocation"
				+ "\n" + "3-Defragmentation" + "\n");
		int key = scanner.nextInt();
		while (key != -1) {
			System.out.println("Choose one of the following options " + "\n" + "1-Best-Fit." + "\n" + "2-Worst-Fit."
					+ "\n" + "3-First-Fit." + "\n" + "4-When you want to print any method just enter (0) " + "\n"
					+ "5-Enter (-1) to exit");
			int choice = scanner.nextInt();
			while (choice == 1) {
				System.out.println("Enter the memory of the partation: ");
				int memorySize = scanner.nextInt();
				manger.bestFit(memorySize);
				if (memorySize == 0)
					manger.printPartaion();
				System.out.println("Do you want to try another method? (Y\\N)");
				String c = scanner.next();
				if (c.equals("Y") || c.equals("y"))
					break;
				else
					continue;

			}

			while (choice == 2) {
				System.out.println("Enter the memory of the partation: ");
				int memorySize = scanner.nextInt();
				manger.worstFit(memorySize);
				if (memorySize == 0)
					manger.printPartaion();
				System.out.println("Do you want to try another method? (Y\\N)");
				String c = scanner.next();
				if (c.equals("Y") || c.equals("y"))
					break;
				else
					continue;

			}

			while (choice == 3) {
				System.out.println("Enter the memory of the partation: ");
				int memorySize = scanner.nextInt();
				manger.firstFit(memorySize);
				if (memorySize == 0)
					manger.printPartaion();
				System.out.println("Do you want to try another method? (Y\\N)");
				String c = scanner.next();
				if (c.equals("Y") || c.equals("y"))
					break;
				else
					continue;
			}
			if (choice == -1)
				break;
		}
		while (key != -2) {
			System.out.println(
					"Enter the Address of the Partation you want to de-allocate: " + "\n" + "Or enter (-2) to exit");
			int choice = scanner.nextInt();
			manger.deAllocation(choice);
			if (choice == 0)
				manger.printPartaion();
			if (choice == -2)
				break;
		}
		while (key != -3) {
			System.out.println("Choose one of the following defragmentation" + "\n" + "1-Case 1" + "\n" + "2-Case 2"
					+ "\n" + "3-Case 3" + "\n" + "4- (-3) to exit");
			int choice = scanner.nextInt();

			while (choice == 1) {
				manger.defragmentationCase1();
				if (choice == 0)
					manger.printPartaion();
				System.out.println("Do you want to try another method? (Y\\N)");
				String c = scanner.next();
				if (c.equals("Y") || c.equals("y"))
					break;
				else
					continue;

			}

			while (choice == 2) {
				manger.defragmentationCase2();
				if (choice == 0)
					manger.printPartaion();
				System.out.println("Do you want to try another method? (Y\\N)");
				String c = scanner.next();
				if (c.equals("Y") || c.equals("y"))
					break;
				else
					continue;
			}

			while (choice == 3) {
				manger.defragmentationCase3();
				if (choice == 0)
					manger.printPartaion();
				System.out.println("Do you want to try another method? (Y\\N)");
				String c = scanner.next();
				if (c.equals("Y") || c.equals("y"))
					break;
				else
					continue;
			}
			if (choice == -1)
				break;
		}

	}
}
