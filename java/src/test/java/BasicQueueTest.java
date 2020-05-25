import com.tcooper.utils.BasicQueue;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicQueueTest {

    @Test
    public void given_IHaveAnEmptyQueue_Then_ICanAddItems(){
        var queue = getBasicQueue();
        assertEquals(3, queue.size());
    }

    @Test
    public void given_IHaveAnEmptyQueue_ThenSizeIs0(){
        var queue = new BasicQueue<Integer>();
        assertEquals(0, queue.size());
    }

    @Test
    public void given_IHaveRemovedItemFromQueue_ThenSizeIsCorrect(){
        var queue = getBasicQueue();
        var item = queue.deQueue();

        assertEquals(100, item);
        assertEquals(2, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_ITryToDequeueEmptyQueue_ThenThrows(){
        var queue = new BasicQueue<Integer>();
        queue.deQueue();
    }

    @Test
    public void given_MyQueueContainsItem_Then_ContainsReturnsTrue() {
        var queue = getBasicQueue();
        assertTrue(queue.contains(101));
    }

    @Test
    public void given_MyQueueDoesNotContainItem_Then_ContainsReturnsFalse() {
        var queue = getBasicQueue();
        assertFalse(queue.contains(45));
    }

    @Test(expected = IllegalStateException.class)
    public void given_MyQueueIsEmpty_Then_AccessThrows() {
        var queue = new BasicQueue<Integer>();
        queue.access(1);
    }

    @Test(expected = IllegalStateException.class)
    public void given_AccessLargerThatQueueSize_Then_AccessThrows() {
        var queue = getBasicQueue();
        queue.access(4);
    }

    @Test
    public void given_IAccessAnItemInQueueWithIndex_ThenItemReturned() {
        var queue = getBasicQueue();
        var item = queue.access(2);

        assertEquals(item, 102);
    }


    @Test
    public void given_ICreateASmallQueue_WhenIFillAndEmptyQueue_ThenLimitIsRespected(){
        var queue = new BasicQueue<Integer>(10);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        assertEquals(5, queue.size());

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        assertEquals(1, queue.size());

        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        assertEquals(5, queue.size());

        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.enQueue(9);
        queue.enQueue(10);

    }

    private BasicQueue getBasicQueue() {
        var q = new BasicQueue<Integer>();

        q.enQueue(100);
        q.enQueue(101);
        q.enQueue(102);
        return q;
    }
}
