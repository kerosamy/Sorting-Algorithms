import sort.*;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String filepath;
        while (true) {
            System.out.println(printArray.GREEN+"Enter file path: "+printArray.RESET);
            filepath = sc.nextLine();
            File file = new File(filepath);
            if (file.exists()) {
                break;
            } else {
                System.out.println("File not found. Enter a valid file path:");
            }
        }

        while (true) {
            Sorter sort = new Sorter(filepath);
            System.out.println("\nChoose Sorting Algorithm:");
            System.out.println(printArray.PURPLE+"1.O(N²) Sort (Bubble Sort)"+printArray.RESET);
            System.out.println(printArray.BLUE+"2.O(NlogN) Sort (Quick Sort)"+printArray.RESET);
            System.out.println(printArray.GREEN+"3.O(N) Sort (Radix Sort)"+printArray.RESET);
            System.out.println(printArray.RED+"4.Exit"+printArray.RESET);
            System.out.print("Enter choice: ");
            int choice ;
            while (true) {
                 choice = sc.nextInt();
                 if(choice > 0&&choice <= 4) {break;}
                System.out.println(printArray.RED+"Invalid choice, try again."+printArray.RESET);
            }
            if (choice == 4) break;
            System.out.print("Show intermediate steps? (true/false) Or (1/0) : ");
            boolean steps;
            String stepsString;
            while (true) {
                stepsString = sc.next();
                if (stepsString.toLowerCase().equals("true")||stepsString.toLowerCase().equals("1")) {
                    steps = true;
                    break;
                }
                else if(stepsString.toLowerCase().equals("false")||stepsString.toLowerCase().equals("0")) {
                    steps = false;
                    break;
                }
                else {
                    System.out.println(printArray.RED+"Invalid choice, try again."+printArray.RESET);
                }
            }
            switch (choice) {
                case 1:
                    sort.setSortingStrategy(new ON2Sort());
                    break;
                case 2:
                    sort.setSortingStrategy(new ONlogNSort());
                    break;
                case 3:
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
