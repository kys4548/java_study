import java.util.Objects;

public class LinkedList {
    public static ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if(position == 0) {
            nodeToAdd.nextNode = head;
            return nodeToAdd;
        }

        ListNode preNode = head;
        while(position > 1) {
            if(preNode == null) {
                throw new RuntimeException();
            }
            preNode = preNode.nextNode;
            position--;
        }
        nodeToAdd.nextNode = preNode.nextNode;
        preNode.nextNode = nodeToAdd;
        return head;
    }
}

class ListNode {
    //편의상 public으로 구현
    public int num;
    public ListNode nextNode;

    public ListNode(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return num == listNode.num &&
                Objects.equals(nextNode, listNode.nextNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, nextNode);
    }
}
