/**
 * Interfaz genérica para la estructura de datos Pila (Stack).
 */
public interface IStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
