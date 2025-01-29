import java.util.Vector;

import main.model.IStack;


public class VectorStack<T> implements IStack<T> {
    private Vector<T> stack;

    public VectorStack() {
        stack = new Vector<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return stack.lastElement();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

