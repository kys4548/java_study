import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    @DisplayName("add메서드에서 position이 0이면 addToNode가 head가 된다.")
    void addTest01() {
        //given
        ListNode head = new ListNode(0);
        ListNode addToNode = new ListNode(5);
        int position = 0;

        //when
        ListNode result = LinkedList.add(head, addToNode, position);

        //then
        assertEquals(addToNode, result);
    }

    @Test
    @DisplayName("add메서드에서 list의 길이보다 position이 크면 예외가 발생한다")
    void addTest02() {
        //given
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(43242);
        ListNode node2 = new ListNode(56464);

        LinkedList.add(head, node1, 1);

        //when then
        assertThrows(RuntimeException.class, () -> LinkedList.add(head, node2, 3));
    }

    @Test
    @DisplayName("add메서드에서 list의 길이보다 position값이 작거나 같을 때 addToNode는 position번째 인덱스에 들어간다.")
    void addTest03() {
        //given
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(43242);
        ListNode node2 = new ListNode(56464);

        int position = 1;

        //when
        LinkedList.add(head, node1, 1);
        LinkedList.add(head, node2, position);

        ListNode result = head;
        while (position > 0) {
            result = result.nextNode;
            position--;
        }

        //then
        assertEquals(node2, result);
    }
}