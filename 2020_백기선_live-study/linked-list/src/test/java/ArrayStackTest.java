import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    @DisplayName("push메서드에서 인덱스가 스택의 범위를 초과하면 예외가 발생한다")
    void pushTest01() {
        //given
        int max = 50;
        Stack stack = new ArrayStack(max);

        //when then
        assertThrows(RuntimeException.class, () -> {
            for(int i=0; i<=max; i++) {
                stack.push(i);
            }
        });
    }

    @Test
    @DisplayName("push메서드에서 인덱스가 스택의 범위를 넘지않으면 정상 작동하고 가장 뒤에 값이 들어간다.")
    void pushTest02() {
        //given
        int max = 50;
        Stack stack = new ArrayStack(max);

        //when then
        assertAll(
                () -> assertDoesNotThrow(() -> {
                    for(int i=0; i<max; i++) {
                        stack.push(i);
                    }
                }),
                () -> assertEquals(max-1, stack.peek())
        );

    }

    @Test
    @DisplayName("pop메서드에서 스택이 비어있다면 예외가 발생한다")
    void popTest01() {
        //given
        int max = 0;
        Stack stack = new ArrayStack(max);

        //when then
        assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("pop메서드시 스택의 가장 뒤에 있는 값이 빠져나온다")
    void popTest02() {
        //given
        int max = 10;
        Stack stack = new ArrayStack(max);
        int size = 5;

        //when
        for(int i=0; i<size; i++) {
            stack.push(i);
        }
        int result = stack.pop();

        //then
        assertEquals(size-1, result);
    }

}