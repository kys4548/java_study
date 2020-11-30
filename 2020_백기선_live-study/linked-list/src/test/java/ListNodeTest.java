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

        head.nextNode = node1;

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

        head.nextNode = node1;
        int position = 1;

        //when
        LinkedList.add(head, node2, position);

        ListNode result = head;
        while (position > 0) {
            result = result.nextNode;
            position--;
        }

        //then
        assertEquals(node2, result);
    }

    @Test
    @DisplayName("remove메서드에서 list의 길이보다 position이 크거나 같으면 예외가 발생한다.")
    void removeTest01() {
        //given
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(43242);
        ListNode node2 = new ListNode(56464);
        head.nextNode = node1;
        node1.nextNode = node2;

        //when then
        assertThrows(RuntimeException.class, () -> LinkedList.remove(head, 3));
    }

    @Test
    @DisplayName("remove메서드에서 position값의 ListNode index가 제거된다.")
    void removeTest02() {
        //given
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(43242);
        ListNode node2 = new ListNode(56464);
        head.nextNode = node1;
        node1.nextNode = node2;

        int position = 1;

        //when
        ListNode result = LinkedList.remove(head, position);

        //then
        assertEquals(node1, result);
    }

    @Test
    @DisplayName("contains메서드에서 LinkedList가 임의의 ListNode를 포함하고 있다면 true 반환")
    void containsTest01() {
        //given
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(43242);
        ListNode node2 = new ListNode(56464);
        head.nextNode = node1;
        node1.nextNode = node2;

        //when
        boolean result = LinkedList.contains(head, node2);

        //then
        assertTrue(result);

    }

    @Test
    @DisplayName("contains메서드에서 LinkedList가 임의의 ListNode를 포함하지 않는다면 false 반환")
    void containsTest02() {
        //given
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(43242);
        ListNode node2 = new ListNode(56464);
        head.nextNode = node1;
        node1.nextNode = node2;

        ListNode node3 = new ListNode(25534);

        //when
        boolean result = LinkedList.contains(head, node3);

        //then
        assertFalse(result);

    }
}