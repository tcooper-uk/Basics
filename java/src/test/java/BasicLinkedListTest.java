import com.tcooper.utils.BasicLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicLinkedListTest {

    @Test
    public void given_ICreateANewList_ThenSizeIsCorrect() {
        var list = new BasicLinkedList<Integer>();
        assertEquals(0, list.size());
    }

    @Test
    public void given_ICreateANewListWithSeed_ThenSizeIsCorrect() {
        var list = new BasicLinkedList<Integer>(2);
        assertEquals(1, list.size());
    }

    @Test
    public void given_ICreateANewPopulatedList_ThenSizeIsCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(2);

        assertEquals(2, list.size());
    }

    @Test
    public void given_IGetFirstItem_ThenItemAndSizeAreCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(2);

        int i = list.getFirst();

        assertEquals(1, i);
        assertEquals(2, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_IGetFirstItemInEmptyList_ThenThrows() {
        var list = new BasicLinkedList<Integer>();
        list.getFirst();
    }

    @Test
    public void given_IGetLastItem_ThenItemAndSizeAreCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(2);

        int i = list.getLast();

        assertEquals(2, i);
        assertEquals(2, list.size());
    }

    @Test
    public void given_IRemoveFirstItemFromList_ThenItemAndSizeAreCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(2);

        int i = list.removeFirst();

        assertEquals(1, i);
        assertEquals(1, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_IGetLastItemInEmptyList_ThenThrows() {
        var list = new BasicLinkedList<Integer>();
        list.getFirst();
    }

    @Test
    public void given_IRemoveFirstItemFromListOfOne_ThenItemAndSizeAreCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);

        int i = list.removeFirst();

        assertEquals(1, i);
        assertEquals(0, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_IRemoveFirstItemInEmptyList_ThenThrows() {
        var list = new BasicLinkedList<Integer>();
        list.removeFirst();
    }

    @Test
    public void given_IRemoveLastItemFromList_ThenItemAndSizeAreCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(2);

        int i = list.removeLast();

        assertEquals(2, i);
        assertEquals(1, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_IRemoveLastItemInEmptyList_ThenThrows() {
        var list = new BasicLinkedList<Integer>();
        list.removeLast();
    }

    @Test
    public void given_IRemoveLastItemFromListOfOne_ThenItemAndSizeAreCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);

        int i = list.removeLast();

        assertEquals(1, i);
        assertEquals(0, list.size());
    }

    @Test
    public void given_IInsertANewNodeAtStartOfEmptyList_ThenSizeIsCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.insert(1, 0);

        assertEquals(1, list.size());
    }

    @Test
    public void given_IInsertANewNodeAtStartOfList_ThenSizeAndValueAreCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(5);

        list.insert(1, 0);

        assertEquals(1, (int)list.getFirst());
        assertEquals(2, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_IInsertANewNodeAtEndOfList_ThenThrows() {
        var list = new BasicLinkedList<Integer>();
        list.add(5);

        // out of bounds
        list.insert(6, 1);
    }

    @Test
    public void given_IInsertANewNodeInMiddleOfList_ThenSizeAndOrderCorrect() {
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(3);

        list.insert(2, 1);

        assertEquals(3, list.size());
        assertEquals(1, (int)list.getFirst());
        assertEquals(3, (int)list.getLast());
    }

    @Test(expected = IllegalStateException.class)
    public void given_ITryToRemoveAtStartOfEmptyList_ThenThrows(){
        var list = new BasicLinkedList<Integer>();
        list.removeAt(0);
    }

    @Test(expected = IllegalStateException.class)
    public void given_ITryToRemoveAtPositionOutOfBounds_ThenThrows(){
        var list = new BasicLinkedList<Integer>();
        list.add(2);
        list.removeAt(1);
    }

    @Test
    public void given_ITryToRemoveAtStart_ThenSizeAndValueCorrect(){
        var list = new BasicLinkedList<Integer>();
        list.add(2);

        int item = list.removeAt(0);

        assertEquals(2, item);
        assertEquals(0, list.size());
    }

    @Test
    public void given_ITryToRemoveAtEnd_ThenSizeAndValueCorrect(){
        var list = new BasicLinkedList<Integer>();
        list.add(2);
        list.add(3);

        int item = list.removeAt(1);

        assertEquals(3, item);
        assertEquals(1, list.size());
    }

    @Test
    public void given_ITryToRemoveAtMiddle_ThenSizeAndValueCorrect(){
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        int item = list.removeAt(1);

        assertEquals(2, item);
        assertEquals(2, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_IHaveAnEmptyList_WhenICallGet_ThenThrows(){
        var list = new BasicLinkedList<Integer>();
        list.get(0);
    }

    @Test(expected = IllegalStateException.class)
    public void given_IHaveList_WhenICallGetWihtOutOfBounds_ThenThrows(){
        var list = new BasicLinkedList<Integer>();
        list.add(2);

        list.get(1);
    }

    @Test
    public void given_IHaveAListOfValues_WhenICallGet_ThenIGetTheCorrectIndex(){
        var list = new BasicLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        int item = list.get(1);

        assertEquals(2, item);
    }

    @Test(expected = IllegalStateException.class)
    public void given_IFindOnEmptyList_ThenThrows(){
        var list = new BasicLinkedList<Integer>();
        list.find(1);
    }

    @Test
    public void given_IFindOnListWithoutValue_ThenMinusOne(){
        var list = new BasicLinkedList<Integer>();
        list.add(4);
        list.add(5);

        assertEquals(-1, list.find(1));
    }

    @Test
    public void given_IFindOnListWithValue_ThenCorrectIndexReturned(){
        var list = new BasicLinkedList<Integer>();
        list.add(6);
        list.add(7);
        list.add(5);

        assertEquals(0, list.find(6));
        assertEquals(1, list.find(7));
        assertEquals(2, list.find(5));
    }
}
