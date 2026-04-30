import org.w3c.dom.Node;
import java.util.NoSuchElementException;
import java.util.List;

public class CustomList<T> {
    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    // Указатели на начало и конец
    private Node head;
    private Node tail;

    // 1. void addLast(T value) - добавляет значение в конец списка
    public void addLast(T value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 2. T getLast() - возвращает значение с конца списка
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException("Lista jest pusta!");
        }
        return tail.value;
    }

    // 3. void addFirst(T value) - добавляет значение в начало списка
    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // 4. T getFirst() - возвращает значение из начала списка
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Lista jest pusta!");
        }
        return head.value;
    }

    // 5. T removeFirst() - возвращает и удаляет элемент из начала списка
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Lista jest pusta!");
        }
        T valueToReturn = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        return valueToReturn;
    }

    // 6. T removeLast() - возвращает и удаляет элемент с конца списка
    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("Lista jest pusta!");
        }

        T valueToReturn = tail.value;

        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            // Идем с самого начала, пока не найдем элемент ПЕРЕД хвостом
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        return valueToReturn;
    }
}
