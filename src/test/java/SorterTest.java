import org.junit.jupiter.api.Test;
import sort.ON2Sort;
import sort.ONSort;
import sort.ONlogNSort;
import sort.SortingStrategy;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SorterTest {

    @Test
    public void testSortingCorrectness() {

        SortingStrategy sortNLogN = new ONlogNSort();
        SortingStrategy sortN2 = new ON2Sort();
        SortingStrategy sortN = new ONSort();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int size = rand.nextInt(1000) + 5;
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                arr.add(rand.nextInt(2001) - 1000);
            }

            ArrayList<Integer> expected = new ArrayList<>(arr);
            Collections.sort(expected);

            long startNLogN = System.nanoTime();
            ArrayList<Integer> resultNLogN = sortNLogN.sort(new ArrayList<>(arr), false);
            long endNLogN = System.nanoTime();
            long timeNLogN = endNLogN - startNLogN;

            long startN2 = System.nanoTime();
            ArrayList<Integer> resultN2 = sortN2.sort(new ArrayList<>(arr), false);
            long endN2 = System.nanoTime();
            long timeN2 = endN2 - startN2;

            long startN = System.nanoTime();
            ArrayList<Integer> resultN = sortN.sort(new ArrayList<>(arr), false);
            long endN = System.nanoTime();
            long timeN = endN - startN;

            assertEquals(expected, resultNLogN, "O(N log N) sort failed on test " + (i + 1));
            assertEquals(expected, resultN2, "O(N²) sort failed on test " + (i + 1));
            assertEquals(expected, resultN, "O(N) sort failed on test " + (i + 1));

            System.out.println("Test " + (i + 1) + " (Size: " + size + ")");
            System.out.println("O(N²) Sort Time: " + timeN2 / 1_000_000.0 + " ms");
            System.out.println("O(N log N) Sort Time: " + timeNLogN / 1_000_000.0 + " ms");
            System.out.println("O(N) Sort Time: " + timeN / 1_000_000.0 + " ms");
            System.out.println("-------------------------------");

        }
    }
}
