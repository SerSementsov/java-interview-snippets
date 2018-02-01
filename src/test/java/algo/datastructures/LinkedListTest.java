package algo.datastructures;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class LinkedListTest {

    private SinglyLinkedList<Integer> linkedList;

    @Before
    public void init() {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testAddedElementsAreTraversedInSameOrder() {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = linkedList.traverse();

        assertThat(actual, is(expected));

        List<Integer> unexpected = Arrays.asList(3, 2, 1);
        assertThat(actual, not(unexpected));
    }

    @Test
    public void testReverseLinkedList() {
        linkedList.add(50);
        linkedList.add(100);
        linkedList.add(200);

        List<Integer> reversed = Arrays.asList(200, 100, 50);
        linkedList.reverse();
        List<Integer> actual = linkedList.traverse();

        assertThat(actual, is(reversed));
    }


}





















