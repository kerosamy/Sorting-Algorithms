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
            int size = rand.nextInt(96) + 5;
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                arr.add(rand.nextInt(2001) - 1000);
            }

            ArrayList<Integer> expected = new ArrayList<>(arr);
            Collections.sort(expected);

            ArrayList<Integer> resultNLogN = sortNLogN.sort(new ArrayList<>(arr), false);
            ArrayList<Integer> resultN2 = sortN2.sort(new ArrayList<>(arr), false);
            ArrayList<Integer> resultN = sortN.sort(new ArrayList<>(arr), false);

            assertEquals(expected, resultNLogN, "O(N log N) sort failed on test " + (i + 1));
            assertEquals(expected, resultN2, "O(N²) sort failed on test " + (i + 1));
            assertEquals(expected, resultN, "O(N) sort failed on test " + (i + 1));
        }
    }
}
