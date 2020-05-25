import com.tcooper.utils.BasicBinaryTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class BasicBinaryTreeTest {

    @Test
    public void given_ICheckSizeOfEmptyTree_ThenSizeCorrect() {
        var tree = new BasicBinaryTree<Integer>();
        assertEquals(0, tree.size());
    }

    @Test
    public void given_IInsertIntoTree_ThenSizeIsCorrect() {
        var tree = new BasicBinaryTree<Integer>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);

        assertEquals(5, tree.size());
    }

    @Test
    public void given_IInsertDuplicateRootValueIntoTree_ThenNothingIsAdded() {
        var tree = new BasicBinaryTree<Integer>();
        tree.add(5);
        tree.add(5);

        assertEquals(1, tree.size());
    }

    @Test
    public void given_IInsertDuplicateValueIntoTree_ThenNothingIsAdded() {
        var tree = new BasicBinaryTree<Integer>();
        tree.add(5);
        tree.add(10);
        tree.add(4);
        tree.add(4);

        assertEquals(3, tree.size());
    }


    @Test
    public void given_IInsertIntoTree_WhenICallContainsOnExistingValue_ThenTrue() {
        var tree = new BasicBinaryTree<Integer>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);

        assertTrue(tree.contains(3));
    }

    @Test
    public void given_IInsertIntoTree_WhenICallContainsOnNonExistingValue_ThenFalse() {
        var tree = new BasicBinaryTree<Integer>();
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);

        assertFalse(tree.contains(9));
    }

    @Test
    public void given_IHaveAPopulatedTree_WhenIRemoveAValue_ThenTheTreeIsValid() {
        var tree = new BasicBinaryTree<Integer>();
        var values = getValues();

        for (int i : values) {
            tree.add(i);
        }

        Random r = new Random();
        int remove = values[r.nextInt(values.length - 1)];

        tree.remove(remove);

        for (int i : Arrays.stream(values).filter(v -> v != remove).toArray()) {
            assertTrue(tree.contains(i));
        }

        assertFalse(tree.contains(remove));
    }

    private int[] getValues() {
        return new int[] {
                5,
                3,
                20,
                2,
                4,
                10,
                25,
                6,
                15,
                22,
                30
        };
    }

}
