import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {
    @Test
    @DisplayName("push메서드에서 head가 null이라면 새로 들어온 ListNode가 head가 된다.")
    void pushTest01() {
        //given
        Stack stack = new ListNodeStack();
        ListNode listNode = new ListNode(453523);

        //when
        stack.push(listNode);

        //then
        assertTrue(listNode, );
    }

    @Test
    @DisplayName("push메서드에서 인덱스가 스택의 범위를 넘지않으면 정상 작동하고 가장 뒤에 값이 들어간다.")
    void pushTest02() {
        //given
        Stack stack = new ListNodeStack();
    }

    @Test
    @DisplayName("pop메서드에서 스택이 비어있다면 예외가 발생한다")
    void popTest01() {
        //given
        Stack stack = new ListNodeStack();

    }

    @Test
    @DisplayName("pop메서드시 스택의 가장 뒤에 있는 값이 빠져나온다")
    void popTest02() {
        //given
        Stack stack = new ListNodeStack();
    }

}