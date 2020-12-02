public class ListNodeStack implements Stack<ListNode> {
    //편의상 public 구현
    public ListNode head;
    public int size = 0;

    @Override
    public void push(ListNode data) {
        if (head == null) {
            head = data;
            return;
        }
        ListNode preNode = head;
        while (head.nextNode != null) {
            preNode = preNode.nextNode;
        }
        preNode.nextNode = data;
    }

    @Override
    public int pop() {
        if (head == null) {
            throw new RuntimeException();
        }
        ListNode preNode = head;
        ListNode removeNode = head;

        while (removeNode.nextNode != null) {
            preNode = removeNode;
            removeNode = removeNode.nextNode;
        }
        preNode.nextNode = null;
        return removeNode.num;
    }

    @Override
    public int peek() {
        if (head == null) {
            throw new RuntimeException();
        }

        ListNode peekNode = head;
        while (peekNode.nextNode != null) {
            peekNode = peekNode.nextNode;
        }
        return peekNode.num;
    }
}
