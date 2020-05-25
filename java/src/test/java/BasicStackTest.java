import com.tcooper.utils.BasicStack;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicStackTest {

    class Card{
        int number;

        Card(int number){
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    @Test
    public void given_ICreateStackWithSeed_ThenSizeIsCorrect() {
        var stack = new BasicStack<Integer>(4);

        assertEquals(1, stack.size());
    }

    @Test
    public void given_ICreateANewStack_ThenICanAddItems() {
        var stack = createStack();

        assertEquals(3, stack.size());
    }

    @Test
    public void given_ICreateANewStack_ThenICanRemoveItems() {
        var stack = createStack();
        int item = stack.pop();

        assertEquals(3, item);
        assertEquals(2, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void given_IHaveAnEmptyStack_WhenITryPop_ThenThrows() {
        var stack = new BasicStack<Integer>();
        stack.pop();
    }

    @Test
    public void given_StackContainsItem_ThenContainsTrue() {
        var stack = createStack();
        assertTrue(stack.contains(1));
    }

    @Test
    public void given_StackDoesNotContainItem_ThenContainsFalse() {
        var stack = createStack();
        assertFalse(stack.contains(12));
    }

    @Test
    public void given_IHaveAnItemInTheStack_ThenICanAccessThatItem(){
        var theCard = new Card(2);

        var stack = new BasicStack<Card>();
        stack.push(theCard);

        assertSame(theCard, stack.access(theCard));
    }

    @Test(expected = IllegalStateException.class)
    public void given_IDoNotHaveAnItemInTheStack_ThenICannotAccessThatItem(){
        var stack = createStack();
        stack.access(12);
    }

    private BasicStack<Integer> createStack() {
        var stack = new BasicStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        return stack;
    }

}
