import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sorter {
    private ArrayList<Integer> arr;
    private SortingStrategy strategy;

    public Sorter(String filePath) {
        arr = new ArrayList<>();
        read_file(filePath);
    }

    private void read_file(String filepath) {
        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] numbers = data.split(",");
                for (String num : numbers) {
                    arr.add(Integer.parseInt(num.trim()));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(printArray.RED+"File not found: " + filepath+printArray.RESET);
            e.printStackTrace();
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println(printArray.RED+"Error parsing numbers from file."+printArray.RESET);
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void setSortingStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(boolean steps) {
        long startTime = System.nanoTime();
        strategy.sort(arr, steps);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(printArray.YELLOW+"Sorting completed in " + printArray.CYAN+(duration / 1_000_000.0)+printArray.RESET +printArray.YELLOW+ " milliseconds"+printArray.RESET);
    }
}
