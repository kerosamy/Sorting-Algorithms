import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String filepath;
        while (true) {
            System.out.println("Enter file path: ");
            filepath = sc.nextLine();
            File file = new File(filepath);        
            if (file.exists()) {
                break;  
            } else {
                System.out.println("File not found. Enter a valid file path:");
            }
        }
        Sorter sort = new Sorter(filepath);
        while (true) {
            System.out.println("\nChoose Sorting Algorithm:");
            System.out.println("1.O(N²) Sort (Bubble Sort)");
            System.out.println("2.O(NlogN) Sort (Quick Sort)");
            System.out.println("3.O(N) Sort (Radix Sort)");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 4) break;
            boolean steps;
            switch (choice) {
                case 1:
                    System.out.print("Show intermediate steps? (true/false): ");
                    steps = sc.nextBoolean();
                    sort.setSortingStrategy(new ON2Sort());
                    break;
                case 2:
                    System.out.print("Show intermediate steps? (true/false): ");
                    steps = sc.nextBoolean();
                    sort.setSortingStrategy(new ONlogNSort());
                    break;
                case 3:
                    System.out.print("Show intermediate steps? (true/false): ");
                    steps = sc.nextBoolean();
                    sort.setSortingStrategy(new ONSort());
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
                    continue;
            }
            sort.sort(steps);      
        }
        sc.close();
    }
    
}
