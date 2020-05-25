import com.tcooper.utils.BasicHashTable;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicHashTableTest {

    @Test
    public void given_ICreateAnEmptyHashTable_SizeCorrect() {
        var ht = new BasicHashTable<Integer, String>(1000);

        assertEquals(0, ht.size());
    }

    @Test
    public void given_ICreateANewHashTable_ICanAddItemsAndSizeCorrect() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.put(1, "Test");
        ht.put(2, "Test");

        assertEquals(2, ht.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_ICreateAnEmptyHashTable_ICanGetAnItem() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.get(1);
    }


    @Test
    public void given_ICreateANewHashTable_ICanGetAnItem() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.put(1, "Test");
        ht.put(2, "Test Two");

        assertEquals("Test Two", ht.get(2));
    }

    @Test
    public void given_ICreateANewHashTable_WhenICheckForAExistingKey_ThenKeyFound() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.put(1, "Test");

        assertTrue(ht.containsKey(1));
    }

    @Test
    public void given_ICreateANewHashTable_WhenICheckForANonExistingKey_ThenKeyNotFound() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.put(1, "Test");

        assertFalse(ht.containsKey(3));
    }

    @Test
    public void given_ICreateAEmptyHashTable_WhenICheckForANonExistingKey_ThenKeyNotFound() {
        var ht = new BasicHashTable<Integer, String>(1000);
        assertFalse(ht.containsKey(3));
    }

    @Test
    public void given_ICreateANewHashTableWithValues_WhenIDeleteAValue_ThenValueRemoved() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.put(1, "Test");
        ht.put(2, "Test Two");

        ht.delete(2);

        assertFalse(ht.containsKey(2));
        assertTrue(ht.containsKey(1));
        assertEquals(1, ht.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_ICreateAnEmptyHashTable_WhenIDeleteNonExistentValue_ThenThrows() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.delete(1);
    }

    @Test
    public void given_ICreateAEmptyHashTable_WhenICheckForAValue_ThenKeyNotFound() {
        var ht = new BasicHashTable<Integer, String>(1000);
        assertFalse(ht.containsValue("test"));
    }

    @Test
    public void given_ICreateAHashTable_WhenICheckForANonExistentValue_ThenKeyNotFound() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.put(1, "Test");
        ht.put(1, "Test 1");
        ht.put(1, "Test 2");

        assertFalse(ht.containsValue("tester"));
    }

    @Test
    public void given_ICreateAHashTable_WhenICheckForAnExistingValue_ThenValueFound() {
        var ht = new BasicHashTable<Integer, String>(1000);
        ht.put(1, "Test");
        ht.put(1, "tester");

        assertTrue(ht.containsValue("tester"));
    }

}
