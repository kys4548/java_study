import javax.management.RuntimeMBeanException;

public class ArrayStack implements Stack<Integer> {
    //편의상 public 구현
    public int max;
    public int[] array;
    public int size;

    public ArrayStack(int max) {
        this.max = max;
        this.array = new int[max];
        this.size = 0;
    }

    @Override
    public void push(Integer data) {
        if(size >= max) {
            throw new RuntimeException();
        }
        array[size++] = data;
    }

    @Override
    public int pop() {
        if(size <= 0) {
            throw new RuntimeException();
        }
        return array[--size];
    }

    @Override
    public int peek() {
        if(size == 0) {
            throw new RuntimeException();
        }
        return array[size-1];
    }
}
